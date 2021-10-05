package com.BugTracker.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.BugTracker.adapters.ProjectsAdapter;
import com.BugTracker.dao.BugTrackerServiceDao;
import com.BugTracker.dao.SessionFactoryCreator;
import com.BugTracker.dto.BaseDto;
import com.BugTracker.dto.ProjectsDto;
import com.BugTracker.entity.ProjectsMstr;
import com.BugTracker.service.BugTrackerService;
import com.BugTracker.util.MessageUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component("projectsServiceImpl")
public class ProjectsServiceImpl extends BugTrackerService{

	@Autowired
	private SessionFactoryCreator sessionFactory;
	
	@Autowired
	private MessageUtil messageUtil;
	
	@Autowired 
	private BugTrackerServiceDao<ProjectsMstr> projectMstrServiceDao;
	
	public BugTrackerServiceDao<ProjectsMstr> getProjectMstrServiceDao() {
		return projectMstrServiceDao;
	}

	public void setProjectMstrServiceDao(BugTrackerServiceDao<ProjectsMstr> projectMstrServiceDao) {
		this.projectMstrServiceDao = projectMstrServiceDao;
	}

	public MessageUtil getMessageUtil() {
		return messageUtil;
	}

	public void setMessageUtil(MessageUtil messageUtil) {
		this.messageUtil = messageUtil;
	}

	public SessionFactoryCreator getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactoryCreator sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object getResource(Map<String, Object> requestData, HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
		if(requestData == null) {
			BaseDto dto = new BaseDto();
			dto.setError("BG00000", messageUtil.fetchMessageDescription("BG00000"));
			return dto;
		}
		
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			ProjectsDto projectsDto = objectMapper.convertValue(requestData, ProjectsDto.class);
			
			//Fetching list of all projects if no specific project is defined
			if(projectsDto.getProjectId()==null) {
				Session session = sessionFactory.getSession();
				Query query = session.createQuery("from ProjectsMstr", ProjectsMstr.class);
				List<ProjectsMstr> listOfProjects = (List<ProjectsMstr>) query.getResultList();
				sessionFactory.closeSession(session);
				if(listOfProjects.isEmpty()) {
					projectsDto.setError("BG00004", messageUtil.fetchMessageDescription("BG00004"));
					return projectsDto;
				}
				List<ProjectsDto> resultSet = new ArrayList<>();
				for(ProjectsMstr currentEntity: listOfProjects) {
					resultSet.add(ProjectsAdapter.convertEntityToModel(currentEntity, new ProjectsDto()));
				}
				return resultSet;
			}else {
				Session session = sessionFactory.getSession();
				Query query = session.createQuery("from ProjectsMstr where projectId=" + 
									String.valueOf(projectsDto.getProjectId()) , ProjectsMstr.class);
				try {
					ProjectsMstr projectEntity = (ProjectsMstr) query.getSingleResult();
					sessionFactory.closeSession(session);
					return ProjectsAdapter.convertEntityToModel(projectEntity, projectsDto);
				} catch (NoResultException e) {
					projectsDto.setError("BG00005", messageUtil.fetchMessageDescription("BG00005"));
					return projectsDto;
				}
			}
		}catch (Exception e) {
			System.out.println("An Error Occurred");
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	public Object saveResource(Map<String, Object> requestData, HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
		if(requestData == null) {
			BaseDto dto = new BaseDto();
			dto.setError("BG00000", messageUtil.fetchMessageDescription("BG00000"));
			return dto;
		}
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			ProjectsDto projectsDto = objectMapper.convertValue(requestData, ProjectsDto.class);
			ProjectsMstr entityToSave = ProjectsAdapter.convertModelToEntity(new ProjectsMstr(), projectsDto);
			entityToSave = projectMstrServiceDao.save(sessionFactory.getSessionWihtoutTransactionInitialized(), entityToSave);
			return ProjectsAdapter.convertEntityToModel(entityToSave, projectsDto);
		}catch(Exception e) {
			System.out.println("An Error Occurred");
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Object updateResource(Map<String, Object> requestData, HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
		if(requestData == null) {
			BaseDto dto = new BaseDto();
			dto.setError("BG00000", messageUtil.fetchMessageDescription("BG00000"));
			return dto;
		}
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			ProjectsDto projectsDto = objectMapper.convertValue(requestData, ProjectsDto.class);
			Session session = sessionFactory.getSession();
			ProjectsMstr entityToSave = ProjectsAdapter.convertModelToEntity(new ProjectsMstr(), projectsDto);
			entityToSave = (ProjectsMstr)session.save(entityToSave);
			sessionFactory.closeSession(session);
			return ProjectsAdapter.convertEntityToModel(entityToSave, projectsDto);
		}catch(Exception e) {
			System.out.println("An Error Occurred");
			e.printStackTrace();
		}
		return null;
	}
	
}
