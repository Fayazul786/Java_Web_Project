<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Employee Login Page</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="bootstrap.css">
<link rel="stylesheet" type="text/css" href="login.css">
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

<div class="jumbotron text-center">
    <div class="container">
        <!-- -->
        <!-- Login page -->
        <section>
          <div class="container1">
            <div class="login-form">
                <h1><u>Employee Login</u></h1>
              <form action="emp_login" method="post">
                  <input type="text" name="emp_un" placeholder="Username">
                  <input type="password" name="emp_pass" placeholder="Password">
                  <input type="submit" name="s2" value="Login">
              </form>
            </div>
          </div>
        </section>
        <!-- Login Page -->
        <!-- -->
    </div> 
</div>
  

 <blockquote class="blockquote text-left">
     <br>
  <p class="mb-0">&copy 2019 Future technology.All Right Reserved &reg;.</p>
  <footer class="blockquote-footer">futuretechnology<cite title="Source Title">.com</cite></footer>
</blockquote>
</body>
</html>
