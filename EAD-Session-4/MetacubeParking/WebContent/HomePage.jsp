<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.metacube.metacubeparking.ConnectionClass"%>
<%@ page import="com.mysql.jdbc.PreparedStatement"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home page</title>
</head>
<body>
	<a href="LogoutPage.jsp" style="float: right;">Logout </a>
	<br>
	<%
ConnectionClass.connectionQuery();
String email = (String)session.getAttribute("Email");
PreparedStatement statement = (PreparedStatement) ConnectionClass.connect.prepareStatement("select * from employeeData where email = '"+email+"' ;");
ResultSet resultSet = statement.executeQuery();

%>
	<table border="1">
		<tr>
			<th>EmployeeId</th>
			<th>Name</th>
			<th>Gender</th>
			<th>Email</th>
			<th>Contact</th>
			<th>Oganization</th>
		</tr>
		<% while(resultSet.next()){ %>
		<tr>
			<td><%=resultSet.getInt(1) %></td>
			<td><%=resultSet.getString(2) %></td>
			<td><%=resultSet.getString(3) %></td>
			<td><%=resultSet.getString(5) %></td>
			<td><%=resultSet.getString(6) %></td>
			<td><%=resultSet.getString(7) %></td>
			<td><a href="Update.jsp">Edit </a><br></td>
			<%
			session.setAttribute("name", resultSet.getString(2));
			session.setAttribute("gender", resultSet.getString(3));
			session.setAttribute("contact", resultSet.getString(6));
			session.setAttribute("organization", resultSet.getString(7));
			session.setAttribute("password", resultSet.getString(4));
		
		} %>
		</tr>
	</table>
	<br>
	<br>
	<a href="Vehicle.html">Add Vehicle </a>
	<br>
	<a href="Friends.jsp">Friends </a>
	<br>
</body>
</html>