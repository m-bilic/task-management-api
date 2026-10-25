package com.mbilic.taskmanagementapi.exception;

public class TaskNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TaskNotFoundException(long taskId) {
		super("Task " + taskId + " not found.");
	}
}
