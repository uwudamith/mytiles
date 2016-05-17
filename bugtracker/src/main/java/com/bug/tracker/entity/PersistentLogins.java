package com.bug.tracker.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import javax.persistence.Id;

@Entity
@Table(name="persistent_logins")
public class PersistentLogins {

	@Column(name="username")
	@NotNull
	private String username;
	
	@Id
	@Column(name="series")
	@NotNull
	private String series;
	
	@Column(name="token")
	@NotNull
	private String token;
	
	@Column(name="last_used")
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUsed;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getLastUsed() {
		return lastUsed;
	}

	public void setLastUsed(Date lastUsed) {
		this.lastUsed = lastUsed;
	}
	
	
}
