package com.bug.tracker.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bug.tracker.entity.Role;

public interface RoleService {
	Role findByName(String roleName);
	void save(Role role);
	Page<Role> findAll(Pageable pageable);
	Role findById(int id);
	void deleteRole(int id);
	List<Role> findAll();
	List<Role> findByIdIn(List<Integer> idList);
}
