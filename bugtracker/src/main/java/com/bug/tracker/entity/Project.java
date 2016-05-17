package com.bug.tracker.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_projects")
public class Project {
	@Id
	@GeneratedValue
	@Column(name = "project_id")
	private int id;

	@Column(name = "project_name")
	private String name;

	@Column(name = "start_date")
	private Date startDate;

	@Column(name = "target_end_date")
	private Date targetEndDate;

	@Column(name = "actual_end_date")
	private Date actualEndDate;

	@Column(name = "created_on")
	private Date createdOn;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "created_user_id")
	private User createdBy;

	@Column(name = "modified_on")
	private Date modifiedOn;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "modified_user_id")
	private User modifiedBy;

	@ManyToMany
	@JoinTable
	private List<User> assignedUser;
	
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

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public User getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(User modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public List<User> getAssignedUser() {
		return assignedUser;
	}

	public void setAssignedUser(List<User> assignedUser) {
		this.assignedUser = assignedUser;
	}

}
