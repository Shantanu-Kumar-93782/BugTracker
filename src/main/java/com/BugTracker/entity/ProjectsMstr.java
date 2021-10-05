package com.BugTracker.entity;

import java.math.BigInteger;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PROJECTS_MSTR")
public class ProjectsMstr {

	private BigInteger projectId;
	
	private String projectName;
	
	private String projectDesc;
	
	private BigInteger createdBy;
	
	private Timestamp createdTimestamp;
	
	private BigInteger lastUpdatedBy;
	
	private Timestamp lastUpdatedTimestamp;
	
	private char isActive;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PROJECT_ID")
	public BigInteger getProjectId() {
		return projectId;
	}

	public void setProjectId(BigInteger projectId) {
		this.projectId = projectId;
	}

	@Column(name="PROJECT_NAME")
	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	@Column(name="PROJECT_DESC")
	public String getProjectDesc() {
		return projectDesc;
	}

	
	public void setProjectDesc(String projectDesc) {
		this.projectDesc = projectDesc;
	}

	@Column(name="CREATED_BY")
	public BigInteger getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(BigInteger createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name="CREATED_TIMESTAMP")
	public Timestamp getCreatedTimestamp() {
		return createdTimestamp;
	}

	public void setCreatedTimestamp(Timestamp createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}

	@Column(name="LAST_UPDATED_BY")
	public BigInteger getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(BigInteger lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	@Column(name="LAST_UPDATED_TIMESTAMP")
	public Timestamp getLastUpdatedTimestamp() {
		return lastUpdatedTimestamp;
	}

	public void setLastUpdatedTimestamp(Timestamp lastUpdatedTimestamp) {
		this.lastUpdatedTimestamp = lastUpdatedTimestamp;
	}

	@Column(name="IS_ACTIVE")
	public char getIsActive() {
		return isActive;
	}

	public void setIsActive(char isActive) {
		this.isActive = isActive;
	}
	
}
