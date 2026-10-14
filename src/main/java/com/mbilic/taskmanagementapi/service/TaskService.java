package com.mbilic.taskmanagementapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mbilic.taskmanagementapi.mapper.TaskMapper;
import com.mbilic.taskmanagementapi.model.dto.TaskRequestDto;
import com.mbilic.taskmanagementapi.model.dto.TaskResponseDto;
import com.mbilic.taskmanagementapi.model.entity.Task;
import com.mbilic.taskmanagementapi.repository.TaskRepository;

@Service
public class TaskService {
	private final TaskRepository taskRepository;

	public TaskService(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}

	public List<TaskResponseDto> getTasks() {
		return taskRepository.findAll().stream()
				.map(TaskMapper::toDto).toList();
	}

	public TaskResponseDto getTask(long id) {
		return taskRepository.findById(id)
				.map(TaskMapper::toDto)
				.orElseThrow();

	}

	public TaskResponseDto createTask(TaskRequestDto taskDto) {
		Task task = TaskMapper.toEntity(taskDto);
		task = taskRepository.save(task);
		
		return TaskMapper.toDto(task);
	}

	public TaskResponseDto updateTask(long id, TaskRequestDto taskDto) {
		Task task = taskRepository.findById(id).orElseThrow();
		task.setTitle(taskDto.title());
		
		return TaskMapper.toDto(taskRepository.save(task));
	}

	public void deleteTask(long id) {
		Task task = taskRepository.findById(id).orElseThrow();
		
		taskRepository.delete(task);
	}
}
