package com.tracker.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tracker.model.Details;
import com.tracker.model.User_credentials;
import com.tracker.service.LoginService;
import com.tracker.service.UserInputService;

public class UserInputController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			 throws ServletException, IOException {	
		
		HttpSession session = request.getSession(true);
	
        String doj = request.getParameter("DOJ");
        String Train = request.getParameter("Train");
        String From = request.getParameter("From");
        String To = request.getParameter("To");
        String Classes = request.getParameter("classes");
        String berth = request.getParameter("berth");
        String Comments = request.getParameter("comments");
        
        String userid = (String)session.getAttribute("userid");
		 
		 UserInputService userInputService = new UserInputService();
		 
		 Details details = new Details(0,doj ,Train.replaceAll("\\P{L}", " ").trim() , From.replaceAll(".*\\(", "").replaceAll("\\)", "").trim(), To.replaceAll(".*\\(", "").replaceAll("\\)", "").trim(), Classes,berth, Comments);
		 
		 if(userInputService.setUserDetails(details,userid))
		 response.sendRedirect("displayinfo.jsp");
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
