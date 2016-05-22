package com.bug.tracker.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HTTPErrorHandler {
	String path = "/error";
	private static String USER_INFO_URL = "/userInfo";
	
	@RequestMapping(value="/400")
	 public String error400(){
	  System.out.println("400 custom error handler");
	  return path+"/400";
	 }
	  
	 @RequestMapping(value="/404")
	 public String error404(){
	  System.out.println("404 custom error handler");
	  return path+"/404";
	 }
	  
	 @RequestMapping(value="/500")
	 public String error500(){
	  System.out.println("500 custom error handler");
	  return path+"/500";
	 }
	 
	 @RequestMapping(value="/405")
	 public String error405(){
	  System.out.println("405 custom error handler");
	  return path+"/405";
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
