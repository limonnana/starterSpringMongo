package com.paygilant.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paygilant.clients.UserClient;

@RestController
public class UserWS {
	
	@Autowired
	UserClient userClient;
	
	@RequestMapping("/users")
	public String getUsers() {
		return userClient.getUsers();
	}

}
