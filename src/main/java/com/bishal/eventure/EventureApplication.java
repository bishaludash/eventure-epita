package com.bishal.eventure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@Configuration
@EnableMongoAuditing
@SpringBootApplication
public class EventureApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventureApplication.class, args);
	}

}
