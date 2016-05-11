package com.bug.tracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {

	 @RequestMapping(value = "/admin", method = RequestMethod.GET)
	  public String adminPage(Model model) {
	      model.addAttribute("title", "Admin");
	      model.addAttribute("message", "Admin Page - This is protected page!");
	      return "adminPage";
	  }

}
