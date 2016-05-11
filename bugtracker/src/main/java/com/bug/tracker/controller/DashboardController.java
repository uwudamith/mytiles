package com.bug.tracker.controller;

import java.security.Principal;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DashboardController {

	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	  public String dashboard(Locale locale,Model model, Principal principal) {
			model.addAttribute("current", "dashboard");
	      return "dashboard";
	  }
}
