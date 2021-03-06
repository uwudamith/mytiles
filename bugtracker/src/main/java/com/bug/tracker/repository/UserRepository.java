package com.bug.tracker.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.bug.tracker.entity.Role;
import com.bug.tracker.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByusername(String username);
	Long countByRoles(Role role);
	Page<User> findAllByNameContainingIgnoreCase(String name,Pageable pageable);
}
