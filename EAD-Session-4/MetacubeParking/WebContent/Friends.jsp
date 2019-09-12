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
String email = (String)session.getAttribute("Email");
PreparedStatement statement = (PreparedStatement) ConnectionClass.connect.prepareStatement("SELECT employeeId, name, email FROM employeeData WHERE email != '"+email+"' AND organization IN (SELECT organization FROM employeeData WHERE email = '"+email+"'); ;");
ResultSet resultSet = statement.executeQuery();
%>
	<table border="1">
		<tr>
			<th>EmployeeId</th>
			<th>Name</th>
			<th>Email</th>
		</tr>
		<% while(resultSet.next()){ %>
		<tr>
			<td><%=resultSet.getInt("employeeId") %></td>
			<td><%=resultSet.getString("Name") %></td>
			<td><%=resultSet.getString("Email") %></td>
			<td><a
				href="FriendProfile.jsp?id=<%=resultSet.getString("Email") %>">Check
					Profile </a><br></td>
			<%} %>
		</tr>
	</table>
	<br><br>
	<a href="HomePage.jsp">Home Page </a>
	<br>
</body>
</html>