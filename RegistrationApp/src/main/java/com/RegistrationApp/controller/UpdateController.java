package com.RegistrationApp.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.RegistrationApp.model.DAOServiceimpl;


@WebServlet("/UpdateRegistration")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UpdateController() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String email =request.getParameter("email");
		String mobile =request.getParameter("mobile");
		
		request.setAttribute("email", email);
		request.setAttribute("mobile", mobile);
		 
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/Update-registration.jsp");
		rd.forward(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
		String email =request.getParameter("email");
		String mobile =request.getParameter("mobile");
		
		DAOServiceimpl service = new DAOServiceimpl();
	    service.connectDB();
	    service.updateRegistration(mobile, email);
	   
	    
	    ResultSet result = service.ListRegistration();
		request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/List-registration.jsp");
		rd.forward(request,response);
	}
		
}
