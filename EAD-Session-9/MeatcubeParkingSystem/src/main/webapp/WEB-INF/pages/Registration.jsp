<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="com.metacube.parking.model.Employee"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
</head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<style>
.form-group {
	width: 50%;
	margin: auto;
}
</style>

<body>

	<div align="center">
		<h1>Registration Page</h1>
		<form:form action="addEmployee" modelAttribute="employee">

			<div class="form-group">
				<label for="fullName">Name</label>
				<form:input path="fullName" type="text" class="form-control" id="fullName" placeholder = "Enter your full name"/>
				<form:errors path="fullName" cssClass="text-danger" />
			</div>
			</br>
			<div class="form-group">
				<form:label path="gender">Gender</form:label>
				<form:radiobutton path="gender" value="Male" label="Male" checked="checked" />
				<form:radiobutton path="gender" value="Female" label="Female" />
				<form:errors path="gender" cssClass="text-danger" />
			</div>
			<div class="form-group">
				<label for="email">Email</label>
				<form:input path="email" type="text" class="form-control" id="email" placeholder = "Enter your email"/>
				<form:errors path="email" cssClass="text-danger" />
			</div>
			<div class="form-group">
				<label for="password">Password</label>
				<form:input path="password" type="password" class="form-control" id="password" placeholder = "Enter your password" />
				<form:errors path="password" cssClass="text-danger" />
			</div>
			<div class="form-group">
				<label for="confirmPassword">Confirm Password</label>
				<form:input path="confirmPassword" type="password" class="form-control" id="confirmPassword" placeholder ="Confirm your password" />
				<form:errors path="confirmPassword" cssClass="text-danger" />
			</div>
			<div class="form-group">
				<label for="contactNumber">Contact Number</label>
				<form:input path="contactNumber" type="number" class="form-control" id="contactNumber" placeholder = "Enter your contact number"/>
				<form:errors path="contactNumber" cssClass="text-danger" />
			</div>
			<div class="form-group">
				</br>
				<form:select path="organization">
					<form:option value="Metacube" label="Metacube" />
					<form:option value="IBM" label="IBM" />
					<form:option value="TCS" label="TCS" />
					<form:option value="Wipro" label="Wipro" />
					<form:option value="Oracle" label="Oracle" />
				</form:select>
			</div>
			<div align="center">
				</br>
				<button type="submit" class="btn btn-primary">Submit</button>
			</div>
		</form:form>
		</br>
		<form:form action="login" modelAttribute="employee">
	</div>
	<div align="center">
		</br> <label for="login">If existing user then login</label>
		<button type="submit" class="btn btn-primary">Login</button>
	</div>
	</form:form>
	</div>
</body>
</html>