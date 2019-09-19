package org.fzl.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.fzl.dao.EmployeeDAO;
import org.fzl.dto.EmployeeDTO;

@WebServlet("/edit")
public class Edit extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = null;
		EmployeeDTO dto = null;
		RequestDispatcher rd = null;
	    HttpSession ses  =req.getSession(true);
	    dto = new EmployeeDTO();
	    
	    ///////////////==Date Convert from String to sql
	    String date = req.getParameter("dob");

	    java.sql.Date sDate = java.sql.Date.valueOf(date);
	    //////////////
	    // Cast phnum string to appropriate
	    String sPhNum=req.getParameter("emp_ph");
	    Long lPhNum=Long.parseLong(sPhNum);
	    /////////////
	    String sId=req.getParameter("id");
	    int id=Integer.parseInt(sId);
	    /////////////
	    dto.setId(id);
	    dto.setfName(req.getParameter("emp_fname"));
	    dto.setlName(req.getParameter("emp_lname"));
	    dto.setGender(req.getParameter("gen"));
	    dto.setmStatus(req.getParameter("m_st"));
	    //bo.setDob(req.getParameter("dob"));
	    dto.setDob(sDate);
	    dto.setEmail(req.getParameter("emp_email"));
	    dto.setPassword(req.getParameter("emp_pass"));
	    dto.setPhNum(lPhNum);
	    dto.setDegn(req.getParameter("emp_deg"));
	    

	    // invoke save() of DAO class to save the data in to DB
        int status=EmployeeDAO.update(dto);  
        
        //
        System.out.println("Status for update::"+status);
        
        if(status>0){  
            rd = req.getRequestDispatcher("login-success.jsp");
    		rd.forward(req, res);
        }
        else{  
        	rd = req.getRequestDispatcher("edit_emp.jsp");
    		rd.forward(req, res);
        }  
	    
	}

}
