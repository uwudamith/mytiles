package com.bug.tracker.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bug.tracker.entity.Project;
import com.bug.tracker.forms.ProjectForm;
import com.bug.tracker.mappers.Populator;
import com.bug.tracker.service.ProjectService;

@Controller
public class ProjectController {
	
	@Autowired
	ProjectService projectService;
	
	@RequestMapping(value = "/project", method = RequestMethod.GET)
	public String project(ModelMap model) {
		ProjectForm projectForm = new ProjectForm();
		model.addAttribute("current", "admin");
		model.addAttribute("child", "createproject");
		model.addAttribute("projectForm", projectForm);
		return "project";
	}
	
	@RequestMapping(value = "/project", method = RequestMethod.POST)
	public String insertOrUpdate(@Valid @ModelAttribute("projectForm") ProjectForm projectForm, BindingResult bindingResult,ModelMap model) {
		if (bindingResult.hasErrors()) {
            return "project";
        }
		
		Populator<ProjectForm, Project> map =new Populator<ProjectForm, Project>();
		Project pj = map.convert(projectForm, new Project());
		projectService.save(pj);
		
		return "redirect:/project?save=true";
	}
}
