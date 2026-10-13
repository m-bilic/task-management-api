package com.mbilic.taskmanagementapi.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mbilic.taskmanagementapi.model.entity.Task;
import com.mbilic.taskmanagementapi.service.TaskService;

@RestController
@RequestMapping("tasks")
public class TaskController {
	private final TaskService taskService;
	
	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}
	
	@GetMapping 
	public ResponseEntity<List<Task>> getTasks(){
		return ResponseEntity.ok(taskService.getTasks());		
	}
	
	@GetMapping("/{id}") 
	public ResponseEntity<Task> getTask(@PathVariable long id){
		return ResponseEntity.ok(
				taskService.getTask(id)
				);	
	}
	
	@PostMapping
	public ResponseEntity<Task> postTask(@RequestBody Task task) {
		Task resultTask = taskService.createTask(task.getTitle());
		
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(resultTask.getId())
				.toUri();
		
		return ResponseEntity.created(uri)
				.body(resultTask);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Task> putTask(@PathVariable long id, @RequestBody Task task) {
		return ResponseEntity.ok(
				taskService.updateTask(id, task.getTitle())
				);	
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping(path = "/{id}", produces = "application/json")
	public void deleteTask(@PathVariable long id) {
		taskService.deleteTask(id);
	}
}
