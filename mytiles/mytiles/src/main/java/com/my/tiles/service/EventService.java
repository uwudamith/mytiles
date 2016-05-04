package com.my.tiles.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.tiles.entity.Event;
import com.my.tiles.forms.EventForm;
import com.my.tiles.repository.EventRepository;

@Service
public class EventService {

	@Autowired
	private EventRepository eventRepository;

	public void save(EventForm event) {
		Event ev = new Event();
		ev.setTitle(event.getTitle());
		ev.setDescription(event.getDescription());
		ev.setDate(event.getDate());

		eventRepository.save(ev);
	}
}
