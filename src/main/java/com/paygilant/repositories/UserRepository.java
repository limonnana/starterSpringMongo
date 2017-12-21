package com.paygilant.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.mongodb.connection.Stream;
import com.paygilant.entities.User;



public interface UserRepository extends MongoRepository<User, String> {

	
	//@Query("select c from User c where c.email = :email")
	//@Query("{email : email}")
	User findByEmail(@Param("email")String email);
	
	User findByName(@Param("name")String name);
}
