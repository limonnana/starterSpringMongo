package com.paygilant.clients;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.paygilant.entities.User;
import com.paygilant.repositories.UserRepository;


@Component
public class UserClient {
	
	@Autowired
	UserRepository userRepository;
	
	public String getUsers() {
		 List<User> userList = userRepository.findAll();
		 Gson g = new Gson();
		 return g.toJson(userList);
	}

}
