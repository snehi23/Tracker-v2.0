package com.tracker.service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tracker.model.User;
import com.tracker.util.DBConnectionManager;

public class RegisterService {
	
	public boolean register(User userDetails) {
		
		
		if(checkuniqueuserid(userDetails.getUsername())) {
			
			Session session = DBConnectionManager.openSession();
			Transaction tx = null;
		
			try {
				
				tx = session.getTransaction();
				tx.begin();
				
				Query query = session.createSQLQuery("insert into user_registration_data(user_registration_data_id,user_name,user_id,user_email,user_password) values(?,?,?,?,?)");
						query.setParameter(0, 0);
						query.setParameter(1, userDetails.getUser());
						query.setParameter(2, userDetails.getUsername());
						query.setParameter(3, userDetails.getEmail());
						query.setParameter(4, userDetails.getPassword());
						query.executeUpdate();
						/*query.setCacheable(true);
						query.setCacheRegion("query.InsertDetails");*/
				tx.commit();
				
				
			} catch (Exception e) {
				if (tx != null) {
					 tx.rollback();
				 }
				 e.printStackTrace();
						
			} finally {
				
				session.close();
				
			}
			
			
			return true;
		}
		else return false;
		
		
	}
	
	public boolean checkuniqueuserid(String username) {
		
		Session session = DBConnectionManager.openSession();
		Transaction tx = null;
		boolean flag=false;
	
		try {
			
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from User where username = '"+username+"'");
			/*query.setCacheable(true);
			query.setCacheRegion("query.UserCredentials");*/
			if(query.uniqueResult()==null) flag=true;
			tx.commit();
			
			
		} catch (Exception e) {
			if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
					
		} finally {
			
			session.close();
			
		}
			
		return flag;
	
		
	}
	

}
