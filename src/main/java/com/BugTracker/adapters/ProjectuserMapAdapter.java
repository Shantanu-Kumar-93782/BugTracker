package com.BugTracker.adapters;

import java.sql.Timestamp;

import com.BugTracker.dto.ProjectUserMapDto;
import com.BugTracker.entity.ProjectUserMap;
import com.BugTracker.entity.UserProfile;

public class ProjectuserMapAdapter {

	public static ProjectUserMapDto convertEntityToModel(ProjectUserMapDto model, ProjectUserMap entity, UserProfile userProfile) {
		model.setProjectId(entity.getProjectId());
		model.setRelationId(entity.getRelationId());
		model.setMemberUserId(entity.getUserId());
		model.setMemberUserName(userProfile.getFirstName());
		model.setMemberUserEmailId(userProfile.getPriMailId());
		return model;
	}
	
	public static ProjectUserMap convertModelToEntity(ProjectUserMapDto model, ProjectUserMap entity) {
		entity.setUserId(model.getMemberUserId());
		entity.setIsApplicable('Y');
		entity.setProjectId(model.getProjectId());
		entity.setCreatedBy(model.getUserId());
		entity.setCreatedTimestamp(new Timestamp(System.currentTimeMillis()));
		entity.setLastUpdatedBy(model.getUserId());
		entity.setLastUpdatedTimestamp(new Timestamp(System.currentTimeMillis()));
		return entity;
	}
}
