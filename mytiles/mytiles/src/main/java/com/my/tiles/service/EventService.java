package com.my.tiles.service;

import java.util.List;

import com.my.tiles.forms.EventForm;

public interface EventService {

	public void save(EventForm event);
	public List<EventForm> getAllEvents();
}
