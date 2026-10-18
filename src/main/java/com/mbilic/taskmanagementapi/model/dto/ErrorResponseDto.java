package com.mbilic.taskmanagementapi.model.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ErrorResponseDto (int status, String message, List<ErrorDto> error) {

}
