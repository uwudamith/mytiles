package com.bug.tracker.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bug.tracker.entity.User;
import com.bug.tracker.forms.UserForm;
import com.bug.tracker.mappers.Populator;
import com.bug.tracker.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	
	BCryptPasswordEncoder encode = new BCryptPasswordEncoder();
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String project(ModelMap model) {
		UserForm userForm = new UserForm();
		model.addAttribute("current", "admin");
		model.addAttribute("child", "user");
		model.addAttribute("userForm", userForm);
		return "user";
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String createUpdateUser(@Valid @ModelAttribute("userForm") UserForm userForm ,BindingResult bindingResult,ModelMap model) {
		if (bindingResult.hasErrors()) {
            return "user";
        }
		
		Populator<UserForm, User> map =new Populator<UserForm, User>();
		User usr = map.convert(userForm, new User());
		usr.setPassword(encode.encode(usr.getPassword()));
		userService.save(usr);
		
		return "redirect:/user?save=true";
	}
}
