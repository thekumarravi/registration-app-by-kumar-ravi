package com.RegistrationApp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.RegistrationApp.model.DAOServiceimpl;




@WebServlet("/addReg")

       
   
public class AddRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public AddRegistrationController() {	
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/add-registration.jsp");
		rd.forward(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		HttpSession session = request.getSession(false);
		session.setMaxInactiveInterval(60);
		if(session.getAttribute("email")!=null) {
		String Name = request.getParameter("Name");
		String Email = request.getParameter("Course");
		String Course = request.getParameter("Email");
		String Mobile= request.getParameter("Mobile");
		
		DAOServiceimpl service = new DAOServiceimpl();
		service.connectDB();
		service.addRegistration(Name, Course,Email, Mobile);
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/add-registration.jsp");
		rd.forward(request,response);
		
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request,response);
			
		}
	

		
	}

}
