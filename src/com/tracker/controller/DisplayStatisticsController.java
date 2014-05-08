package com.tracker.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.tracker.service.DisplayStatisticsService;


public class DisplayStatisticsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			 throws ServletException, IOException {	
		
		DisplayStatisticsService displayStatisticsService = new DisplayStatisticsService();
		
		HashMap<String,Integer> group_by_train_list = displayStatisticsService.getTrainDetails();
		
		request.setAttribute("group_by_train_list", group_by_train_list);
		
		HashMap<String,Integer> group_by_from_station_list = displayStatisticsService.getFromStationDetails();
		
		request.setAttribute("group_by_from_station_list", group_by_from_station_list);
		
		HashMap<String,Integer> group_by_to_station_list = displayStatisticsService.getToStationDetails();
		
		request.setAttribute("group_by_to_station_list", group_by_to_station_list);
		
		HashMap<String,Integer> group_by_class_list = displayStatisticsService.getClassDetails();
		
		request.setAttribute("group_by_class_list", group_by_class_list);
		
		HashMap<String,Integer> group_by_year_list = displayStatisticsService.getYearlyDetails();
		
		request.setAttribute("group_by_year_list", group_by_year_list);
		
		HashMap<String,Integer> group_by_month_list = displayStatisticsService.getMonthlyDetails();
		
		request.setAttribute("group_by_month_list", group_by_month_list);
		
		HashMap<String,Integer> group_by_day_list = displayStatisticsService.getDailyDetails();
		
		request.setAttribute("group_by_day_list", group_by_day_list);
		
		RequestDispatcher rd = null;
		 
        rd = request.getRequestDispatcher("/displaystatistics.jsp");
        
        rd.forward(request, response);

		
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			 throws ServletException, IOException {
		 processRequest(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			 throws ServletException, IOException {
		 processRequest(request, response);
	}
	@Override
	public String getServletInfo() {
		 return "Short description";
	}
}