<%@page import="org.fzl.dao.EmployeeDAO"%>
<%@page import="org.fzl.dto.EmployeeDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Welcome Employee</title>
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
      <li class="nav-item">
          <a class="nav-link" href="admin_login.jsp">Admin Login</a>
      </li>
      <li class="nav-item active">
          <a class="nav-link" href="employee_login.jsp">Employee Login <span class="sr-only">(current)</span></a>
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
<!--            <h1>Welcome To Your Account</h1><br>  -->
           
      <% 
        String email=(String)request.getAttribute("email"); 
        EmployeeDTO dto = EmployeeDAO.getEmployeeByEmail(email); 
        
       %>  
       
       <h1>Welcome Back <%=dto.getfName()+" "+dto.getlName()%></h1><br>
                
        <table border="2" width="100%">
        
           <tr><th>Id</th><th>FirstName</th><th>LastName</th><th>Gender</th><th>Status</th><th>DOB</th><th>Email</th><th>Password</th><th>Phone</th><th>Designation</th><th>Edit</th></tr>
            <tr> 
                <td><%=dto.getId()%></td> 
                <td><%=dto.getfName()%></td>
                <td><%=dto.getlName()%></td> 
                <td><%=dto.getGender()%></td>
                <td><%=dto.getmStatus()%></td>
                <td><%=dto.getDob()%></td>
                <td><%=dto.getEmail()%></td>
                <td><%=dto.getPassword()%></td>
                <td><%=dto.getPhNum()%></td>
                <td><%=dto.getDegn()%></td>
                <td><a href="edit_by_emp.jsp?id=<%=dto.getId()%>">Edit</a></td>
            </tr> 
        </table><br>
           
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