package com.BugTracker.dto;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ProjectUserMapDto extends BaseDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private BigInteger userId;
	
	private BigInteger projectId;
	
	private BigInteger relationId;
	
	private BigInteger memberUserId;
	
	private String memberUserName;
	
	private String memberUserEmailId;
	
	private List<ProjectUserMapDto> listOfAddedUser;

	public BigInteger getUserId() {
		return userId;
	}

	public void setUserId(BigInteger userId) {
		this.userId = userId;
	}

	public BigInteger getProjectId() {
		return projectId;
	}

	public void setProjectId(BigInteger projectId) {
		this.projectId = projectId;
	}

	public BigInteger getRelationId() {
		return relationId;
	}

	public void setRelationId(BigInteger relationId) {
		this.relationId = relationId;
	}

	public BigInteger getMemberUserId() {
		return memberUserId;
	}

	public void setMemberUserId(BigInteger memberUserId) {
		this.memberUserId = memberUserId;
	}

	public String getMemberUserName() {
		return memberUserName;
	}

	public void setMemberUserName(String memberUserName) {
		this.memberUserName = memberUserName;
	}

	public String getMemberUserEmailId() {
		return memberUserEmailId;
	}

	public void setMemberUserEmailId(String memberUserEmailId) {
		this.memberUserEmailId = memberUserEmailId;
	}

	public List<ProjectUserMapDto> getListOfAddedUser() {
		return listOfAddedUser;
	}

	public void setListOfAddedUser(List<ProjectUserMapDto> listOfAddedUser) {
		this.listOfAddedUser = listOfAddedUser;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}
