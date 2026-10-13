package com.mbilic.taskmanagementapi.mapper;

import com.mbilic.taskmanagementapi.model.dto.TaskRequestDto;
import com.mbilic.taskmanagementapi.model.dto.TaskResponseDto;
import com.mbilic.taskmanagementapi.model.entity.Task;

public class TaskMapper {
	public static TaskResponseDto toDto(Task entity) {
		return new TaskResponseDto (
				entity.getId(),
				entity.getTitle());
	}
	
	public static Task toEntity(TaskRequestDto dto) {
		return new Task(
				dto.title());
	}
}
