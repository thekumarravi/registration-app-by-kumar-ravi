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


@WebServlet("/verifyLogin")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String email = request.getParameter("email");
	    String password = request.getParameter("password");

	    // Instantiate the service and connect to the database
	    DAOServiceimpl service = new DAOServiceimpl();
	    service.connectDB();

	    boolean status = service.verifyLogin(email, password);

	    if (status) {
	    	//Creating session here....
	    	HttpSession session = request.getSession(true);
	    	session.setMaxInactiveInterval(10);
	    	session.setAttribute("email", email);
	    	
	        // Forward to add-registration.jsp if login is successful
	        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/add-registration.jsp");
	        rd.forward(request, response);
	    } else {
	        // Set error attribute and forward to Login.jsp
	        request.setAttribute("error", "Invalid username/password");
	        RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
	        rd.forward(request, response);
	    }
	    // No additional forwards outside of the conditional logic
	}


}
