package com.tracker.service;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tracker.model.StationDetails;
import com.tracker.model.StationLocation;
import com.tracker.util.DBConnectionManager;

public class StationDao {
	
	public List<StationDetails> getStation(String station){

        List<StationDetails> list_of_station = new ArrayList<StationDetails>();
        Session session = DBConnectionManager.openSession();
    	Transaction tx = null;
       
    	try {
    	
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createSQLQuery("select Station_Name,Station_Code from station_code where Station_Name like '%"+station+"%' union select Station_Name,Station_Code from station_code where Station_Code like '%"+station+"%'");
						
			List<Object[]> temp_list_of_station = query.list();
			
			for(Object [] e : temp_list_of_station) {
				
				StationDetails stationDetails = new StationDetails();
				
				stationDetails.setStation_Name((String)e[0]);
				stationDetails.setStation_Code((String)e[1]);
					
				list_of_station.add(stationDetails);	
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
			
        return list_of_station;
}


}
