package com.mbilic.taskmanagementapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.ListCrudRepository;

import com.mbilic.taskmanagementapi.dto.Task;

public interface TaskRepository extends ListCrudRepository<Task, Long> {
	List<Task> findByTitle(String title);
	
	Optional<Task> findById(long id);
}
