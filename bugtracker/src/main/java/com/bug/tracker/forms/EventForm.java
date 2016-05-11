package com.bug.tracker.forms;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class EventForm {

		@NotNull
	 	@Size(min=2, max=30)
		private String title;
		
		@NotNull
		private Date date;
		
		@NotNull
	 	@Size(min=2, max=1000)
		private String description;
		
		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}
}
