package com.paygilant.clients;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.core.MongoTemplate;
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
	
	@Autowired
    MongoTemplate mongoTemplate;

	public String getUsers() {
		List<User> userList = userRepository.findAll();
		Gson g = new Gson();
		return g.toJson(userList);
	}
	
	public String getUserByMailCustom(String email) {
		
		String result = "Users list is empty";
		Query query = new Query(Criteria.where("email").is(email));
		List<User> l = mongoTemplate.find(query, User.class);
		Gson gson = new Gson();
		if(l != null && !l.isEmpty()) {
			 result = gson.toJson(l.get(0));
		}
		return result;
	}

	public String getUserByEmail(String email) {
     
		User u = new User();
		u.setEmail("rosenzvaig@gmail.com");
		Example<User> e = Example.of(u);
		User user = userRepository.findOne(e);
		Gson gson = new Gson();
		String result = gson.toJson(user);
		return result;
	}
	
	public String getUsersByLastName(String lastName){
		
		List<User> users = userRepository.findByLastName(lastName);
		Gson gson = new Gson();
		String result = gson.toJson(users);
		return result;
	}

}
