package com.tracker.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tracker.service.RecordManipulationService;


public class DeleteRecordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			 throws ServletException, IOException {	
		

    	HttpSession session = request.getSession(true);
       	String temp = request.getParameter("recordid");
   
       	Integer train_journey_id = Integer.parseInt(temp);
       	
        System.out.println(train_journey_id);
       
        String userid = (String) session.getAttribute("userid");
        
        RecordManipulationService manipulationService = new RecordManipulationService();
        RequestDispatcher rd = null;
        
       
        if(manipulationService.deleteRecord(train_journey_id)){
        	
        	request.setAttribute("Record_Confirmation", "Journey Deleted Successfully !!!");
        	
        	rd = request.getRequestDispatcher("/JourneyDetailsController");
        	
        	rd.forward(request, response);
		 }
		 else {
			 response.sendRedirect("error.jsp");
		 }
        
       
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
