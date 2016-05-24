package com.bug.tracker.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bug.tracker.entity.Project;
import com.bug.tracker.forms.ProjectForm;
import com.bug.tracker.mappers.Populator;
import com.bug.tracker.service.ProjectService;
import com.bug.tracker.wrapper.PageWrapper;

@Controller
public class ProjectController {
	
	@Autowired
	ProjectService projectService;
	
	 @RequestMapping(value = "/project/all", method = RequestMethod.GET)
	  public String adminPage(Model model,Pageable pageable) {
		 
		 Page<Project> data = projectService.findByNameOrderByIdDesc(pageable);
		 PageWrapper<Project> page = new PageWrapper<Project>(data, "/project/all");
	 
	      model.addAttribute("current", "admin");
	      model.addAttribute("child", "all_projects");
	      model.addAttribute("page", page);

	      return "allProjects";
	  }
	
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
	
	@RequestMapping(value = "/project/delete", method = RequestMethod.GET)
	public String deleteProject(ModelMap model,@RequestParam("id") long id ) {
		
		System.out.println("Deleting project with id : "+id);
		
		return "redirect:/project/all?delete=true";
	}
	
	@RequestMapping(value = "/project/view", method = RequestMethod.GET)
	public String viewProject(ModelMap model,@RequestParam("id") long id ) {
		
		System.out.println("Viewing project with id : "+id);
		
		ProjectForm projectForm = new ProjectForm();
		projectForm.setId(8);
		projectForm.setName("Test");
		model.addAttribute("current", "admin");
		model.addAttribute("child", "createproject");
		model.addAttribute("projectForm", projectForm);
		
		return "project";
	}
}
