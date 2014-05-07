package com.tracker.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tracker.model.Details;
import com.tracker.service.UserInputService;

public class JourneyDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			 throws ServletException, IOException {	
		
		UserInputService userInputservice = new UserInputService();
		
		ArrayList<Details> details_list = userInputservice.getUserDetails();
		
		request.setAttribute("details_list", details_list);
		
		RequestDispatcher rd = null;
		 
        rd = request.getRequestDispatcher("/displayinfo.jsp");
        
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
