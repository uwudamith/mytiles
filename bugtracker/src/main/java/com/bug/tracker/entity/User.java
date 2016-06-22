package com.bug.tracker.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity
@Table(name= "tbl_users")
public class User {

	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(unique=true)
	@NotNull
	private String username;
	private String password;
	private boolean enabled;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable
	private List<Role> roles;
	
	private String name;
	private String email;

	@OneToMany(cascade=CascadeType.ALL, mappedBy="assignedTo",fetch=FetchType.LAZY)
	private List<Issue> issue;
	
	 @ManyToMany(cascade = {CascadeType.MERGE})
	 @JoinTable(name="Project_Users",joinColumns=@JoinColumn(name="id"),inverseJoinColumns=@JoinColumn(name="project_id"))
	private List<Project> assignedProject;
	
	
	@Transient boolean isAdded;
	
	public boolean isAdded() {
		return isAdded;
	}

	public void setAdded(boolean isAdded) {
		this.isAdded = isAdded;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Issue> getIssue() {
		return issue;
	}

	public void setIssue(List<Issue> issue) {
		this.issue = issue;
	}

	public List<Project> getAssignedProject() {
		return assignedProject;
	}

	public void setAssignedProject(List<Project> assignedProject) {
		this.assignedProject = assignedProject;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	
}
