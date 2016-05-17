package com.bug.tracker.service;

import com.bug.tracker.entity.Project;

public interface ProjectService {
	Project findByName(String name);
	void save(Project project);
}
