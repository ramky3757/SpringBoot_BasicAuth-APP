package com.example.dao;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.example.demo.ui.model.UserNotFoundException;
import com.example.demo.ui.model.request.User;

@Component
public class UserDAOService {

	 private static List<User> users = new ArrayList<User>();
	 private static Map<String, List<String>> posts = new HashMap<String, List<String>>();
	 private static List<String> post = new ArrayList<String>();
	
		static {			
			users.add(new User("Ram", "Krishna", "rams.amma@gmail.com", "****"));
			users.add(new User ("Prasad", "Sai", "rams.amma@gmail.com", "****"));
			users.add(new User("Raji", "Lakshmi", "rams.amma@gmail.com", "****"));
		}
		
		static {
			post.add("First post");	
			
			posts.put("Ram",post);
			posts.put("Prasad",post);
			posts.put("Raji",post);
			
		}
		
		
		public List<String> findAllPosts(String userName){
			
			for(User user: users) {
				
				if(user.getFirstName().equalsIgnoreCase(userName)) {					
					return posts.get(userName);					
				}
				
			}
			return null;			
		}
		
		public List<String> addPost(String userName, String post){
			
			List<String> User_posts = new ArrayList<String> ();
			
			for(User user: users) {				
				if(user.getFirstName().equalsIgnoreCase(userName)) {
					
					User_posts = posts.get(userName);
					User_posts.add(post);
					posts.put(userName, User_posts);
					
				}
			}
			
			return User_posts;
			
		}
	
	
		public List<User> findAll(){
			return users;
			
			
		}
		
		public User save(User user) {			
			
			if(user!=null) {
				
				users.add(user);
			}
			
			return user;			
		}

		public User getUser(String fName) {
			
			for(User user: users) {
				if(user.getFirstName().equalsIgnoreCase(fName)) {
					return user;
				}
			}			
		
				return null;
		}
		
		public List<User> deleteUser(User user) {	
			
			Iterator<User> it = users.iterator();
			
			while(it.hasNext()) {			
				User user1 = it.next();
				
				if(user1.getFirstName().equalsIgnoreCase(user.getFirstName())) {
					it.remove();
				}
			}	
			return users;
		}
		
	
}
