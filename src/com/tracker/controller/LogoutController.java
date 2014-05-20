package com.tracker.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutController extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public LogoutController() {
        super();
    }
 
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
 
    	HttpSession session = request.getSession(true);
    	RequestDispatcher rd = null;
    	session.removeAttribute("userid");
    	session.invalidate();
    	
    	rd = request.getRequestDispatcher("/login.jsp");

    	rd.forward(request, response);
    	      	
        } 
}