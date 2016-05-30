package com.bug.tracker.forms;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.bug.tracker.entity.User;

public class UserRoles {

	private User user;
	
	@Size(min=1,message="Please select at leat one role")
	@NotNull(message="Please select at leat one role")
	private List<Integer> selectedRoles;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Integer> getSelectedRoles() {
		return selectedRoles;
	}
	public void setSelectedRoles(List<Integer> selectedRoles) {
		this.selectedRoles = selectedRoles;
	}

	
	
	
}
