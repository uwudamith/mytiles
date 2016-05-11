package com.bug.tracker.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bug.tracker.entity.Role;
import com.bug.tracker.repository.RoleRepository;
import com.bug.tracker.service.RoleService;

@Service
public class DefaultRoleService implements RoleService {

	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public Role findByName(String name) {
		return roleRepository.findByName(name);
	}

	@Override
	public void save(Role role) {
		roleRepository.save(role);
	}
	
}
