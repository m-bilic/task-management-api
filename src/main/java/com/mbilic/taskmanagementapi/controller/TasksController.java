package com.mbilic.taskmanagementapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mbilic.taskmanagementapi.dto.Task;
import com.mbilic.taskmanagementapi.service.TaskService;

@RestController
@RequestMapping("tasks")
public class TasksController {
	final TaskService taskService;
	
	public TasksController(TaskService taskService) {
		this.taskService = taskService;
	}
	
	@GetMapping(path = "", produces = "application/json") 
	public List<Task> getTasks(){
		return taskService.getTasks();		
	}
}
