package com.tracker.service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jasypt.util.password.ConfigurablePasswordEncryptor;

import com.tracker.model.User;
import com.tracker.util.DBConnectionManager;

public class LoginService {
	
	public boolean authenticate(String userId, String password) {
		
		User user = getUserByUserId(userId);
		ConfigurablePasswordEncryptor encryptor = new ConfigurablePasswordEncryptor();
		encryptor.setAlgorithm("SHA-512");
		encryptor.setPlainDigest(true);
		
		if(user!=null && user.getUsername().equals(userId) && encryptor.checkPassword(password, user.getPassword())) {
			
			return true;
		}
		
		else {
			
			return false;
		}
		
	}
	
	public User getUserByUserId(String userId) {
		
		Session session = DBConnectionManager.openSession();
		Transaction tx = null;
		User user = null;
	
		try {
			
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from User where username = '"+userId+"'");
			query.setCacheable(true);
			/*query.setCacheRegion("query.UserCredentials");*/
			user = (User)query.uniqueResult();
			tx.commit();
			
			
		} catch (Exception e) {
			if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
					
		} finally {
			
			session.close();
			
		}
		
		return user;

		
	}

}
