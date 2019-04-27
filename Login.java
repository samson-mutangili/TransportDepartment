package com.samson;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get the data
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//create an object of log in dao
		LogInDao dao = new LogInDao();
		
		//check the credentials of the user
		if(dao.check(username, password)){
			
			//set a session
			HttpSession session = request.getSession();
			//send data to a session
			session.setAttribute("username",username);
			//send a redirect to the welcome page
			response.sendRedirect("welcome.jsp");
		} else {
			//return the user to the log in page
			response.sendRedirect("login.jsp");
		}
	}

	

}
