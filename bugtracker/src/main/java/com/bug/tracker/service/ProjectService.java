package com.bug.tracker.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import com.bug.tracker.entity.Project;
import com.bug.tracker.entity.User;

public interface ProjectService {
	Project findByName(String name);
	void save(Project project);
	List<Project> findAll();
	Page<Project> findByNameOrderByIdDesc(Pageable pageable);
	Project findOne(int id);
	void delete(int id);
	User findUser(int projectId,int userid);
	void deleteAssignedUser(int projectid, int userid);
}
