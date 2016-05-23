package com.bug.tracker.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

public class UserForm {

	private int id;
	
	@NotNull
	@Size(min=3,max=20,message="Username must have minimum 3 letters and maximum 20 letters")
	private String username;
	
	@Size(min=3,max=40,message="Password must have minimum 3 letters and maximum 40 letters")
	private String password;
	
	@NotNull
	private boolean enabled;

	@NotNull
	@Size(min=3,max=100,message="Name must have minimum 3 letters and maximum 100 letters")
	private String name;
	
	@Pattern(regexp="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message
			="Please enter valid email address")
	private String email;
	
	
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
	
	
	
}
