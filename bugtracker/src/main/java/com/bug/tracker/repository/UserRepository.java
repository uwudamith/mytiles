package com.bug.tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bug.tracker.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByusername(String username);
}
