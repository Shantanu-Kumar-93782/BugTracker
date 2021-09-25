package com.BugTracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.BugTracker.dao.SessionFactoryCreator;

@SpringBootApplication
public class BugTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BugTrackerApplication.class, args);
	}

	@Bean
	public SessionFactoryCreator sessionFeactoryCreator() {
		return new SessionFactoryCreator();
	}
}
