package com.mbilic.taskmanagementapi.repository;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;

import com.mbilic.taskmanagementapi.model.entity.AppUser;
import com.mbilic.taskmanagementapi.model.entity.Task;

public interface AppUserRepository extends ListCrudRepository<AppUser, Long> {
	List<AppUser> findByName(String name);
}
