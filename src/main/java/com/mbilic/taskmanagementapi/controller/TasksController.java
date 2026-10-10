package com.mbilic.taskmanagementapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mbilic.taskmanagementapi.dto.Task;

@RestController
@RequestMapping("tasks")
public class TasksController {
	@GetMapping(path = "/predefined", produces = "application/json") 
	public List<Task> getGreetingMessage(){
		List<Task> ret = List.of(new Task("Create a Hello Endpoint"),
				new Task("Create a Task class"));
		
		return ret;
	}
}
