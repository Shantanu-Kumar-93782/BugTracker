package com.BugTracker.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.BugTracker.adapters.ProjectuserMapAdapter;
import com.BugTracker.dao.BugTrackerServiceDao;
import com.BugTracker.dao.SessionFactoryCreator;
import com.BugTracker.dto.BaseDto;
import com.BugTracker.dto.ProjectUserMapDto;
import com.BugTracker.entity.ProjectUserMap;
import com.BugTracker.entity.ProjectsMstr;
import com.BugTracker.entity.UserProfile;
import com.BugTracker.service.BugTrackerService;
import com.BugTracker.util.MessageUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
@Service("projectUsersServiceImpl")
public class ProjectUsersServiceImpl extends BugTrackerService{
	@Autowired
	private SessionFactoryCreator sessionFactory;
	
	@Autowired
	private MessageUtil messageUtil;
	
	@Autowired 
	private BugTrackerServiceDao<ProjectUserMap> projectUserMapServiceDao;
	
	public BugTrackerServiceDao<ProjectUserMap> getProjectUserMapServiceDao() {
		return projectUserMapServiceDao;
	}

	public void setProjectUserMapServiceDao(BugTrackerServiceDao<ProjectUserMap> projectUserMapServiceDao) {
		this.projectUserMapServiceDao = projectUserMapServiceDao;
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
			ProjectUserMapDto projectsDto = objectMapper.convertValue(requestData, ProjectUserMapDto.class);
			
			//Fetching list of all projects if no specific project is defined
			if(projectsDto.getProjectId()==null) {
				BaseDto dto = new BaseDto();
				dto.setError("BG00000", messageUtil.fetchMessageDescription("BG00000"));
				return dto;
			}else {
				Session session = sessionFactory.getSession();
				Query query = session.createQuery("from ProjectUserMap", ProjectUserMap.class);
				List<ProjectUserMap> resultList = (List<ProjectUserMap>) query.getResultList();
				sessionFactory.closeSession(session);
				if(resultList.isEmpty()) {
					projectsDto.setError("BG00006", messageUtil.fetchMessageDescription("BG00006"));
					return projectsDto;
				}
				List<ProjectUserMapDto> resultSet = new ArrayList<>();
				for(ProjectUserMap currentEntity: resultList) {
					session = sessionFactory.getSession();
					query = session.createQuery("from UserProfile where userId=" + String.valueOf(currentEntity.getUserId()), UserProfile.class);
					UserProfile resultEntity = (UserProfile)query.getSingleResult();
					resultSet.add(ProjectuserMapAdapter.convertEntityToModel(new ProjectUserMapDto(), currentEntity, resultEntity));
				}
				projectsDto.setListOfAddedUser(resultSet);
				return projectsDto;
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
			ProjectUserMapDto projectsDto = objectMapper.convertValue(requestData, ProjectUserMapDto.class);
			ProjectUserMap entity = ProjectuserMapAdapter.convertModelToEntity(projectsDto, new ProjectUserMap());
			entity = projectUserMapServiceDao.save(sessionFactory.getSessionWihtoutTransactionInitialized(), entity);
			Session session = sessionFactory.getSession();
			Query query = session.createQuery("from UserProfile where userId=" + String.valueOf(entity.getUserId()), UserProfile.class);
			UserProfile resultEntity = (UserProfile)query.getSingleResult();
			return ProjectuserMapAdapter.convertEntityToModel(projectsDto, entity, resultEntity);
		}catch(Exception e) {
			System.out.println("An Error Occurred");
			e.printStackTrace();
		}
		
		return null;
	}
}
