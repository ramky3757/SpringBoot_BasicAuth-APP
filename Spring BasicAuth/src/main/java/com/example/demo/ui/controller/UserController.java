package com.example.demo.ui.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ui.model.request.User;

@RestController
@RequestMapping("/users")
public class UserController {

	@GetMapping(path= "/{userId}/employee/{empName}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String validateAccess(@PathVariable("userId") String id, @PathVariable("empName") String name) {
		
		return "This is the id received  "+id+ "  This is the name receivd "+name;
		
		
	}	
	
	@GetMapping(path= {"/employee"})
	public User returnEmployee() {
		
		User udm = new User("Ram", "Kumar", "*******@gmail.com", "****");
		
		return udm;
		
	}
	
}
