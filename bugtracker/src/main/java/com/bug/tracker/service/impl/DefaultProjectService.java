package com.bug.tracker.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bug.tracker.entity.Project;
import com.bug.tracker.repository.ProjectRepository;
import com.bug.tracker.service.ProjectService;

@Service
public class DefaultProjectService implements ProjectService {

	@Autowired
	private ProjectRepository projectRepository;
	
	@Override
	public Project findByName(String name) {
		return projectRepository.findByName(name);
	}

	@Override
	public void save(Project project) {
		projectRepository.save(project);		
	}

}
