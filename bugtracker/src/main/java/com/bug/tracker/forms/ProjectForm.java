package com.bug.tracker.forms;

import java.util.Date;

public class ProjectForm {
	private int id;
	private String name;
	private Date startDate;
	private Date targetEndDate;
	private Date actualEndDate;
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
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getTargetEndDate() {
		return targetEndDate;
	}
	public void setTargetEndDate(Date targetEndDate) {
		this.targetEndDate = targetEndDate;
	}
	public Date getActualEndDate() {
		return actualEndDate;
	}
	public void setActualEndDate(Date actualEndDate) {
		this.actualEndDate = actualEndDate;
	}
	
	
}
