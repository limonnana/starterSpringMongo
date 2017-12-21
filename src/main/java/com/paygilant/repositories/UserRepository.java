package com.paygilant.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.mongodb.connection.Stream;
import com.paygilant.entities.User;



public interface UserRepository extends MongoRepository<User, String> {

	
	
	User findByEmail(@Param("email")String email);
	
	User findByName(@Param("name")String name);
	
	@Query("{'lastName': ?0}")
	List<User> findByLastName(final String lastName);
}
