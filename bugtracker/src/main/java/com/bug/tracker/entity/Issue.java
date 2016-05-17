package com.bug.tracker.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_issue")
public class Issue {

	@Id
	@GeneratedValue
	@Column(name="issue_id")
	private int id;
	private String summary;
	private String description;
	private int reportedBy;
	private Date reportedDate;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "projectId")
	private Project project;

	@ManyToOne
	@JoinColumn(name="assigned_user_id", nullable=false)
	private User assignedTo;
	private int status;
	private int priority;
	private Date targetResolutionDate;
	private String progress;
	private Date actualResolutionDate;
	private String resolutionSummary;

	private Date createdOn;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "created_user_id")
	private User createdBy;
	private Date modifiedOn;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "updated_user_id")
	private User modifiedBy;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getReportedBy() {
		return reportedBy;
	}

	public void setReportedBy(int reportedBy) {
		this.reportedBy = reportedBy;
	}

	public Date getReportedDate() {
		return reportedDate;
	}

	public void setReportedDate(Date reportedDate) {
		this.reportedDate = reportedDate;
	}



	public User getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(User assignedTo) {
		this.assignedTo = assignedTo;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public Date getTargetResolutionDate() {
		return targetResolutionDate;
	}

	public void setTargetResolutionDate(Date targetResolutionDate) {
		this.targetResolutionDate = targetResolutionDate;
	}

	public String getProgress() {
		return progress;
	}

	public void setProgress(String progress) {
		this.progress = progress;
	}

	public Date getActualResolutionDate() {
		return actualResolutionDate;
	}

	public void setActualResolutionDate(Date actualResolutionDate) {
		this.actualResolutionDate = actualResolutionDate;
	}

	public String getResolutionSummary() {
		return resolutionSummary;
	}

	public void setResolutionSummary(String resolutionSummary) {
		this.resolutionSummary = resolutionSummary;
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

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

}
