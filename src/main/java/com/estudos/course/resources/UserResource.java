package com.estudos.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudos.course.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	//GET (Vem do Rest: GET, POST, PUT e DELETE. Este é o GET	
	@GetMapping
	public ResponseEntity<User> findAll(){
		User u = new User(1L, "Maria", "maria@gmail.com", "99999999", "12345");
		return ResponseEntity.ok().body(u);
	}
	
	/*@GetMapping
	public User findAll(){
		User u = new User(1L, "Maria", "maria@gmail.com", "99999999", "12345");
		return u;
	}
	Esta maneira também funciona, mas assim o método não está retornando um ResponseEntity.
	*/
	
}
