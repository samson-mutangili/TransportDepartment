package com.samson;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 * Servlet implementation class Signup
 */
@WebServlet("/Signup")
public class Signup extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//get the data from the form
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String password_confirm = request.getParameter("passconfirm");
		String email = request.getParameter("email");
		
		//create an object of LoginDao class
		LogInDao dao = new LogInDao();
		dao.insertData(firstname, lastname, username, password, password_confirm, email);
		
		response.sendRedirect("login.jsp");
	}

}
