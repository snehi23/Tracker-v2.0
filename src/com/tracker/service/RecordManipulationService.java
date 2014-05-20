package com.tracker.service;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tracker.model.Details;
import com.tracker.util.DBConnectionManager;

public class RecordManipulationService {
	
	
	public boolean deleteRecord(Integer train_journey_id) {
		
		Session session = DBConnectionManager.openSession();
		Transaction tx = null;
		boolean flag=false;
	
		try {
			
			
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("DELETE FROM Details WHERE train_journey_id = :train_journey_id");
			query.setParameter("train_journey_id", train_journey_id);
			int result=query.executeUpdate();
			System.out.println("Rows Affected :"+result);
			
			if(result>0) flag=true;

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
	
public Details editRecord(Integer train_journey_id) {

		Details details = new Details();
		Session session = DBConnectionManager.openSession();
		Transaction tx = null;

		try {
			
			
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from Details WHERE train_journey_id = :train_journey_id");
			query.setParameter("train_journey_id", train_journey_id);	
			details = (Details) query.uniqueResult();

			tx.commit();
			
			
		} catch (Exception e) {
			if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
					
		} finally {
			
			session.close();
			
		}
		
		return details;
		
	}

public boolean updateRecord(Details details) {

	
	Session session = DBConnectionManager.openSession();
	Transaction tx = null;
	boolean flag=false;
	

	try {
		
		
		tx = session.getTransaction();
		tx.begin();
		Query query = session.createQuery("update Details set DOJ = :doj, train = :train, from_Station = :from, to_Station = :to, classes = :classes, berth = :berth, comments = :comment, user_id = :userid where train_journey_id = :recordid");
		
		query.setParameter("doj", details.getDOJ());
		query.setParameter("train", details.getTrain().replaceAll("\\P{L}", " ").trim());
		query.setParameter("from", details.getFrom_Station().replaceAll(".*\\(", "").replaceAll("\\)", "").trim());
		query.setParameter("to", details.getTo_Station().replaceAll(".*\\(", "").replaceAll("\\)", "").trim());
		query.setParameter("classes", details.getClasses());
		query.setParameter("berth", details.getBerth());
		query.setParameter("comment", details.getComments());
		query.setParameter("userid", details.getUser_id());
		query.setParameter("recordid", details.getTrain_journey_id());
		int result = query.executeUpdate();
		if(result>0) flag=true;

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
