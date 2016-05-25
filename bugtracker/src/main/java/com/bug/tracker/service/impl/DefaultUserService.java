package com.bug.tracker.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bug.tracker.entity.Role;
import com.bug.tracker.entity.User;
import com.bug.tracker.repository.UserRepository;
import com.bug.tracker.service.UserService;

@Service
@Transactional
public class DefaultUserService implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	public void save(User user){
		// activate user
		user.setEnabled(true);
		
		userRepository.save(user);
	}

	@Override
	public User findByusername(String username) {
		return userRepository.findByusername(username);
	}

	@Override
	public Long countByRoles(Role role) {
		return userRepository.countByRoles(role);
	}
}
