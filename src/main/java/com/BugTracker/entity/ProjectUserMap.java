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
@Table(name="PROJECT_USER_MAP")
public class ProjectUserMap {
	
	private BigInteger relationId;

	private BigInteger projectId;
	
	private BigInteger userId;
	
	private BigInteger createdBy;
	
	private Timestamp createdTimestamp;
	
	private BigInteger lastUpdatedBy;
	
	private Timestamp lastUpdatedTimestamp;
	
	private char isApplicable;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="RELATION_ID")
	public BigInteger getRelationId() {
		return relationId;
	}

	public void setRelationId(BigInteger relationId) {
		this.relationId = relationId;
	}

	@Column(name="PROJECT_ID")
	public BigInteger getProjectId() {
		return projectId;
	}

	public void setProjectId(BigInteger projectId) {
		this.projectId = projectId;
	}

	@Column(name="USER_ID")
	public BigInteger getUserId() {
		return userId;
	}

	public void setUserId(BigInteger userId) {
		this.userId = userId;
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

	@Column(name="IS_APPLICABLE")
	public char getIsApplicable() {
		return isApplicable;
	}

	public void setIsApplicable(char isApplicable) {
		this.isApplicable = isApplicable;
	}
}
