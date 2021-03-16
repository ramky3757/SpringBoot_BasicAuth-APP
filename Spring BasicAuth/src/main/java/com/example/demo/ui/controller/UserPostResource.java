package com.example.demo.ui.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.UserDAOService;
import com.example.demo.ui.model.UserNotFoundException;

@RestController
@RequestMapping("/posts")
public class UserPostResource {
	
	@Autowired
	private UserDAOService service;
	
	
	@GetMapping("/{id}/post")
	public List<String> getPosts(@PathVariable String id){	
		
		if(service.findAllPosts(id) == null) {
			throw new UserNotFoundException("No posts available for this user");
		}
		return service.findAllPosts(id);		
	}
	
	@PostMapping("/{id}/post")
	public List<String> addPost(@PathVariable String id , @RequestBody String post){		
		return service.addPost(id, post);
	}
}
