package com.bug.tracker.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bug.tracker.entity.Project;
import com.bug.tracker.entity.Role;
import com.bug.tracker.forms.ProjectForm;
import com.bug.tracker.forms.RoleForm;
import com.bug.tracker.mappers.Populator;
import com.bug.tracker.service.RoleService;

@Controller
public class RoleController {
	
	@Autowired
	RoleService roleService;
	
	@RequestMapping(value = "/role/add", method = RequestMethod.GET)
	public String role(Model model) {

		RoleForm role = new RoleForm();
		model.addAttribute("current", "admin");
		model.addAttribute("child", "role_add");
		model.addAttribute("role", role);

		return "role";
	}
	
	@RequestMapping(value = "/role/add", method = RequestMethod.POST)
	public String saveRole(@Valid @ModelAttribute("role") RoleForm roleForm,BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors()) {
            return "role";
        }
		
		Populator<RoleForm, Role> map =new Populator<RoleForm, Role>();
		Role role = map.convert(roleForm, new Role());
		
		roleService.save(role);

		return "redirect:/role/add?save=true";
	}
}
