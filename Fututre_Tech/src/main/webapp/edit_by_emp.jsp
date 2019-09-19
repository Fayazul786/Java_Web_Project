<%@page import="org.fzl.dao.EmployeeDAO"%>
<%@page import="org.fzl.dto.EmployeeDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Edit By Employee</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="bootstrap.css">
<link rel="stylesheet" type="text/css" href="sign_up.css">
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
  </div>
</nav>

<%

  String id = request.getParameter("id");
  EmployeeDTO emp = EmployeeDAO.getEmployeeById(Integer.parseInt(id));
  System.out.println("id-edit_by_emp::"+id);

%>

<div class="jumbotron text-center">
    <div class="container">
        <div class="signup-form">
            <h1><u>Edit By Employee</u></h1><br>
            <form action="edit_by_emp" method="get">
               <input type="hidden" name="id" value="<%=emp.getId() %>"/>
                <div id="name">
                    Employee Name<span style="color:red">*</span><br>
                  <input type="text" name="emp_fname" placeholder="First Name" value="<%=emp.getfName()%>">&nbsp;&nbsp;&nbsp;&nbsp;
                  <input type="text" name="emp_lname" placeholder="Last Name" value="<%=emp.getlName()%>">
                </div>
                
                <div id="g-m-dob">
                  Gender<span style="color:red">*</span> &nbsp;&nbsp;
                  <input type="radio" name="gen" value="M"> M &nbsp;
                  <input type="radio" name="gen" value="F"> F &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                
                  Maritial Status<span style="color:red">*</span> &nbsp;&nbsp;
                  <select name="m_st">
                      <option>Married</option>
                      <option>UnMarried</option>
                  </select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          
                  Date Of Birth<span style="color:red">*</span> &nbsp;&nbsp;
                  <input type="date" name="dob" value="<%=emp.getDob()%>">
                </div>
                
                <div id="em-pas">
                  Email<span style="color:red">*</span>&nbsp;&nbsp;
                  <input type="email" name="emp_email" placeholder="Email Address" value="<%=emp.getEmail()%>">&nbsp;&nbsp;
      
                  Password<span style="color:red">*</span>&nbsp;&nbsp;
                  <input type="password" name="emp_pass" placeholder="Password" value="<%=emp.getPassword()%>"><br>
                </div>
                
                <div id="ph-dg">
                  Phone &nbsp;
                  <input type="text" name="emp_ph" placeholder="Phone Number" value="<%=emp.getPhNum()%>">&nbsp;
                
                  Designation &nbsp;
                  <input type="text" name="emp_deg" placeholder="Enter Designation" value="<%=emp.getDegn()%>"><br><br><br>
                </div>
                
                <input type="submit" name="s3" value="Save"> &nbsp;&nbsp;&nbsp;&nbsp;
                <input type="reset" name="reset" value="Reset">
            </form>
        </div>
    </div> 
</div>
  

 <blockquote class="blockquote text-left">
     <br>
  <p class="mb-0">&copy 2019 Future technology.All Right Reserved &reg;.</p>
  <footer class="blockquote-footer">futuretechnology<cite title="Source Title">.com</cite></footer>
</blockquote>
</body>
</html>
