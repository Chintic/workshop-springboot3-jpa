package com.estudos.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.estudos.course.entities.User;
import com.estudos.course.repositories.UserRepository;
import com.estudos.course.services.exceptions.DatabaseException;
import com.estudos.course.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {
	
	/*Entender que algumas funções apenas repassam a chamada de um método do repository, 
	entenda que nesta classe em questão, poderemos adicioanr regras no futuro, fazendo assim jus a função da mesma.
	*/
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
	    try {
	        repository.deleteById(id);
	    // EmptyResultDataAccessException parece não estar sendo disparado, consequentemente não está sendo tratado. 
	    } catch (EmptyResultDataAccessException e) {
	    	throw new ResourceNotFoundException(id);
	    } catch (DataIntegrityViolationException e) {
	        throw new DatabaseException(e.getMessage());
	    }
	}
	
	public User update(Long id, User obj) {
		try{
			User entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
	    	throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
