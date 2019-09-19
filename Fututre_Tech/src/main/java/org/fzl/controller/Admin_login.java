package org.fzl.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.channels.ReadPendingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.fzl.dao.EmployeeDAO;
import org.fzl.dto.EmployeeDTO;

// set session and authentication============================================================================================
@WebServlet("/admin_login")
public class Admin_login extends HttpServlet {
       

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		HttpSession session  =req.getSession(true);
		PrintWriter pw = res.getWriter();
		String ad_un = req.getParameter("ad_un");
		String ad_pass = req.getParameter("ad_pass");
		//
		Properties props = new Properties();
		InputStream is = Admin_login.class.getClassLoader().getResourceAsStream("org/fzl/properties/admin.properties");
		//InputStream	is = new FileInputStream("org/fzl/properties/admin.properties");
		//load the file data into properties class object
		props.load(is);
		//locate file from inputStream
		//is = new FileInputStream("src/main/java/org/fzl/properties/admin.properties");
		//get the data from properties file using properties object
		String username = props.getProperty("username");
		String password = props.getProperty("password");
		
		if(ad_un.equals(username) && ad_pass.equals(password)) {
			List<EmployeeDTO> list = EmployeeDAO.getAllEmployees();
			
			req.setAttribute("emplist",list);
			session.setAttribute("username",ad_un);
			RequestDispatcher rd = req.getRequestDispatcher("login-success.jsp");
			rd.forward(req, res);
		}
		else {
			session.invalidate();
			req.setAttribute("errorMessage","Invalid username or password");
			RequestDispatcher rd = req.getRequestDispatcher("login_fail.jsp");
			rd.forward(req, res);
		}
	}

}
