package com.tracker.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tracker.model.TrainDetails;
import com.tracker.util.DBConnectionManager;

public class TrainDao {
	
	public List<TrainDetails> getTrain(String train){

        List<TrainDetails>  list_of_train = new ArrayList<TrainDetails>();

        Session session = DBConnectionManager.openSession();
    	Transaction tx = null;
       
    	try {
    	
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createSQLQuery("select Train_Name,Train_Number from train_number_name_type where Train_Name LIKE '%"+ train + "%'");
						
			List<Object[]> temp_list_of_train = query.list();
			
			for(Object [] e : temp_list_of_train) {
				
				TrainDetails trainDetails = new TrainDetails();
				
				trainDetails.setTrain_Name((String)e[0]);
				trainDetails.setTrain_Number((BigInteger)e[1]);
					
				list_of_train.add(trainDetails);	
			}
			
			tx.commit();
			
			
		} catch (Exception e) {
			if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
					
		} finally {
			
			session.close();
			
		}
        
        return list_of_train;
}

}
