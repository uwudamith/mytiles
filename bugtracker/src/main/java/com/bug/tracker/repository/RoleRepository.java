package com.bug.tracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bug.tracker.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	Role findByName(String name);
	List<Role> findByIdIn(List<Integer> idList);
}
