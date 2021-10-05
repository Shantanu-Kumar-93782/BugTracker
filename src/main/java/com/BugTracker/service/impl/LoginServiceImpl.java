package com.BugTracker.service.impl;

import java.util.Map;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.BugTracker.dao.SessionFactoryCreator;
import com.BugTracker.dto.BaseDto;
import com.BugTracker.dto.LoginDto;
import com.BugTracker.entity.UserProfile;
import com.BugTracker.service.BugTrackerService;
import com.BugTracker.util.HashGenerator;
import com.BugTracker.util.MessageUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component("loginServiceImpl")
public class LoginServiceImpl extends BugTrackerService{
	
	@Autowired
	private SessionFactoryCreator sessionFactory;
	
	@Autowired
	private MessageUtil messageUtil;
	
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

	@Override
	public Object getResource(Map<String, Object> requestData, HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
		
		if(requestData == null) {
			BaseDto dto = new BaseDto();
			dto.setError("BG00000", messageUtil.fetchMessageDescription("BG00000"));
			return dto;
		}
		
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			LoginDto loginDto = objectMapper.convertValue(requestData, LoginDto.class);
			
			Session session = sessionFactory.getSession();
			Query query = session.createQuery("from UserProfile where userId=" + String.valueOf(loginDto.getUserId()), UserProfile.class);
			UserProfile resultEntity = null;
			try{
				resultEntity = (UserProfile) query.getSingleResult();
			}catch (NoResultException e) {
				loginDto.setUserPassword(null);
				loginDto.setError("BG00001", messageUtil.fetchMessageDescription("BG00001"));
				return loginDto;
			}
			sessionFactory.closeSession(session);

			if(!resultEntity.getUserPassword().equalsIgnoreCase(HashGenerator.generateMD5(loginDto.getUserPassword()))) {
				loginDto.setUserPassword(null);
				loginDto.setError("BG00002", messageUtil.fetchMessageDescription("BG00002"));
				return loginDto;
			}else {
				loginDto.setUserPassword(null);
				loginDto.setSessionKey("some session key");
				loginDto.setInfo("BG00003", messageUtil.fetchMessageDescription("BG00003"));
				return loginDto;
			}
			
			
//			loginDto = LoginAdapter.convertEntityToModel(loginDto, resultEntity);
		}catch(Exception e) {
			e.printStackTrace();
			return new BaseDto();
		}
	}
	
}
