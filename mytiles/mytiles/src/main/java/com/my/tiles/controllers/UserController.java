package com.my.tiles.controllers;

import java.security.Principal;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
	
	 @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
	  public String loginPage(Locale locale,Model model, Principal principal) {
	      model.addAttribute("title", "User Info");
	      String userName = principal.getName();
	 
	      model.addAttribute("message",
	              "User Info - This is protected page!. Hello " + userName);
	 
	      return "userInfoPage";
	  }
}
