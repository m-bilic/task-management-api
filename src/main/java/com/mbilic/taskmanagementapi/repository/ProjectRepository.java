package com.mbilic.taskmanagementapi.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.mbilic.taskmanagementapi.model.entity.Project;

public interface ProjectRepository extends ListCrudRepository<Project, Long> {

}
