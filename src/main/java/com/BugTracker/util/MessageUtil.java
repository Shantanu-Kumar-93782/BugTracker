package com.BugTracker.util;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.BugTracker.dao.SessionFactoryCreator;
import com.BugTracker.entity.ReturnMessageMstr;

@Component
public class MessageUtil {
	
	@Autowired
	private SessionFactoryCreator sessionFactory;

	public String fetchMessageDescription(String msgId) {
		Session session = sessionFactory.getSession();
		Query query = session.createQuery("from ReturnMessageMstr where msgId='" + msgId + "'", ReturnMessageMstr.class);
		ReturnMessageMstr resultEntity = null;
		try{
			resultEntity = (ReturnMessageMstr) query.getSingleResult();
			sessionFactory.closeSession(session);
			return resultEntity.getMsgDesc();
		}catch (NoResultException e) {
			return "";
		}
	}
}
