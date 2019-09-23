<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="pageTitle" scope="request" value="studentList" />
<%@page import="java.util.*"%>
<%--Importing all the dependent classes--%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student list</title>
</head>
<body>
	<div align="center">
		<h1>Show Student Form</h1>
		<hr>
		<br>
		<table>
			<tr>
				<th>First Name</th>
				<th>Last name</th>
				<th>Father's name</th>
				<th>Email</th>
				<th>class</th>
				<th>age</th>
			</tr>
			<tbody>
				<c:forEach items="${studentList}" var="student">
					<tr>
						<td>${student.firstName}</td>
						<td>${student.lastName}</td>
						<td>${student.fatherName}</td>
						<td>${student.email}</td>
						<td>${student.className}</td>
						<td>${student.age}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>