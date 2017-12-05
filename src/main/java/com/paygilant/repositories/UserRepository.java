package com.paygilant.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import com.paygilant.entities.User;



public interface UserRepository extends MongoRepository<User, String> {

}
