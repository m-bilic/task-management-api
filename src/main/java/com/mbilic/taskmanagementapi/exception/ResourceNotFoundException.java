package com.mbilic.taskmanagementapi.exception;

public class ResourceNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(Class<?> resourceType, long id) {
		super(resourceType.getSimpleName() + " " + id + " not found.");
	}
}
