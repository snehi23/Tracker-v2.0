package com.tracker.service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tracker.model.User_credentials;
import com.tracker.util.DBConnectionManager;

public class LoginService {
	
	public boolean authenticate(String userId, String password) {
		
		User_credentials user_credentails = getUserByUserId(userId);
		
		if(user_credentails!=null && user_credentails.getUserid().equals(userId) && user_credentails.getPass().equals(password)) {
			
			return true;
		}
		
		else {
			
			return false;
		}
		
	}
	
	public User_credentials getUserByUserId(String userId) {
		
		Session session = DBConnectionManager.openSession();
		Transaction tx = null;
		User_credentials user_credentials = null;
	
		try {
			
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from User_credentials where userid = '"+userId+"'");
			query.setCacheable(true);
			query.setCacheRegion("query.UserCredentials");
			user_credentials = (User_credentials)query.uniqueResult();
			tx.commit();
			
			
		} catch (Exception e) {
			if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
					
		} finally {
			
			session.close();
			
		}
		
		return user_credentials;

		
	}

}
