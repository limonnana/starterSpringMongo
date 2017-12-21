package com.paygilant.ws;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.paygilant.clients.UserClient;
import com.paygilant.entities.User;
import com.paygilant.repositories.UserRepository;



@RestController
public class UserWS {
	
	private static final Logger LOGGER =  LoggerFactory.getLogger(UserWS.class);
	
	@Autowired
	private UserClient userClient;
	
	@Autowired
	UserRepository userRepository;
	
	@RequestMapping("/users")
	public String getUsers() {
		
		return userClient.getUsers();
	}
	
	@RequestMapping("/setuser")
	public void setUser() {
		 User u = new User();
		 u.setName("Eyal");
		 u.setLastName("Rosenzvaig");
		 u.setEmail("rosenzvaig@gmail.com");
		 u.setId(u.getEmail());
		 userRepository.save(u);
	}
	
	@RequestMapping("/getuserbyemail/{email}")
	public String getUserByEmail(@PathVariable("email")String email) {
		return userClient.getUserByEmail(email);
	}
	
	@RequestMapping("/getuserbyname/{name}")
	public String getUserByName(@PathVariable("name")String name) {
		return userClient.getUserByEmail(name);
	}

}
