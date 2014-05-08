package com.tracker.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tracker.model.StationLocation;
import com.tracker.model.StationLocationPlot;
import com.tracker.util.DBConnectionManager;

public class DisplayLocationService {
	
public ArrayList<StationLocation> getLocationDetails() {
		
		
		ArrayList<StationLocation> list_of_location = new ArrayList<StationLocation>();
		Session session = DBConnectionManager.openSession();
		Transaction tx = null;
		
	
		try {
			
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createSQLQuery("select station_lat_long.station_lat_long_id,tracker.From_Station,station_lat_long.station_name,station_lat_long.latitude,station_lat_long.longitude from tracker inner join station_lat_long where tracker.From_Station=station_lat_long.station_code union select station_lat_long.station_lat_long_id,tracker.To_Station,station_lat_long.station_name,station_lat_long.latitude,station_lat_long.longitude from tracker inner join station_lat_long where tracker.To_Station=station_lat_long.station_code");
						
			List<Object[]> temp_list_of_location = query.list();
			
			for(Object [] e : temp_list_of_location) {
				StationLocation stationLocation = new StationLocation();
				
				stationLocation.setStation_lat_long_id((Integer)e[0]);
				stationLocation.setStation_code((String)e[1]);
				stationLocation.setStation_name((String)e[2]);
				stationLocation.setLatitude(((BigDecimal) e[3]).doubleValue());
				stationLocation.setLongitude(((BigDecimal) e[4]).doubleValue());
				list_of_location.add(stationLocation);	
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
		
		return list_of_location;
		
	}

public ArrayList<StationLocationPlot> getMapPlotDetails() {
	
	
	ArrayList<StationLocationPlot> list_of_map_details = new ArrayList<StationLocationPlot>();
	Session session = DBConnectionManager.openSession();
	Transaction tx = null;
	

	try {
		
		tx = session.getTransaction();
		tx.begin();
		Query query = session.createSQLQuery("select distinct s1.latitude as source_latitude,s1.longitude as source_longitude,s2.latitude as destination_latitude,s2.longitude as destination_longitude from tracker t inner join station_lat_long s1 on t.From_Station=s1.station_code inner join station_lat_long s2 on t.To_Station=s2.station_code");
		
		List<Object[]> temp_list_of_map_details = query.list();
		
		for(Object [] e : temp_list_of_map_details) {
			
			StationLocationPlot stationLocationPlot = new StationLocationPlot();
			stationLocationPlot.setFrom_latitude(((BigDecimal)e[0]).doubleValue());
			stationLocationPlot.setFrom_longitude(((BigDecimal)e[1]).doubleValue());
			stationLocationPlot.setTo_latitude(((BigDecimal)e[2]).doubleValue());
			stationLocationPlot.setTo_longitude(((BigDecimal)e[3]).doubleValue());
			list_of_map_details.add(stationLocationPlot);	
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
	
	return list_of_map_details;
	
}

}
