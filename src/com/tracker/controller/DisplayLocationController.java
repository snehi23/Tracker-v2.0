package com.tracker.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tracker.model.StationLocation;
import com.tracker.model.StationLocationPlot;
import com.tracker.service.DisplayLocationService;

public class DisplayLocationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			 throws ServletException, IOException {	
		
		DisplayLocationService displayLocationService = new DisplayLocationService();
		
		ArrayList<StationLocation> station_loc_list = displayLocationService.getLocationDetails();
		
		request.setAttribute("station_loc_list", station_loc_list);
		
		ArrayList<StationLocationPlot> station_loc_plot = displayLocationService.getMapPlotDetails();
		
		request.setAttribute("station_loc_plot", station_loc_plot);
		
		
		RequestDispatcher rd = null;
		 
        rd = request.getRequestDispatcher("/displaylocation.jsp");
        
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