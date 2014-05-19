package com.tracker.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import javax.persistence.Cacheable;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.tracker.model.StationLocation;
import com.tracker.model.StationLocationPlot;
import com.tracker.util.DBConnectionManager;

public class DisplayStatisticsService {
	
	
public ArrayList<StationLocation> getLocationDetails(String userid) {
		
		
		ArrayList<StationLocation> list_of_location = new ArrayList<StationLocation>();
		Session session = DBConnectionManager.openSession();
		Transaction tx = null;
		
	
		try {
			
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createSQLQuery("select station_lat_long.station_lat_long_id,tracker.From_Station,station_lat_long.station_name,station_lat_long.latitude,station_lat_long.longitude from tracker inner join station_lat_long where tracker.From_Station=station_lat_long.station_code and tracker.user_id ="+"'"+userid+"'"+"union select station_lat_long.station_lat_long_id,tracker.To_Station,station_lat_long.station_name,station_lat_long.latitude,station_lat_long.longitude from tracker inner join station_lat_long where tracker.To_Station=station_lat_long.station_code and tracker.user_id ="+"'"+userid+"'");
						
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

public ArrayList<StationLocationPlot> getMapPlotDetails(String userid) {
	
	
	ArrayList<StationLocationPlot> list_of_map_details = new ArrayList<StationLocationPlot>();
	Session session = DBConnectionManager.openSession();
	Transaction tx = null;
	

	try {
		
		tx = session.getTransaction();
		tx.begin();
		Query query = session.createSQLQuery("select distinct s1.latitude as source_latitude,s1.longitude as source_longitude,s2.latitude as destination_latitude,s2.longitude as destination_longitude from tracker t inner join station_lat_long s1 on t.From_Station=s1.station_code and t.user_id= "+"'"+userid+"'"+" inner join station_lat_long s2 on t.To_Station=s2.station_code and t.user_id= "+"'"+userid+"'");
		
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

public Double getTotalDistanceDetails(String userid) {
	
	
	
	Session session = DBConnectionManager.openSession();
	Transaction tx = null;
	Double dist = 0.0;
	

	try {
		
		tx = session.getTransaction();
		tx.begin();
		Query query = session.createSQLQuery("select distinct s1.latitude as source_latitude,s1.longitude as source_longitude,s2.latitude as destination_latitude,s2.longitude as destination_longitude from tracker t inner join station_lat_long s1 on t.From_Station=s1.station_code and t.user_id= "+"'"+userid+"'"+" inner join station_lat_long s2 on t.To_Station=s2.station_code and t.user_id= "+"'"+userid+"'");
		
		List<Object[]> temp_list_of_map_details = query.list();
		
		for(Object [] e : temp_list_of_map_details) {
			
			dist = dist + distance(((BigDecimal)e[0]).doubleValue(), ((BigDecimal)e[1]).doubleValue(), ((BigDecimal)e[2]).doubleValue(), ((BigDecimal)e[3]).doubleValue());
				
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
	
	return dist;
	
}
	
	public HashMap<String,Integer> getTrainDetails(String userid) {
		
		
		
		HashMap<String,Integer> group_by_train = new HashMap<String,Integer>();
		
		
		Session session = DBConnectionManager.openSession();
		Transaction tx = null;
		
	
		try {
			
			tx = session.getTransaction();
			tx.begin();
			
			Query query = session.createSQLQuery("select Train, count(*) as all_train from tracker where user_id ="+"'"+userid+"'"+"group by Train order by all_train desc");
			

			List<Object[]> list = query.list();
			
			for(Object[] e : list) {
				
				group_by_train.put((String)e[0], ((BigInteger) e[1]).intValue());
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
		
		return group_by_train;
			
		
	}
	
	public HashMap<String,Integer> getFromStationDetails(String userid) {
		
		HashMap<String,Integer> group_by_from_station = new HashMap<String,Integer>();
		Session session = DBConnectionManager.openSession();
		Transaction tx = null;
		
	
		try {
			
			tx = session.getTransaction();
			tx.begin();
			
			Query query = session.createSQLQuery("select From_Station, count(*) as all_from from tracker where user_id ="+"'"+userid+"'"+"group by From_Station order by all_from desc");
			
			
			List<Object[]> list = query.list();
			
			for(Object[] e : list) {
				
				group_by_from_station.put((String)e[0], ((BigInteger) e[1]).intValue());
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
		
		return group_by_from_station;
		
		
		
		
	}
	
	public HashMap<String,Integer> getToStationDetails(String userid) {
		
		HashMap<String,Integer> group_by_to_station = new HashMap<String,Integer>();
		Session session = DBConnectionManager.openSession();
		Transaction tx = null;
		
	
		try {
			
			tx = session.getTransaction();
			tx.begin();
			
			Query query = session.createSQLQuery("select To_Station, count(*) as all_from from tracker where user_id ="+"'"+userid+"'"+"group by To_Station order by all_from desc");
			
			
			List<Object[]> list = query.list();
			
			for(Object[] e : list) {
				
				group_by_to_station.put((String)e[0], ((BigInteger) e[1]).intValue());
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
		
		return group_by_to_station;
		
		
		
		
	}
	
	public HashMap<String,Integer> getClassDetails(String userid) {
		
		HashMap<String,Integer> group_by_class = new HashMap<String,Integer>();
		Session session = DBConnectionManager.openSession();
		Transaction tx = null;
		
	
		try {
			
			tx = session.getTransaction();
			tx.begin();
			
			Query query = session.createSQLQuery("select Classes, count(*) as all_from from tracker where user_id ="+"'"+userid+"'"+"group by Classes order by all_from desc");
			
			List<Object[]> list = query.list();
			
			for(Object[] e : list) {
				
				group_by_class.put((String)e[0], ((BigInteger) e[1]).intValue());
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
		
		return group_by_class;
		
		
		
	}
	
	public HashMap<String,Integer> getBerthDetails(String userid) {
		
		HashMap<String,Integer> group_by_berth = new HashMap<String,Integer>();
		Session session = DBConnectionManager.openSession();
		Transaction tx = null;
		
	
		try {
			
			tx = session.getTransaction();
			tx.begin();
			
			Query query = session.createSQLQuery("select berth, count(*) as all_berth from tracker where user_id ="+"'"+userid+"'"+"group by berth order by all_berth desc");
			
			List<Object[]> list = query.list();
			
			for(Object[] e : list) {
				
				group_by_berth.put((String)e[0], ((BigInteger) e[1]).intValue());
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
		
		return group_by_berth;
		
		
		
	}

public HashMap<String,Integer> getTypeDetails(String userid) {
	
	HashMap<String,Integer> group_by_type = new HashMap<String,Integer>();
	Session session = DBConnectionManager.openSession();
	Transaction tx = null;
	

	try {
		
		tx = session.getTransaction();
		tx.begin();
		
		Query query = session.createSQLQuery("select  T_type.Train_Type,count(*) from tracker inner join (select distinct Train_Name,Train_Type from train_number_name_type) as T_type where tracker.Train = T_type.Train_Name and tracker.user_id=  "+"'"+userid+"'"+" group by T_type.Train_Type");
		
		List<Object[]> list = query.list();
		
		for(Object[] e : list) {
			
			group_by_type.put((String)e[0], ((BigInteger) e[1]).intValue());
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
	
	return group_by_type;
	
	
	
}
	
	public LinkedHashMap<String,Integer> getYearlyDetails(String userid) {
		
		LinkedHashMap<String,Integer> group_by_year = new LinkedHashMap<String,Integer>();
		Session session = DBConnectionManager.openSession();
		Transaction tx = null;
		
	
		try {
			
			tx = session.getTransaction();
			tx.begin();
			
			Query query = session.createSQLQuery("select (select year(DOJ)), count(*) as all_from from tracker where user_id ="+"'"+userid+"'"+"group by (select year(DOJ)) order by (select year(DOJ))");
			
			
			List<Object[]> list = query.list();
			
			for(Object[] e : list) {
				
				group_by_year.put(Integer.toString((Integer)e[0]), ((BigInteger) e[1]).intValue());
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
		
		return group_by_year;
				
		
	}
	
	public LinkedHashMap<String,Integer> getMonthlyDetails(String userid) {
		
		LinkedHashMap<String,Integer> group_by_month = new LinkedHashMap<String,Integer>();
		Session session = DBConnectionManager.openSession();
		Transaction tx = null;
		
	
		try {
			
			tx = session.getTransaction();
			tx.begin();
			
			Query query = session.createSQLQuery("select (select monthname(DOJ)), count(*) as all_from from tracker where user_id ="+"'"+userid+"'"+"group by (select monthname(DOJ)) order by (select month(DOJ))");
			
			List<Object[]> list = query.list();
			
			for(Object[] e : list) {
				
				group_by_month.put((String)e[0], ((BigInteger) e[1]).intValue());
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
		
		return group_by_month;
		
		
		
	}
	
	public LinkedHashMap<String,Integer> getDailyDetails(String userid) {

		LinkedHashMap<String,Integer> group_by_day = new LinkedHashMap<String,Integer>();
		Session session = DBConnectionManager.openSession();
		Transaction tx = null;
		
	
		try {
			
			tx = session.getTransaction();
			tx.begin();
			
			Query query = session.createSQLQuery("select (select dayname(DOJ)), count(*) as all_from from tracker where user_id ="+"'"+userid+"'"+"group by (select dayname(DOJ)) order by (select dayofweek(DOJ))");
			
			
			List<Object[]> list = query.list();
			
			for(Object[] e : list) {
				
				group_by_day.put((String)e[0], ((BigInteger) e[1]).intValue());
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
		
		return group_by_day;
		
		
		
	}
	
	public double distance(double lat1, double lon1, double lat2, double lon2) {
		  double theta = lon1 - lon2;
	
		  double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
	
		  dist = Math.acos(dist);
	
		  dist = rad2deg(dist);
	
		  dist = dist * 60 * 1.1515;
	
		  dist = dist * 1.609344;
	
		  return (dist);
		
		}
	
	public double rad2deg(double rad) {
	
		  return (rad * 180 / Math.PI);
	
		}

	public double deg2rad(double deg) {
			
			  return (deg * Math.PI / 180.0);
		
		}
	

}
