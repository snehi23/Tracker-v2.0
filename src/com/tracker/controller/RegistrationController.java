package com.tracker.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jasypt.util.password.ConfigurablePasswordEncryptor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tracker.model.User;
import com.tracker.model.User_credentials;
import com.tracker.service.LoginService;
import com.tracker.service.RegisterService;


@Controller
public class RegistrationController {
	
	@RequestMapping(value="/RegisterUser", method=RequestMethod.POST)
	public void addUser(@ModelAttribute("UserDetails") User userDetails, BindingResult result) {
		
		System.out.println(userDetails.getUser()+" "+userDetails.getUsername()+" "+userDetails.getEmail()+" "+userDetails.getPassword());
		
		/*RegisterService registerService = new RegisterService();
		if(registerService.register(userDetails))
		return "redirect:login.jsp";
		else {
			return "redirect:error.jsp";
		}*/
	
	}
    

	
}
