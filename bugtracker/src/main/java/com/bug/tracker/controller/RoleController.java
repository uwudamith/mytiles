package com.bug.tracker.controller;

import java.util.ArrayList;
import java.util.List;

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
import com.bug.tracker.entity.User;
import com.bug.tracker.forms.RoleForm;
import com.bug.tracker.forms.UserRoles;
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
	
	@RequestMapping(value = "/role/assign", method = RequestMethod.POST)
	public String saveAssignedRoles(@Valid @ModelAttribute("userRoles") UserRoles userRoles,BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors()) {
			List<Role> roles = roleService.findAll();
			model.addAttribute("roles", roles);
			return "manageRoles";
        }
		List<Role> roles = roleService.findByIdIn(userRoles.getSelectedRoles());
		userRoles.getUser().setRoles(roles);
		userService.save(userRoles.getUser());

		return "redirect:/user/all?rolesadded=true";
	}
	
	@RequestMapping(value = "/role/assign", method = RequestMethod.GET)
	public String assignRole(Model model,@RequestParam("userId") int userId) {
		
		User user = userService.findById(userId);
		List<Role> roles = roleService.findAll();
		
		UserRoles r = new UserRoles();
		r.setUser(user);
		model.addAttribute("user", user);
		model.addAttribute("roles", roles);
		r.setSelectedRoles(getSelectedRoles(user));
		model.addAttribute("userRoles",r);
		
		return "manageRoles";
	}
	
	private List<Integer> getSelectedRoles(User user){
		List<Integer> intList = new ArrayList<Integer>();
		for (Role role : user.getRoles()) {
			intList.add(role.getId());
		}
		return intList;
	}

}
