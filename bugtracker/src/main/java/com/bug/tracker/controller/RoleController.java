package com.bug.tracker.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bug.tracker.entity.Role;
import com.bug.tracker.forms.RoleForm;
import com.bug.tracker.mappers.Populator;
import com.bug.tracker.service.RoleService;
import com.bug.tracker.service.UserService;
import com.bug.tracker.wrapper.PageWrapper;

@Controller
public class RoleController {
	private static final Logger logger = Logger.getLogger(ProjectController.class);
	
	@Autowired
	RoleService roleService;
	
	@Autowired
	UserService userService;
	
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
	
	@RequestMapping(value = "/role/all", method = RequestMethod.GET)
	  public String allRoles(Model model,Pageable pageable) {
		 
		 Page<Role> data = roleService.findAll(pageable);
		 PageWrapper<Role> page = new PageWrapper<Role>(data, "/role/all");
	 
	      model.addAttribute("current", "admin");
	      model.addAttribute("child", "all_roles");
	      model.addAttribute("page", page);

	      return "allRoles";
	  }
	
	@RequestMapping(value = "/role/view", method = RequestMethod.GET)
	public String viewRole(Model model,@RequestParam("id") int id) {

		Role r = roleService.findById(id);
		
		Populator<Role,RoleForm> map =new Populator<Role,RoleForm>();
		RoleForm form = map.convert(r, new RoleForm());
		
		model.addAttribute("current", "admin");
		model.addAttribute("child", "role_add");
		model.addAttribute("role", form);

		return "role";
	}
	
	@RequestMapping(value = "/role/delete", method = RequestMethod.GET)
	public String deleteRole(Model model,@RequestParam("id") int id) {

		long count =userService.countByRoles(roleService.findById(id));
		
		if(count > 0){
			return "redirect:/role/all?error=assigned";
		}else{
			roleService.deleteRole(id);
			
			return "redirect:/role/all?delete=true";
		}
	}
}
