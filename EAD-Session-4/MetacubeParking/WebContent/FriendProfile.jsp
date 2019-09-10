<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.metacube.metacubeparking.ConnectionClass"%>
<%@ page import="com.mysql.jdbc.PreparedStatement"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
ConnectionClass.connectionQuery();
String friendEmail = (String)request.getParameter("id");
PreparedStatement statement1 = (PreparedStatement) ConnectionClass.connect.prepareStatement("select * from employeeData where email = '"+friendEmail+"' ;");
ResultSet resultSet1 = statement1.executeQuery();
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
		<% while(resultSet1.next()){ %>
		<tr>
			<td><%=resultSet1.getInt(1) %></td>
			<td><%=resultSet1.getString(2) %></td>
			<td><%=resultSet1.getString(3) %></td>
			<td><%=resultSet1.getString(5) %></td>
			<td><%=resultSet1.getString(6) %></td>
			<td><%=resultSet1.getString(7) %></td>
			<%} %>
		</tr>
	</table>
	<br>
	<br>
	<a href="HomePage.jsp">Home Page </a>
	<br>
</body>
</html>