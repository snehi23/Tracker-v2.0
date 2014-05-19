package com.tracker.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import javax.servlet.http.HttpSession;

import com.tracker.model.StationLocation;
import com.tracker.model.StationLocationPlot;
import com.tracker.service.DisplayStatisticsService;


public class DisplayStatisticsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			 throws ServletException, IOException {	
		
		DisplayStatisticsService displayStatisticsService = new DisplayStatisticsService();
		
		HttpSession session = request.getSession(true);
		
		String userid = (String)session.getAttribute("userid");
		
		ArrayList<StationLocation> station_loc_list = displayStatisticsService.getLocationDetails(userid);
		
		request.setAttribute("station_loc_list", station_loc_list);
		
		ArrayList<StationLocationPlot> station_loc_plot = displayStatisticsService.getMapPlotDetails(userid);
		
		request.setAttribute("station_loc_plot", station_loc_plot);
		
		Double dist = displayStatisticsService.getTotalDistanceDetails(userid);
		
		request.setAttribute("total_distance",Math.floor(dist));
		
		
		HashMap<String,Integer> group_by_train_list = displayStatisticsService.getTrainDetails(userid);
		
		request.setAttribute("group_by_train_list", group_by_train_list);
		
		HashMap<String,Integer> group_by_from_station_list = displayStatisticsService.getFromStationDetails(userid);
		
		request.setAttribute("group_by_from_station_list", group_by_from_station_list);
		
		HashMap<String,Integer> group_by_to_station_list = displayStatisticsService.getToStationDetails(userid);
		
		request.setAttribute("group_by_to_station_list", group_by_to_station_list);
		
		HashMap<String,Integer> group_by_class_list = displayStatisticsService.getClassDetails(userid);
		
		request.setAttribute("group_by_class_list", group_by_class_list);
		
		HashMap<String,Integer> group_by_berth_list = displayStatisticsService.getBerthDetails(userid);
		
		request.setAttribute("group_by_berth_list", group_by_berth_list);
		
		HashMap<String,Integer> group_by_type_list = displayStatisticsService.getTypeDetails(userid);
		
		request.setAttribute("group_by_type_list", group_by_type_list);
		
		HashMap<String,Integer> group_by_year_list = displayStatisticsService.getYearlyDetails(userid);
		
		request.setAttribute("group_by_year_list", group_by_year_list);
		
		HashMap<String,Integer> group_by_month_list = displayStatisticsService.getMonthlyDetails(userid);
		
		request.setAttribute("group_by_month_list", group_by_month_list);
		
		HashMap<String,Integer> group_by_day_list = displayStatisticsService.getDailyDetails(userid);
		
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