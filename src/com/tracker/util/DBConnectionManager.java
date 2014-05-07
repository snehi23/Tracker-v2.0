package com.tracker.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

@SuppressWarnings("deprecation")
public class DBConnectionManager {
	
	private static  SessionFactory sessionFactory;
	
	static {
		
		try {
			
			sessionFactory = new Configuration().configure().buildSessionFactory();
		}catch (Throwable ex) {

			System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
			
		}
	}
		
	public static Session openSession() {
		
	return sessionFactory.openSession();	

	}
		
}


