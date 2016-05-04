package com.my.tiles.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.my.tiles.forms.EventForm;

public class EventValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return EventForm.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		EventForm eventForm = (EventForm) obj;

		if (eventForm.getTitle() == null || eventForm.getTitle().isEmpty()) {
			errors.rejectValue("title", "title_error", "title.error");
		}

		if (eventForm.getDate() == null) {
			errors.rejectValue("date", "date_error", "date.error");
		}

		if (eventForm.getDescription()== null || eventForm.getDescription().isEmpty()) {
			errors.rejectValue("description", "description_error", "description.error");
		}

	}

}
