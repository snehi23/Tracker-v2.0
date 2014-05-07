package com.tracker.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import javax.servlet.http.HttpSession;
import com.tracker.model.User_credentials;
import com.tracker.service.LoginService;


public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			 throws ServletException, IOException {	
		
		HttpSession session = request.getSession(true);
		
		 String userId = request.getParameter("user");	
		 String password = request.getParameter("pass");
		 
		 LoginService loginService = new LoginService();
		 boolean result = loginService.authenticate(userId, password);
		 User_credentials user_credentails = loginService.getUserByUserId(userId);
		 
		 System.out.println(user_credentails.getId()+" "+user_credentails.getUserid()+" "+user_credentails.getPass());
		 
		 if(result == true){
			 session.setAttribute("user", userId);		
			 response.sendRedirect("success.jsp");
		 }
		 else{
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
