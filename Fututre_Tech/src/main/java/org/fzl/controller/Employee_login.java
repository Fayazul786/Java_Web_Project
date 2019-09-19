package org.fzl.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.fzl.dao.EmployeeDAO;

@WebServlet("/emp_login")
public class Employee_login extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		final String AUTHENTICATE = "SELECT EMAIL,PASSWORD FROM EMP_SIGNUP WHERE EMAIL=? AND PASSWORD=? ";
		res.setContentType("text/html");
        HttpSession session = req.getSession(true);
		RequestDispatcher rd = null;
		
		String email = req.getParameter("emp_un");
		String password = req.getParameter("emp_pass");
		
		try {
			Connection con = EmployeeDAO.getConnection();
			PreparedStatement ps = null;
			ResultSet rs = null;
			if(con!=null) {
				ps = con.prepareStatement(AUTHENTICATE);
				if(ps!=null) {
					ps.setString(1,email);
					ps.setString(2,password);
					//execute the query
					rs = ps.executeQuery();
					
					if(rs.next()) { 
						req.setAttribute("email",email); 
				        rd = req.getRequestDispatcher("welcome_emp.jsp");
						rd.forward(req, res);
					}
					else {
						session.invalidate();
						req.setAttribute("errorMessage","Invalid username or password");
						rd = req.getRequestDispatcher("login_fail.jsp");
						rd.forward(req, res);
					}

				}
		    }//if
			con.close();
		}//try
		catch (SQLException e) {
			e.printStackTrace();
		}//catch
	}//doPost(-,-)

}//class
