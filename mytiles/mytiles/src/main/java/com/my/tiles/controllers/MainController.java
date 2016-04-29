package com.my.tiles.controllers;

import java.security.Principal;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

	private static String USER_INFO_URL = "/userInfo";
	
	 @RequestMapping(value = "/admin", method = RequestMethod.GET)
	  public String adminPage(Model model) {
	      model.addAttribute("title", "Admin");
	      model.addAttribute("message", "Admin Page - This is protected page!");
	      return "adminPage";
	  }
	 
	 @RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	  public String loginPage(Model model) {
	      model.addAttribute("title", "Login");
	      model.addAttribute("message", "Enter your username/password:");
	      return "loginPage";
	  }
	 
	 @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
	  public String loginPage(Locale locale,Model model, Principal principal) {
	      model.addAttribute("title", "User Info");
	      String userName = principal.getName();
	 
	      model.addAttribute("message",
	              "User Info - This is protected page!. Hello " + userName);
	 
	      return "userInfoPage";
	  }
	 
	  @RequestMapping(value = "/403", method = RequestMethod.GET)
	  public String accessDenied(Model model, Principal principal) {
		  
	      if (principal != null) {
	         return "redirect:"+USER_INFO_URL;
	      } else {
	    	  model.addAttribute("title", "Access Denied!");
	          model.addAttribute("msg",
	                  "You do not have permission to access this page!");
	      }
	      return "403Page";
	  }
}
