package com.mbilic.taskmanagementapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mbilic.taskmanagementapi.dto.Task;
import com.mbilic.taskmanagementapi.repository.TaskRepository;

@Service
public class TaskService {
	final TaskRepository taskRepository;
	
	public TaskService(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}
	
	public List<Task> getTasks() {
		return taskRepository.findAll();
	}
	
	public Task getTask(long id) {
		return taskRepository.findById(id).orElseThrow();
	}
	
	public void createTask(String title) {
		taskRepository.save(new Task(title));
	}
	
	public void updateTask(long id, String title) {
		taskRepository.findById(id)
			.map(existing -> {
				existing.setTitle(title);
				return taskRepository.save(existing);
				});
	}
	
	public void deleteTask(long id) {
		taskRepository.deleteById(id);
	}
}
