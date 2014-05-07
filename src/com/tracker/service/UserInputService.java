package com.tracker.service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tracker.model.Details;
import com.tracker.util.DBConnectionManager;

public class UserInputService {
	
	
	public void setUserDetails(Details details) {
		
	
		Session session = DBConnectionManager.openSession();
		Transaction tx = null;
		
		System.out.println(details.getTrain_journey_id()+" "+details.getDOJ()+" "+details.getTrain()+" "+details.getFrom_Station()+" "+details.getTo_Station()+" "+details.getClasses()+" "+details.getComments());
	
		try {
			
			tx = session.getTransaction();
			tx.begin();
			
			Query query = session.createSQLQuery("insert into tracker(train_journey_id,DOJ,Train,From_Station,To_Station,Classes,Comments) values (?,?,?,?,?,?,?)");
					query.setParameter(0, details.getTrain_journey_id());
					query.setParameter(1, details.getDOJ());
					query.setParameter(2, details.getTrain());
					query.setParameter(3, details.getFrom_Station());
					query.setParameter(4, details.getTo_Station());
					query.setParameter(5, details.getClasses());
					query.setParameter(6, details.getComments());
					query.executeUpdate();
					
			tx.commit();
			
			
		} catch (Exception e) {
			if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
					
		} finally {
			
			session.close();
			
		}
		
		
	}

	
}
