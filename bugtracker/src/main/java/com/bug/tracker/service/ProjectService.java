package com.bug.tracker.service;

import java.util.List;

import com.bug.tracker.entity.Project;

public interface ProjectService {
	Project findByName(String name);
	void save(Project project);
	List<Project> findAll();
}
