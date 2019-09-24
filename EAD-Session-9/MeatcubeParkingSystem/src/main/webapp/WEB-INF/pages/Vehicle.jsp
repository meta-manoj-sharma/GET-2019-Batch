<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page import = "com.metacube.parking.model.Employee" %>
<!DOCTYPE html>
<html>
<head>SS
<meta charset="ISO-8859-1">
<title>Vehicle Page</title>
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
	<h1>Vehicle Addition Page</h1>
		
	<form:form action="addVehicle" modelAttribute="vehicle">
	
	  <div class="form-group">
	    <label for="vehicleName">Vehicle Name</label>
	    <form:input path="vehicleName" type="text" class="form-control" id="vehicleName" palceholder = "Enter your vehicle name"/>
	    <form:errors path="vehicleName" cssClass="text-danger" />
	  </div><br>
	  
	  <div class="form-group">
	  <form:select path="vehicleType">
			<form:option value="Bicycle" label="Bicycle"/>
			<form:option value="Two Wheeler" label="Two Wheeler"/>
			<form:option value="Four Wheeler" label="Four Wheeler"/>
	  </form:select>
	  </div><br>
	  
	  <div class="form-group">
	    <label for="vehicleNumber">Vehicle Number</label>
	    <form:input path="vehicleNumber" type="text" class="form-control" id="vehicleNumber" placeholder = "Enter your vehicle number"/>
	    <form:errors path="vehicleNumber" cssClass="text-danger" />
	  </div><br>
	  
	  <div class="form-group">
	    <label for="employeeId">Employee Id</label>
	    <form:input path="employeeId" type="number" class="form-control" id="employeeId" placeholder = "Enter your employee Id" />
	    <form:errors path="employeeId" cssClass="text-danger" />
	  </div><br>
	  
	  <div class="form-group">
	  <label for="vehicleDetails">vehicle Details</label>
	  <form:textarea path="vehicleDetails" rows="5" cols="30" id="vehicleDetails"/>
	  </div><br>
	  
	  <div align="center">
  <button type="submit" class="btn btn-primary" >Register</button>
  </div>
	 </form:form>
	
	</div>
</body>
</html>