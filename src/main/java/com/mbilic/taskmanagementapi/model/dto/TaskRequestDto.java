package com.mbilic.taskmanagementapi.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record TaskRequestDto (
			@NotBlank(message="Title is not optional")
			@Size(min=4, message="Title needs to be at least 4 characters")
			@Size(max=255, message="Title cannot exceed 255 characters")
			String title
		) {}