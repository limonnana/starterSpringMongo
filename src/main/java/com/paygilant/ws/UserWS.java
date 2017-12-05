package com.paygilant.ws;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.paygilant.clients.UserClient;
import com.paygilant.config.Config;


@RestController
public class UserWS {
	
	private static final Logger LOGGER =  LoggerFactory.getLogger(UserWS.class);
	
	@Autowired
	private UserClient userClient;
	
	@RequestMapping(Config.APP_NAME + "/users")
	public String getUsers() {
		
		return userClient.getUsers();
	}

}
