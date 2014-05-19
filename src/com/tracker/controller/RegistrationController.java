package com.tracker.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jasypt.util.password.ConfigurablePasswordEncryptor;

import com.tracker.model.User_credentials;
import com.tracker.service.LoginService;
import com.tracker.service.RegisterService;

public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			 throws ServletException, IOException {	
		
			HttpSession session = request.getSession(true);
		
			String name = request.getParameter("name");
	        String username = request.getParameter("username");
	        String email = request.getParameter("email");
	        String pass = request.getParameter("password");
	    
	        
	        
	        System.out.println(" "+name+" "+username+" "+email+" "+pass);
	        
	        ConfigurablePasswordEncryptor encryptor = new ConfigurablePasswordEncryptor();
	        encryptor.setAlgorithm("SHA-512");
	        encryptor.setPlainDigest(true);
	        String password = encryptor.encryptPassword(pass);	
			
			
		RegisterService registerService = new RegisterService();
		 boolean result = registerService.register(name,username,email,password);
		 
		 
		 if(result == true){
			 		
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
