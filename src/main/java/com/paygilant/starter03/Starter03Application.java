package com.paygilant.starter03;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import com.google.gson.Gson;
import com.paygilant.entities.User;
import com.paygilant.repositories.UserRepository;


@EnableMongoRepositories(value = "com.paygilant.repositories")
@SpringBootApplication(scanBasePackages="com.paygilant")
public class Starter03Application extends SpringBootServletInitializer{
	
	
	private static final Logger LOGGER =  LoggerFactory.getLogger(Starter03Application.class);
	
	@Autowired
	UserRepository userRepository;
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Starter03Application.class);
    }
	
	@Bean
    public MongoTemplate mongoTemplate(MongoDbFactory mongoDbFactory,
                                       MongoMappingContext context) {

        MappingMongoConverter converter =
                new MappingMongoConverter(new DefaultDbRefResolver(mongoDbFactory), context);
        converter.setTypeMapper(new DefaultMongoTypeMapper(null));

        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory, converter);

        return mongoTemplate;

    }

	public static void main(String[] args) {
		SpringApplication.run(Starter03Application.class, args);
	}
	
	/*
	 @Bean
	    public CommandLineRunner commandLineRunner(ApplicationContext ctx) 
	    {
	        return args -> 
	        {
	           // main();
	        	LOGGER.info("UserList: " + getUsers());
	        	
	        };
	    }
	 */
	 private void main() {
		 User u = new User();
		 u.setName("Eyal");
		 u.setLastName("Rosenzvaig");
		 u.setEmail("rosenzvaig@gmail.com");
		 u.setId(u.getEmail());
		 userRepository.save(u);
	 }
	 
	 private String getUsers() {
		 List<User> userList = userRepository.findAll();
		 Gson g = new Gson();
		 return g.toJson(userList);
	 }
}
