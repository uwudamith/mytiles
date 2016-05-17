package com.bug.tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bug.tracker.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer>{
	Project findByName(String name);
}
