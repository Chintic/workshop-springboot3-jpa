package com.estudos.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudos.course.entities.User;
import com.estudos.course.repositories.UserRepository;

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
		return obj.get();
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
}
