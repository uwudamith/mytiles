package com.my.tiles.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	  public String loginPage(Model model) {
	      model.addAttribute("title", "Login");
	      model.addAttribute("message", "Enter your username/password:");
	      return "loginPage";
	  }
	  
}
