package com.bug.tracker.entity;

import java.util.Date;

import javax.persistence.Entity;

public class Issue {
private int id;
private String summary;
private String description;
private int reportedBy;
private Date reportedDate;
private int projectId;
private int assignedTo;
private int status;
private int priority;
private Date targetResolutionDate;
private String progress;
private Date actualResolutionDate;
private String resolutionSummary;
private Date createdOn;
private int createdBy;
private Date modifiedOn;
private int modifiedBy;


}
