package com.example.demo.ui.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.dao.UserDAOService;
import com.example.demo.ui.model.UserNotFoundException;
import com.example.demo.ui.model.request.*;

@RestController
public class UserResource {

	@Autowired
	private UserDAOService service;
	
	@GetMapping("/allUsers")
	public List<User> getUsers(){		
		return service.findAll();		
	}
	
	@GetMapping("/allUsers/{name}")
	public User findUser(@PathVariable String name) {		
		User user = service.getUser(name);
		
		if(user == null) {
			throw new UserNotFoundException("name -"+name+ " Not found in Database ");
		}
		return service.getUser(name);
		
	}
	
	@PostMapping("/allUsers/addUser")
	public ResponseEntity<String> saveUser(@RequestBody User user) {
		service.save(user);
		
		return ResponseEntity.created(null).build();
				//ResponseEntity.(HttpStatus.CREATED).build();
	}
	
	@DeleteMapping("/allUsers/deleteUser")
	public List<User> deleteUser(@RequestBody User user) {		
		return service.deleteUser(user);
	}
}


