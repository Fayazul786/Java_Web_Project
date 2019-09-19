<%@page import="org.fzl.dao.EmployeeDAO"%>
<%@page import="org.omg.PortableServer.ForwardRequest"%>
<%@page import="org.fzl.dto.EmployeeDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>  

    
<!DOCTYPE html>
<%
//	List<EmployeeDTO> elistt=(List<EmployeeDTO>)request.getAttribute("emplist");

    List<EmployeeDTO> list=EmployeeDAO.getAllEmployees();  
    request.setAttribute("elist",list);  

%>
<html lang="en">
<head>
  <title>Future Technology</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="bootstrap.css">
<link rel="icon" href="Logo.png">
<script src="bootstrap.js" ></script>
</head>
<body>

<!--    Nav bar-->
   <nav class="navbar navbar-expand-lg navbar-light bg-light">
       <a class="navbar-brand" href="index.html">Future Technology</a>

  <div class="collapse navbar-collapse " id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto"> <!-- form-inline my-2 my-lg-0 -->
      <li class="nav-item">
          <a class="nav-link" href="index.html">Home</a>
      </li>
      <li class="nav-item active">
          <a class="nav-link" href="admin_login.jsp">Admin Login <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
          <a class="nav-link" href="employee_login.jsp">Employee Login</a>
      </li>
      <li class="nav-item">
          <a class="nav-link" href="signup_page.html">Sign Up</a>
      </li>
      <li class="nav-item">
          <a class="nav-link" href="aboutus_page.html">About Us</a>
      </li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="index.html"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
    </ul>
  </div>
</nav>

<div class="jumbotron text-center">
    <div class="container">
        <h1><u>Employee List</u></h1>  <br>
       <div class="scrollable"> 
        <table border='1.5' width='100%'>
          <tr><th>Id</th><th>FirstName</th><th>LastName</th><th>Gender</th><th>Status</th><th>DOB</th><th>Email</th><th>Password</th><th>Phone</th><th>Designation</th><th>Edit</th><th>Delete</th></tr>
          
         <%--  <% for(EmployeeDTO emp:elist){
             Arranging data in tabular form --%> 
            <c:forEach items="${elist}" var="emp">
            <tr> 
                <td>${emp.getId()}</td> 
                <td>${emp.getfName()}</td>
                <td>${emp.getlName()}</td> 
                <td>${emp.getGender()}</td>
                <td>${emp.getmStatus()}</td>
                <td>${emp.getDob()}</td>
                <td>${emp.getEmail()}</td>
                <td>${emp.getPassword()}</td>
                <td>${emp.getPhNum()}</td>
                <td>${emp.getDegn()}</td>
                <td><a href="edit_emp.jsp?id=${emp.getId()}">Edit</a></td>
                <td><a href="delete_emp.jsp?id=${emp.getId()}">Delete</a></td>
            </tr> 
           </c:forEach>
          
        </table>
      </div>
       <!-- Put Employee Details to perform edit and delete operation by admin  -->

    </div> 
</div>

 <blockquote class="blockquote text-left">
     <br>
  <p class="mb-0">&copy 2019 Future technology.All Right Reserved &reg;.</p>
  <footer class="blockquote-footer">futuretechnology<cite title="Source Title">.com</cite><br>
  </footer>
</blockquote>
</body>
</html>