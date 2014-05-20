package com.tracker.service;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tracker.model.Details;
import com.tracker.util.DBConnectionManager;

public class UserInputService {
	
	
	public boolean setUserDetails(Details details, String userid) {
		

		Session session = DBConnectionManager.openSession();
		Transaction tx = null;
		boolean flag=false;
		
		System.out.println(details.getTrain_journey_id()+" "+details.getDOJ()+" "+details.getTrain()+" "+details.getFrom_Station()+" "+details.getTo_Station()+" "+details.getClasses()+" "+details.getBerth()+" "+details.getComments());
	
		try {
			
			if(userid!=null) {
        	
			tx = session.getTransaction();
			tx.begin();
			
			Query query = session.createSQLQuery("insert into tracker(train_journey_id,DOJ,Train,From_Station,To_Station,Classes,berth,Comments,user_id) values(?,?,?,?,?,?,?,?,?)");
					query.setParameter(0, 0);
					query.setParameter(1, details.getDOJ());
					query.setParameter(2, details.getTrain());
					query.setParameter(3, details.getFrom_Station());
					query.setParameter(4, details.getTo_Station());
					query.setParameter(5, details.getClasses());
					query.setParameter(6, details.getBerth());
					query.setParameter(7, details.getComments());
					query.setParameter(8, userid);
					query.executeUpdate();
					query.setCacheable(true);
					query.setCacheRegion("query.InsertDetails");
			tx.commit();
			
			flag=true;
			}
			
			
			
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
	
	public ArrayList<Details> getUserDetails(String userid) {
		
		
		ArrayList<Details> list_of_info = new ArrayList<Details>();
		
		Session session = DBConnectionManager.openSession();
		Transaction tx = null;
		
	
		try {
			
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from Details where user_id = :user_id");
			query.setParameter("user_id", userid);
			query.setCacheable(true);
			query.setCacheRegion("query.FetchDetails");
			
			list_of_info = (ArrayList) query.list();
			
			tx.commit();
			
			
		} catch (Exception e) {
			if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
					
		} finally {
			
			session.close();
			
		}
		
		return list_of_info;
		
	}

	
}
