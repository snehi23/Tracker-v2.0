package com.tracker.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tracker.model.Details;
import com.tracker.service.RecordManipulationService;

public class UserInputUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			 throws ServletException, IOException {	
		
		HttpSession session = request.getSession(true);
		RequestDispatcher rd = null;
	
		String doj = request.getParameter("DOJ");
        String Train = request.getParameter("Train");
        String From = request.getParameter("From");
        String To = request.getParameter("To");
        String Classes = request.getParameter("classes");
        String berth = request.getParameter("berth");
        String Comments = request.getParameter("comments");
        String userid = (String)session.getAttribute("userid");
        int journeyid = (Integer) session.getAttribute("journey_id");
        
        Details details = new Details();
        details.setDOJ(doj);
        details.setTrain(Train);
        details.setFrom_Station(From);
        details.setTo_Station(To);
        details.setClasses(Classes);
        details.setBerth(berth);
        details.setComments(Comments);
        details.setUser_id(userid);
        details.setTrain_journey_id(journeyid);
        
        RecordManipulationService recordManipulationService = new RecordManipulationService();
        
		if(recordManipulationService.updateRecord(details)) {
			
			
		        rd = request.getRequestDispatcher("Editinfo.jsp");
				request.setAttribute("Record_Confirmation", "Journey Updated Successfully !!!");

		        rd.forward(request, response);
		        
	} else {
		
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
