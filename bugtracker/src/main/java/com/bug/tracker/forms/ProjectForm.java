package com.bug.tracker.forms;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class ProjectForm {
	private int id;
	
	@NotNull
	@Size(min=2,message="Project name must contain at least 2 letters")
	private String name;
	
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date startDate;
	
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date targetEndDate;
	
	@DateTimeFormat(pattern = "MM/dd/yyyy")
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
