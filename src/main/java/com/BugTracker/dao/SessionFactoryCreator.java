package com.BugTracker.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.BugTracker.entity.MemberMstr;
import com.BugTracker.entity.ReturnMessageMstr;
import com.BugTracker.entity.SystemFiles;
import com.BugTracker.entity.UserProfile;


public class SessionFactoryCreator {
	
	public static SessionFactory sessionFactory;
	
	public SessionFactoryCreator() {
		if(SessionFactoryCreator.sessionFactory==null) {
			SessionFactoryCreator.sessionFactory = 	new Configuration()
					.configure("hibernate-config.xml")
					.addAnnotatedClass(UserProfile.class)
					.addAnnotatedClass(MemberMstr.class)
					.addAnnotatedClass(SystemFiles.class)
					.addAnnotatedClass(ReturnMessageMstr.class)
					.buildSessionFactory();
		}
	}
	
	
	public Session getSession() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		return session;
	}
	
	public void closeSession(Session currentSession) {
		currentSession.close();
	}
//	@SuppressWarnings({"unchecked" })
//	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
//		SessionFactory sessionFactory=null;
//		try {
//			sessionFactory = new Configuration()
//					.configure("hibernate-config.xml")
////					.addPackage("com.DigitalPathShala.Entity")
//					.addAnnotatedClass(UserProfile.class)
//					.buildSessionFactory();
////			Criterion criteria = Restrictions.and(Restrictions.eq("USER_ID", 1),
////					Restrictions.eq("USER_PASSWORD", HashGenerator.generateMD5("default")));
//			Session session = sessionFactory.getCurrentSession();
//			session.beginTransaction();
////			session.persist(UserProfile.class);
//			System.out.println("Factory Created Successfully");
//			//Query query = session.createQuery("from UserProfile");
//			//List<UserProfile> resultSet = query.getResultList();
//			Criteria criteria = session.createCriteria(UserProfile.class);
//			List<UserProfile> resultSet = criteria.list();
//			for(UserProfile current: resultSet) {
//				System.out.println(current.getFirstName());
//}
//		}catch(Exception e) {
//			e.printStackTrace();
//			if(sessionFactory!=null) {
//				sessionFactory.close();
//			}
//		}finally {
//			if(sessionFactory!=null) {
//				sessionFactory.close();
//			}
//		}
//		
//	}

}
