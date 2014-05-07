package com.tracker.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tracker.model.Element;
import com.tracker.util.DBConnectionManager;

public class DisplayStatisticsService {
	
	
	public HashMap<String,Integer> getTrainDetails() {
		
		
		
		HashMap<String,Integer> group_by_train = new HashMap<String,Integer>();
		
		
		Session session = DBConnectionManager.openSession();
		Transaction tx = null;
		
	
		try {
			
			tx = session.getTransaction();
			tx.begin();
			
			Query query = session.createSQLQuery("select Train, count(*) as all_train from tracker group by Train order by all_train desc");
			
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
	
	public HashMap<String,Integer> getFromStationDetails() {
		
		HashMap<String,Integer> group_by_from_station = new HashMap<String,Integer>();
		Session session = DBConnectionManager.openSession();
		Transaction tx = null;
		
	
		try {
			
			tx = session.getTransaction();
			tx.begin();
			
			Query query = session.createSQLQuery("select From_Station, count(*) as all_from from tracker group by From_Station order by all_from desc");
			
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
	
	public HashMap<String,Integer> getToStationDetails() {
		
		HashMap<String,Integer> group_by_to_station = new HashMap<String,Integer>();
		Session session = DBConnectionManager.openSession();
		Transaction tx = null;
		
	
		try {
			
			tx = session.getTransaction();
			tx.begin();
			
			Query query = session.createSQLQuery("select To_Station, count(*) as all_to from tracker group by To_Station order by all_to desc");
			
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
	
	public HashMap<String,Integer> getClassDetails() {
		
		HashMap<String,Integer> group_by_class = new HashMap<String,Integer>();
		Session session = DBConnectionManager.openSession();
		Transaction tx = null;
		
	
		try {
			
			tx = session.getTransaction();
			tx.begin();
			
			Query query = session.createSQLQuery("select Classes, count(*) as all_to from tracker group by Classes order by all_to desc");
			
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
	
	public LinkedHashMap<String,Integer> getYearlyDetails() {
		
		LinkedHashMap<String,Integer> group_by_year = new LinkedHashMap<String,Integer>();
		Session session = DBConnectionManager.openSession();
		Transaction tx = null;
		
	
		try {
			
			tx = session.getTransaction();
			tx.begin();
			
			Query query = session.createSQLQuery("select (select  cast(year(DOJ) as char(20))), count(*) from tracker group by (select year(DOJ))");
			
			List<Object[]> list = query.list();
			
			for(Object[] e : list) {
				
				group_by_year.put(((String)e[0]).intern(), ((BigInteger) e[1]).intValue());
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
	
	public LinkedHashMap<String,Integer> getMonthlyDetails() {
		
		LinkedHashMap<String,Integer> group_by_month = new LinkedHashMap<String,Integer>();
		Session session = DBConnectionManager.openSession();
		Transaction tx = null;
		
	
		try {
			
			tx = session.getTransaction();
			tx.begin();
			
			Query query = session.createSQLQuery("select (select monthname(DOJ)), count(*) from tracker group by (select monthname(DOJ)) order by month(DOJ)");
			
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
	
	public LinkedHashMap<String,Integer> getDailyDetails() {
		
		LinkedHashMap<String,Integer> group_by_day = new LinkedHashMap<String,Integer>();
		Session session = DBConnectionManager.openSession();
		Transaction tx = null;
		
	
		try {
			
			tx = session.getTransaction();
			tx.begin();
			
			Query query = session.createSQLQuery("select (select dayname(DOJ)), count(*) from tracker group by (select dayname(DOJ)) order by dayofweek(DOJ)");
			
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
	

}
