package com.bug.tracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.bug.tracker.service.UserService;

@RestController
public class UserRestController {

	@Autowired
	private UserService userService;
	
	
}
