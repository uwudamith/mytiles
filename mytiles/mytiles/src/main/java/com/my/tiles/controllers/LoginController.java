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
 * Handles requests for the application home page.
 */
@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {

		logger.info("Welcome home! The client locale is {}.", locale);

		LoginForm loginForm = new LoginForm();
		model.addAttribute("loginForm", loginForm);
		return "login";
	}

	@RequestMapping(value = "/loginrr", method = RequestMethod.GET)
	public String loginView(Locale locale, Model model) {

		LoginForm loginForm = new LoginForm();
		model.addAttribute("loginForm", loginForm);
		return "login";
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
