<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "com.metacube.parking.dto.dtoEmployee" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile</title>
</head>
<body>
<div align ="center">
	<%dtoEmployee employee = (dtoEmployee)session.getAttribute("Profile");%>
	<table>
		<tr>
			<td>
				Name :
			</td>
			<td>
				<%=employee.getFullName() %>
			</td>
		</tr>
		<tr>
			<td>
				Gender :
			</td>
			<td>
				<%=employee.getGender() %>
			</td>
		</tr>
		<tr>
			<td>
				Email :
			</td>
			<td>
				<%=employee.getEmail() %>
			</td>
		</tr>
		<tr>
			<td>
				Contact Number :
			</td>
			<td>
				<%=employee.getContactNumber() %>
			</td>
		</tr>
		<tr>
			<td>
				Company :
			</td>
			<td>
				<%=employee.getOrganization() %>
			</td>
		</tr>
	</table>
	<%if(session.getAttribute("IsUser")!=null){ %>
	<a href = "update">Update Your Profile</a>
	<%session.removeAttribute("IsUser"); }%> 
	<a href = "home" >Return To HomePage</a>
	</div>
</body>
</html>