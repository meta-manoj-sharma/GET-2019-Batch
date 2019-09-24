<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page import = "com.metacube.parking.model.Employee" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<style>
.form-group{
width: 50%;
margin: auto;
}
</style>

<body>

	<div align="center">
	<h1>Login Page</h1>
		
	<form:form action="login" modelAttribute="login">
	
	  <div class="form-group">
	    <label for="email">Email</label>
	    <form:input path="email" type="text" class="form-control" id="email"/>
	    <form:errors path="email" cssClass="text-danger" />
	  </div>
	  <div class="form-group">
	    <label for="password">Password</label>
	    <form:input path="password" type="password" class="form-control" id="password"/>
	    <form:errors path="password" cssClass="text-danger" />
	  </div><br>
	  <div align="center">
  <button type="submit" class="btn btn-primary" >Login</button>
  </div>
	 </form:form>
	
	</div>
</body>
</html>