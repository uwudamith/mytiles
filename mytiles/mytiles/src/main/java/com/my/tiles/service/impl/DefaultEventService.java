package com.my.tiles.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.tiles.entity.Event;
import com.my.tiles.forms.EventForm;
import com.my.tiles.repository.EventRepository;
import com.my.tiles.service.EventService;

@Service
public class DefaultEventService implements EventService {
	
	@Autowired
	private EventRepository eventRepository;

	public void save(EventForm event) {
		Event ev = new Event();
		ev.setTitle(event.getTitle());
		ev.setDescription(event.getDescription());
		ev.setDate(event.getDate());

		eventRepository.save(ev);
	}
	
	public List<EventForm> getAllEvents(){
		List<EventForm> formList = new ArrayList<>();
		List <Event> events = eventRepository.findAll();
		for (Event event : events) {
			EventForm ev = new EventForm();
			ev.setTitle(event.getTitle());
			ev.setDescription(event.getDescription());
			ev.setDate(event.getDate());
			
			formList.add(ev);
		}
		return formList;
	}
}
