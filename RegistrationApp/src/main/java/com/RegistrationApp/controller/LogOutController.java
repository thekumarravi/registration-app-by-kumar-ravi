package com.RegistrationApp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/logOut")
public class LogOutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LogOutController() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		HttpSession session = request.getSession(false);
		session.invalidate();
		
		RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
        rd.forward(request, response);
	}

}
