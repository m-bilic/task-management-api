package com.mbilic.taskmanagementapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping(path = "/{id}", produces = "application/json") 
	public Task getTask(@PathVariable long id){
		return taskService.getTask(id);
	}
	
	@PostMapping(path = "", produces = "application/json")
	public void postTask(@RequestBody Task task) {
		taskService.createTask(task.getTitle());
	}
	
	@PutMapping(path = "/{id}", produces = "application/json")
	public void putTask(@PathVariable long id, @RequestBody Task task) {
		taskService.updateTask(id, task.getTitle());
	}
	
	@DeleteMapping(path = "/{id}", produces = "application/json")
	public void putTask(@PathVariable long id) {
		taskService.deleteTask(id);
	}
}
