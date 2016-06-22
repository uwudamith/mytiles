package com.bug.tracker.forms;


public class ProjectUsers {
	private int projectId;
	private String projectName;
	
	private String username;
	private String orderByField;
	private String orderByValue;
	private int page;
	private int size;
	
	private boolean updated;
	private String message;
	private boolean removeUser;
	private boolean addUser;
	private int userid;

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
	public boolean isUpdated() {
		return updated;
	}
	public void setUpdated(boolean updated) {
		this.updated = updated;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isRemoveUser() {
		return removeUser;
	}
	public void setRemoveUser(boolean removeUser) {
		this.removeUser = removeUser;
	}
	public boolean isAddUser() {
		return addUser;
	}
	public void setAddUser(boolean addUser) {
		this.addUser = addUser;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	
	
}
