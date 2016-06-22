package com.bug.tracker.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bug.tracker.entity.Project;
import com.bug.tracker.entity.User;

public interface ProjectRepository extends JpaRepository<Project, Integer>{
	Project findByName(String name);
	Page<Project> findByNameOrderByIdDesc(Pageable pageable);
	
	@Query("SELECT u FROM Project as pj "
			+ "inner join pj.assignedUser as u "
			+ "where pj.id=:projectid and u.id=:userid")
	User findUser(@Param("projectid") int projectId,@Param("userid") int userid);
	

}
