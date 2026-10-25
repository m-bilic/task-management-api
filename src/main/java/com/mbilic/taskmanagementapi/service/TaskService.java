package com.mbilic.taskmanagementapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mbilic.taskmanagementapi.exception.ResourceNotFoundException;
import com.mbilic.taskmanagementapi.mapper.TaskMapper;
import com.mbilic.taskmanagementapi.model.dto.TaskRequestDto;
import com.mbilic.taskmanagementapi.model.dto.TaskResponseDto;
import com.mbilic.taskmanagementapi.model.entity.AppUser;
import com.mbilic.taskmanagementapi.model.entity.Project;
import com.mbilic.taskmanagementapi.model.entity.Task;
import com.mbilic.taskmanagementapi.repository.AppUserRepository;
import com.mbilic.taskmanagementapi.repository.ProjectRepository;
import com.mbilic.taskmanagementapi.repository.TaskRepository;

@Service
public class TaskService {
	private final TaskRepository taskRepository;
	private final ProjectRepository projectRepository;
	private final AppUserRepository userRepository;
	

	public TaskService(TaskRepository taskRepository, 
			ProjectRepository projectRepository,
			AppUserRepository userRepository) {
		this.taskRepository = taskRepository;
		this.projectRepository = projectRepository;
		this.userRepository = userRepository;
	}

	public List<TaskResponseDto> getTasks() {
		return taskRepository.findAll().stream()
				.map(TaskMapper::toDto).toList();
	}

	public TaskResponseDto getTask(long id) {
		Task task = findTaskOrThrow(id);
		
		return TaskMapper.toDto(task);

	}

	public TaskResponseDto createTask(TaskRequestDto taskDto) {
		AppUser assignee = findAppUserOrThrow(taskDto.assigneeId());
		Project project = findProjectOrThrow(taskDto.projectId());
		
		Task task = TaskMapper.toEntity(taskDto, project, assignee);
		task = taskRepository.save(task);
		
		return TaskMapper.toDto(task);
	}

	public TaskResponseDto updateTask(long id, TaskRequestDto taskDto) {
		Task task = findTaskOrThrow(id);
		
		AppUser assignee = findAppUserOrThrow(taskDto.assigneeId());
		Project project = findProjectOrThrow(taskDto.projectId());
		
		task.setTitle(taskDto.title());
		task.setAssignee(assignee);
		task.setProject(project);
		
		return TaskMapper.toDto(taskRepository.save(task));
	}

	public void deleteTask(long id) {
		Task task = findTaskOrThrow(id);
		
		taskRepository.delete(task);
	}
	
	private Task findTaskOrThrow(long id) {
		return taskRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(Task.class, id));
	}
	
	private AppUser findAppUserOrThrow(long id) {
		return userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(AppUser.class, id));
	}
	
	private Project findProjectOrThrow(long id) {
		return projectRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(Project.class, id));
	}
}
