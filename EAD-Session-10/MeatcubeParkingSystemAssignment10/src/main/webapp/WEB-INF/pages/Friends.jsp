<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.LinkedList" %>
<%@ page import = "com.metacube.parking.dto.dtoEmployee" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Friends</title>
</head>
<body>
<div align = "center">
	  <table>
	  <%
	  boolean flag = false;
	  	LinkedList<dtoEmployee> list = (LinkedList<dtoEmployee>)session.getAttribute("FriendsProfile");
	  	for(int index = 0 ; index < list.size() ; index ++) {
	  		if(!flag){
	  			%>Select any of your friends to view there profile<p></p><%}
	  		flag=true;
	  %>
	  <tr>
		  <form action = "profile" method = "post">
			  <input type="hidden" name = "EmailId" value = <%=list.get(index).getEmail()%>>
				  <td>
				  	<%=list.get(index).getFullName()%>
				  </td>
				  <td>
				  	<%=list.get(index).getEmail()%>
				  </td>
				  <td>
				  	<input type="submit" value = "View Profile">
				  </td>
		  </form>
	  </tr>
			<%} %>
		</table>
		<%if(!flag){ %>
		!!!Sorry No Friends Found Of Your Company!!!<p></p><%} %>	
		<a href = "home" >Return To HomePage</a>
	  </div>
</body>
</html>