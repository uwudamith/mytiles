package com.bug.tracker.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bug.tracker.entity.User;
import com.bug.tracker.forms.UserForm;
import com.bug.tracker.mappers.Populator;
import com.bug.tracker.service.UserService;
import com.bug.tracker.wrapper.PageWrapper;

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
		
		if(userForm.getId() > 0){
			User usr = userService.findById(userForm.getId());
			usr.setName(userForm.getName());
			usr.setEmail(userForm.getEmail());
			usr.setPassword(encode.encode(userForm.getPassword()));
			userService.save(usr);
			return "redirect:/user?update=true";
		}else{
			User usr = new User();
			usr.setName(userForm.getName());
			usr.setEmail(userForm.getEmail());
			usr.setUsername(userForm.getUsername());
			usr.setPassword(encode.encode(userForm.getPassword()));
			userService.save(usr);
			
			return "redirect:/user?save=true";
		}

	}
	
	@RequestMapping(value = "/user/all", method = RequestMethod.GET)
	  public String allUsers(Model model,Pageable pageable) {
		 
		 Page<User> data = userService.findAll(pageable);
		 PageWrapper<User> page = new PageWrapper<User>(data, "/user/all");
	 
	      model.addAttribute("current", "admin");
	      model.addAttribute("child", "all_users");
	      model.addAttribute("page", page);

	      return "allUsers";
	  }
	
	@RequestMapping(value = "/user/view", method = RequestMethod.GET)
	public String viewProject(ModelMap model,@RequestParam("id") int id ) {
		
		User user = userService.findById(id);
		Populator<User,UserForm> map =new Populator<User,UserForm>();
		UserForm form = map.convert(user, new UserForm());
		
		model.addAttribute("current", "admin");
		model.addAttribute("child", "user");
		model.addAttribute("userForm", form);
		
		return "user";
	}
	
	@RequestMapping(value = "/user/delete", method = RequestMethod.GET)
	public String deleteProject(ModelMap model,@RequestParam("id") int id ) {
		
		userService.delete(id);
		
		return "redirect:/user/all?delete=true";
	}
}
