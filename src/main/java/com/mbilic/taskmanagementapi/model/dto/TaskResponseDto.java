package com.mbilic.taskmanagementapi.model.dto;

public record TaskResponseDto (
			Long id, 
			String title, 
			Long projectId, 
			Long assigneeId
		) {}
