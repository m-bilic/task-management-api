package com.mbilic.taskmanagementapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mbilic.taskmanagementapi.dto.Task;
import com.mbilic.taskmanagementapi.repository.TaskRepository;

@SpringBootApplication
public class TaskmanagementapiApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(TaskmanagementapiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TaskmanagementapiApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(TaskRepository repository) {
		return (args) -> {
			repository.save(new Task("Create a Hello endpoint"));
			repository.save(new Task("Create a Task class"));
			repository.save(new Task("Add the database"));
			repository.save(new Task("Create the service layer"));
			repository.save(new Task("Create the endpoints"));
			repository.save(new Task("Create request and response DTOs"));
			repository.save(new Task("Implement validation"));
			repository.save(new Task("Exception handling"));
			repository.save(new Task("Add User and Project entities"));
			repository.save(new Task("Configuration and polish"));
			
			logger.info("Tasks found with findAll():");
            logger.info("-------------------------------");
            repository.findAll().forEach(task -> {
                logger.info(task.toString());
            });
            logger.info("");
            
            // fetch an individual task by ID
            Task task = repository.findById(1L);
            logger.info("Task found with findById(1L):");
            logger.info("--------------------------------");
            logger.info(task.toString());
            logger.info("");

            // fetch task by last title
            logger.info("Task found with findByTitle('Configuration and polish'):");
            logger.info("--------------------------------------------");
            repository.findByTitle("Configuration and polish").forEach(configAndPolish -> {
                logger.info(configAndPolish.toString());
            });
            logger.info("");
		};
	}
}
