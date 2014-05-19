package com.tracker.service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tracker.util.DBConnectionManager;

public class RegisterService {
	
	public boolean register(String name, String username,String email,String password) {
		
		
		if(checkuniqueuserid(username)) {
			
			Session session = DBConnectionManager.openSession();
			Transaction tx = null;
		
			try {
				
				tx = session.getTransaction();
				tx.begin();
				
				Query query = session.createSQLQuery("insert into user_registration_data(user_registration_data_id,user_name,user_id,user_email,user_password) values(?,?,?,?,?)");
						query.setParameter(0, 0);
						query.setParameter(1, name);
						query.setParameter(2, username);
						query.setParameter(3, email);
						query.setParameter(4, password);
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
