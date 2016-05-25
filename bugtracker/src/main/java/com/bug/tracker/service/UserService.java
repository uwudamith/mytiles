package com.bug.tracker.service;

import com.bug.tracker.entity.Role;
import com.bug.tracker.entity.User;

public interface UserService {
	public void save(User user);
	User findByusername(String username);
	Long countByRoles(Role role);
}
