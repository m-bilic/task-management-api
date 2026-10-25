package com.mbilic.taskmanagementapi.mapper;

import com.mbilic.taskmanagementapi.model.dto.TaskRequestDto;
import com.mbilic.taskmanagementapi.model.dto.TaskResponseDto;
import com.mbilic.taskmanagementapi.model.entity.AppUser;
import com.mbilic.taskmanagementapi.model.entity.Project;
import com.mbilic.taskmanagementapi.model.entity.Task;

public class TaskMapper {
	public static TaskResponseDto toDto(Task entity) {
		return new TaskResponseDto (
				entity.getId(),
				entity.getTitle(),
				entity.getProject().getId(),
				entity.getAssignee().getId());
	}
	
	public static Task toEntity(TaskRequestDto dto, 
			Project project, 
			AppUser assignee) {
		return new Task(
				dto.title(),
				project,
				assignee);
	}
}
