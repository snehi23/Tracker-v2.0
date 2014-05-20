package com.tracker.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tracker.model.Details;
import com.tracker.service.RecordManipulationService;
import com.tracker.service.UserInputService;

public class UserInputEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			 throws ServletException, IOException {	
		
		HttpSession session = request.getSession(true);
	
		String temp = request.getParameter("recordid");
		   
       	Integer train_journey_id = Integer.parseInt(temp);
       	
        System.out.println(train_journey_id);
		
        RecordManipulationService recordManipulationService = new RecordManipulationService();
        
		Details details = (Details) recordManipulationService.editRecord(train_journey_id);
		
		System.out.println(details.getUser_id()+" "+details.getDOJ());
		
		request.setAttribute("details", details);
			 
		session.setAttribute("journey_id", details.getTrain_journey_id());
			 	RequestDispatcher rd = null;
		        rd = request.getRequestDispatcher("Editinfo.jsp");

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
