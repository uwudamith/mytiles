package com.bug.tracker.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
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

	@Override
	public Page<Role> findAll(Pageable pageable) {
		return roleRepository.findAll(pageable);
	}

	@Override
	public Role findById(int id) {
		return roleRepository.findOne(id);
	}

	@Override
	public void deleteRole(int id) {
		roleRepository.delete(id);
	}

	@Override
	public List<Role> findAll() {
		return roleRepository.findAll();
	}

	@Override
	public List<Role> findByIdIn(List<Integer> idList) {
		return roleRepository.findByIdIn(idList);
	}
	
}
