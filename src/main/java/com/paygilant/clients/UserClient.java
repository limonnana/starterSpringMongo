package com.paygilant.clients;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
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

	public String getUserByEmail(String email) {
     
		Query query = new Query();
		query.addCriteria(Criteria.where("email").is(email));
	
			   	
		User u = new User();
		u.setEmail("rosenzvaig@gmail.com");
		Example<User> e = Example.of(u);
		User user = userRepository.findOne(e);
		Gson gson = new Gson();
		String result = gson.toJson(user);
		return result;
	}

}
