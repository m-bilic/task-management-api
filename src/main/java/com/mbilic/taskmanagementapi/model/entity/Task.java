package com.mbilic.taskmanagementapi.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class Task {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	
	@ManyToOne (fetch=FetchType.LAZY)
	private Project project;
	
	@ManyToOne (fetch=FetchType.LAZY)
	private AppUser assignee;
	
	public Task(String title, 
			@NotNull Project project, 
			@NotNull AppUser user) {
		super();
		this.title = title;
		this.project = project;
		this.assignee = user;
	}
	
	protected Task() {
		super();
	}

	@Override
    public String toString() {
        return String.format(
                "Task[id=%d, title='%s']",
                id, title);
    }
	
	public Long getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public AppUser getAssignee() {
		return assignee;
	}

	public void setAssignee(AppUser asignee) {
		this.assignee = asignee;
	}
	
	
}
