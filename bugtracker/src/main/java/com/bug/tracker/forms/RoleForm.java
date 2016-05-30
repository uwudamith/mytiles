package com.bug.tracker.forms;

import javax.validation.constraints.Size;

public class RoleForm {

	private int id;
	@Size(min=2,max=15 ,message="Role name must contain 2 letters and not more than 15 letters")
	private String name;
	
	private boolean added;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isAdded() {
		return added;
	}
	public void setAdded(boolean added) {
		this.added = added;
	}
	
	
	
}
