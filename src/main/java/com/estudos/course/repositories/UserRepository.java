package com.estudos.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudos.course.entities.User;

/* Aqui poderia colocar a Annotation @Repository, mas isso não é necessário pois a interface 
já extende de JPARepository, que já tem uma Annotation equivalente */
public interface UserRepository extends JpaRepository<User, Long>{

}
