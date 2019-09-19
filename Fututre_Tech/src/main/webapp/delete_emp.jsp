<%@page import="org.fzl.dao.EmployeeDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
 <jsp:useBean id="emp" class="org.fzl.dto.EmployeeDTO"/>
 <jsp:setProperty property="*" name="emp"/>
 
 <%
  EmployeeDAO.delete(emp);
  response.sendRedirect("login-success.jsp");
 %>