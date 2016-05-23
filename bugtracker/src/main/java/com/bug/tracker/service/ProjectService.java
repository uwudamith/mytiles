package com.bug.tracker.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bug.tracker.entity.Project;

public interface ProjectService {
	Project findByName(String name);
	void save(Project project);
	List<Project> findAll();
	Page<Project> findByNameOrderByIdDesc(Pageable pageable);
}
