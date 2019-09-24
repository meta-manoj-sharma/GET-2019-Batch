<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
<div align = "right">
	Welcome
	<a href = "profilePhoto">
	<img src = <%=session.getAttribute("ProfilePhotoUrl") %> width = 40 height = 40 ></a>
	<%=session.getAttribute("Name") %><p></p>
	<a href = "logout" >Log-Out</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	</div>
	<div align = "center">
	<a href = "friends" >View Your Friends</a><p></p>
	<form action = "profile" method = "post">
	<input type = "hidden" value = <%=session.getAttribute("Email")%> name = "EmailId">
	<input type ="submit" value = "View Your Profile"><p></p>
	</form>
	</div>
</body>
</html>