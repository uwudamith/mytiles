package com.bug.tracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bug.tracker.service.ProjectService;

@Controller
public class AdminController {

	@Autowired
	ProjectService projectService;
	
	 @RequestMapping(value = "/admin", method = RequestMethod.GET)
	  public String adminPage(Model model) {
	      model.addAttribute("title", "Admin");
	      model.addAttribute("current", "admin");
	      model.addAttribute("child", "dashboard");
	      model.addAttribute("projects",projectService.findAll());
	      return "adminPage";
	  }

}
