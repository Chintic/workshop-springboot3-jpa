package com.estudos.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudos.course.entities.User;
import com.estudos.course.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService service;
	
	//GET (Vem do Rest: GET, POST, PUT e DELETE. Este é o GET	
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	/*@GetMapping
	public User findAll(){
		User u = new User(1L, "Maria", "maria@gmail.com", "99999999", "12345");
		return u;
	}
	Esta maneira também funciona, mas assim o método não está retornando um ResponseEntity.
	*/
	
}
