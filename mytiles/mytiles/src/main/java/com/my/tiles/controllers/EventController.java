package com.my.tiles.controllers;

import java.security.Principal;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.my.tiles.forms.EventForm;
import com.my.tiles.service.EventService;

@Controller
public class EventController {
	
	@Autowired
	EventService eventService;
	
	@RequestMapping(value = "/timeline", method = RequestMethod.GET)
	  public String loginPage(Locale locale,Model model, Principal principal) {
			model.addAttribute("current", "timeline");
			model.addAttribute("events", eventService.getAllEvents());
	      return "timeline";
	  }
	
	@RequestMapping("/event")
	public String event(EventForm event, Model model, Principal principal) {
		model.addAttribute("current", "event");
		model.addAttribute("event", event);
		return "event";
	}
	
	@RequestMapping(value = "/event", method = RequestMethod.POST)
	public String doAddEvent(Model model,@Valid @ModelAttribute("event") EventForm event, BindingResult result,Principal principal) {
		if(result.hasErrors()){
			return "event";
		}

		eventService.save(event);
		return "redirect:/event?save=true";
	}
}
