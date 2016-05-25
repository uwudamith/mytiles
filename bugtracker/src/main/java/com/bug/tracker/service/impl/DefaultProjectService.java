package com.bug.tracker.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

	@Override
	public List<Project> findAll() {
		return projectRepository.findAll();
	}

	@Override
	public Page<Project> findByNameOrderByIdDesc(Pageable pageable) {
		return projectRepository.findAll(pageable);
	}

	@Override
	public Project findOne(int id) {
		return projectRepository.findOne(id);
	}

	@Override
	public void delete(int id) {
		projectRepository.delete(id);
	}

}
