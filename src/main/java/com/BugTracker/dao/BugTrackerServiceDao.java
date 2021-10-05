package com.BugTracker.dao;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

@Component
public class BugTrackerServiceDao <T>{

	@SuppressWarnings("unchecked")
	public T save(Session session, T entity){
		Transaction transaction = session.beginTransaction();
		BigInteger primaryKey = (BigInteger) session.save(entity);
		transaction.commit();
		transaction = session.beginTransaction();
		entity = (T) session.load(entity.getClass(), primaryKey);
		transaction.commit();
		session.close();
		return entity;
	}
	
//	public List<T> fetchRecords(Session session, String query) {
//		Transaction transaction = session.beginTransaction();
//		List<T> resultSet = session
//		
//		return 
//	}
}
