package com.my.tiles.controllers;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.my.tiles.forms.LoginForm;
import com.my.tiles.validator.LoginValidator;

/**
 * Handles requests for the application login.
 */
@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	  public String loginPage(Locale locale,Model model) {
		
		logger.info("Client locale is :"+locale);
		
	      model.addAttribute("title", "Login");
	      model.addAttribute("message", "Enter your username/password:");
	      return "loginPage";
	  }
	
	@RequestMapping(value = "/logingg", method = RequestMethod.POST)
	public String executeLogin(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("loginForm") LoginForm loginForm,BindingResult result,Model model) {
		
		LoginValidator userValidator = new LoginValidator();
        userValidator.validate(loginForm, result);
        
        if (result.hasErrors()){
           model.addAttribute("errors", result.getAllErrors());
           return "login";
          }
          else {
           return "redirect:home";
          }
		
	}

}