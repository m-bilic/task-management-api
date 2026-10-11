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
}
