package com.BugTracker.adapters;

import java.sql.Timestamp;

import com.BugTracker.dto.ProjectsDto;
import com.BugTracker.entity.ProjectsMstr;

public class ProjectsAdapter {

	public static ProjectsDto convertEntityToModel(ProjectsMstr entity, ProjectsDto model) {
		model.setProjectId(entity.getProjectId());
		model.setProjectName(entity.getProjectName());
		model.setProjectDesc(entity.getProjectDesc());
		model.setIsActive(entity.getIsActive());
		model.setCreatedBy(entity.getCreatedBy());
		model.setCreatedTimestamp(entity.getCreatedTimestamp());
		return model;
	}
	
	public static ProjectsMstr convertModelToEntity(ProjectsMstr entity, ProjectsDto model) {
		entity.setProjectName(model.getProjectName());
		entity.setProjectDesc(model.getProjectDesc());
		entity.setIsActive('Y');
		entity.setCreatedBy(model.getUserId());
		entity.setCreatedTimestamp(new Timestamp(System.currentTimeMillis()));
		entity.setLastUpdatedBy(model.getUserId());
		entity.setLastUpdatedTimestamp(new Timestamp(System.currentTimeMillis()));
		return entity;
	}
}
