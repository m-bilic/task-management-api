package com.mbilic.taskmanagementapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.ListCrudRepository;

import com.mbilic.taskmanagementapi.model.entity.Task;

public interface TaskRepository extends ListCrudRepository<Task, Long> {
	List<Task> findByTitle(String title);
	Optional<Task> findByIdAndProjectIdAndAssigneeId(Long id, Long projectId, Long assigneeId);
}
