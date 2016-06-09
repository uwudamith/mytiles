package com.bug.tracker.forms;

import java.util.List;

public class ProjectUsers {
	private int projectId;
	private String projectName;
	
	private String username;
	private String orderByField;
	private String orderByValue;
	private int page;
	private int size;
	
	
	private List<Integer> users;
	
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public List<Integer> getUsers() {
		return users;
	}
	public void setUsers(List<Integer> users) {
		this.users = users;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getOrderByField() {
		return orderByField;
	}
	public void setOrderByField(String orderByField) {
		this.orderByField = orderByField;
	}
	public String getOrderByValue() {
		return orderByValue;
	}
	public void setOrderByValue(String orderByValue) {
		this.orderByValue = orderByValue;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
}
