package com.bug.tracker.service;

import com.bug.tracker.entity.Role;

public interface RoleService {
	Role findByName(String roleName);
	void save(Role role);
}
