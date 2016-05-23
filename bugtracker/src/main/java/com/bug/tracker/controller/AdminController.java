package com.bug.tracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bug.tracker.entity.Project;
import com.bug.tracker.service.ProjectService;
import com.bug.tracker.wrapper.PageWrapper;

@Controller
public class AdminController {

	@Autowired
	ProjectService projectService;
	
	 @RequestMapping(value = "/admin", method = RequestMethod.GET)
	  public String adminPage(Model model,Pageable pageable) {
		 
		 Page<Project> data = projectService.findByNameOrderByIdDesc(pageable);
		 PageWrapper<Project> page = new PageWrapper<Project>(data, "/admin");
	 
	      model.addAttribute("title", "Admin");
	      model.addAttribute("current", "admin");
	      model.addAttribute("child", "dashboard");
	      model.addAttribute("page", page);
	      model.addAttribute("data", data);

	      return "adminPage";
	  }

}
