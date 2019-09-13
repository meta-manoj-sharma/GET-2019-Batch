<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h1 align="center" id="main">Parking System</h1>
  <hr>
  <div align="center">
    <form name="employee" action="./EmployeeResistration" method ="post" >
      <h2>
        Employee data update Form
      </h2>
      <br>
      <label><b>Name</b></label>
      <input name="name" type="text" value = "<%=session.getAttribute("name") %>">
      <br><br>
      <label><b>Gender</b></label>
      <%if(session.getAttribute("gender").equals("Male")) {%>
      <label>
        <input type="radio" name="gender" value="Male" checked>Male
      </label>
        <label>
        <input type="radio" name="gender" value="Female" >Female
      </label>
      <%}else{ %>
       <label>
        <input type="radio" name="gender" value="Male" >Male
      </label>
      <label>
        <input type="radio" name="gender" value="Female" checked>Female
      </label>
      <%} %>
      <br><br>
      <label><b>Email - ID</b></label>
      <input name="email" type="email" value = "<%=session.getAttribute("Email") %>" readonly>
      <br><br>
       <label><b>Password</b></label>
      <input name="password" type="password" value = "<%=session.getAttribute("password") %>">
      <br><br>
      <label><b>Confirm Password</b></label>
      <input type="password" name="confirm" value = "<%=session.getAttribute("password") %>">
      <br><br>
      <label><b>Contact Number</b></label>
      <input type="number" name="contact" value = "<%=session.getAttribute("contact") %>">
      <br><br>
        <label><b>Organization</b></label>
      <select id="opted" name="Organization">
        <option value="Metacube">Metacube</option>
        <option value="Celebal">Celebal</option>
        <option value="Cyntexa" >Cyntexa</option>
        <option value="Paratham Software" >Paratham Software</option>
      </select><br><br>
      <input type="submit" value="Update">
      <br><br>
    </form>
  </div>
</body>
</html>