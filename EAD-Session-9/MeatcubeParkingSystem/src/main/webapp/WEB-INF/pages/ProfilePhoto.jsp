<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Profile Photo</title>
</head>
<body>
</br></br></br>

<div align = "center">
<h3>Select Profile Picture</h3>
	<form action = "updateProfilePhoto" method = "post" enctype="multipart/form-data">
	<input type="file" name="PhotoUrl" required="required" accept="image/*">
	<input type ="submit" value = "Submit"></br></br></br>
	</form>
	<a href = "home" >Return To HomePage</a>
	</div>
</body>
</html>