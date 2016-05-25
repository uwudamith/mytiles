package com.bug.tracker.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bug.tracker.entity.Role;
import com.bug.tracker.entity.User;

public interface UserService {
	public void save(User user);
	User findByusername(String username);
	Long countByRoles(Role role);
	Page<User> findAll(Pageable pageable);
	void delete(int id);
	User findById(int id);
}
