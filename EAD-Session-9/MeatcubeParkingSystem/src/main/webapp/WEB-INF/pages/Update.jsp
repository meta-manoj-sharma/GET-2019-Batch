<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page import = "com.metacube.parking.dto.dtoEmployee" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Page</title>
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

	<div align = "center"><h1>Details Update Page</h1></div>
		
	<form:form action="detailsUpdate" modelAttribute="dtoEmployee">
	
	  <div class="form-group">
	    <label for="fullName"> Name</label>
	    <form:input path="fullName" type="text" class="form-control" id="fullName" value = "${dtoEmployee.getFullName()}" />
	    <form:errors path="fullName" cssClass="text-danger" />
	  </div><br>
	  <div class="form-group">
	  <form:label path = "gender">Gender</form:label>
      <form:radiobutton path = "gender" value = "Male" label = "Male" checked="${dtoEmployee.getGender() == 'Male' ? 'checked' : '' }" />
      <form:radiobutton path = "gender" value = "Female" label = "Female" checked="${dtoEmployee.getGender() == 'Female' ? 'checked' : '' }" />
	  <form:errors path="gender" cssClass="text-danger" />
	  </div><br>
	  <div class="form-group">
	    <form:input path="email" type="hidden" class="form-control" id="email" value = "${dtoEmployee.getEmail()}" />
	    <form:errors path="email" cssClass="text-danger" />
	  </div><br>
	  <div class="form-group">
	    <label for="contactNumber">Contact Number</label>
	    <form:input path="contactNumber" type="number" class="form-control" id="contactNumber" value = "${dtoEmployee.getContactNumber()}"/>
	    <form:errors path="contactNumber" cssClass="text-danger" />
	  </div><br>
	  <div class="form-group">
	  <form:select path="organization">
			<form:option value="Metacube" label="Metacube" selected="${dtoEmployee.getOrganization() == 'Metacube' ? 'selected' : ''  } "/>
			<form:option value="IBM" label="IBM"  selected="${dtoEmployee.getOrganization() == 'IBM' ? 'selected' : ''  } "/>
			<form:option value="TCS" label="TCS" selected="${dtoEmployee.getOrganization() == 'TCS' ? 'selected' : ''  } "/>
			<form:option value="Wipro" label="Wipro"  selected="${dtoEmployee.getOrganization() == 'Wipro' ? 'selected' : ''  } "/>
	  </form:select>
	  </div><br>
	  <div align="center">
  <button type="submit" class="btn btn-primary" >Update</button>
  </div>
	 </form:form>
	
</body>
</html>