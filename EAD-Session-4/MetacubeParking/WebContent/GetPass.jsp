<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.text.DecimalFormat"%>
<%@ page import="com.metacube.metacubeparking.ConnectionClass"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pass</title>
</head>
<body>
<%
String currency = "";
String passType = "";%>
	<%double price[][]={{0.069,1.40,6.98},{0.14,2.79,13.95},{0.28,6.98,48.85}}; %>
	<div align='center'>
		<form action='GetPass.jsp'>
			<table>
				<tr>
					<td>Vehicle Type Selected :</td>
					<td><%= session.getAttribute("Type") %></td>
				</tr>
				<tr>
					<td></br></td>
				</tr>
				<tr>
					<td>Currency :</td>
					<td><select name="Currency" onchange="this.form.submit()">
							<option value="">SELECT</option>
							<option value="USD">USD</option>
							<option value="INR">INR</option>
							<option value="YEN">YEN</option>
					</select></td>
				</tr>
				<tr>
					<td></br></td>
				</tr>
			</table>
		</form>
		<%if(request.getParameter("Currency")!=null){ %>
		<form action="./SetPass" method="post">
			<table>
				<tr>
					Your Selected Currency is :
					<%=request.getParameter("Currency") %>
					<%session.setAttribute("Currency",request.getParameter("Currency")); %>
				</tr>
				<tr>
					<td></br></td>
				</tr>
				<%int row = 0;
						if( session.getAttribute("Type").equals("cycle"))
							row=0;
						else if(session.getAttribute("Type").equals("bike"))
							row=1;
						else if( session.getAttribute("Type").equals("car"))
							row=2;%>
				<% double factor=0;
			if(request.getParameter("Currency").equals("USD")) 
				factor = 1;
			else if(request.getParameter("Currency").equals("INR")) 
				factor = 71.65;
			else if(request.getParameter("Currency").equals("YEN")) 
				factor = 106.92;
			DecimalFormat dec = new DecimalFormat("#0.00");
			double weeklyPrice = price[row][0]*factor;
			double monthlyPrice = price[row][1]*factor;
			double yearlyPrice = price[row][2]*factor;%>
				<tr>
					<td>Weekly Price : &nbsp;&nbsp;&nbsp;</td>
					<td>Monthly Price :&nbsp;&nbsp;&nbsp;</td>
					<td>Yearly Price :&nbsp;&nbsp;&nbsp;</td>
				</tr>
				<tr>
					<td><input type="radio" name="Price" id="WeeklyPlan"
						value="<%=weeklyPrice/factor %>" checked="checked"
						onclick="<%session.setAttribute("passType","Weekly"); %>">
						<label for="WeeklyPlan"><%=dec.format(weeklyPrice) %></label></td>
					<td><input type="radio" name="Price" id="MonthlyPlan"
						value="<%=monthlyPrice/factor %>"
						onclick="<%session.setAttribute("passType","Monthly"); %>"><label
						for="MonthlyPlan"><%=dec.format(monthlyPrice) %></label></td>
					<td><input type="radio" name="Price" id="YearlyPlan"
						value="<%=yearlyPrice/factor %>"
						onclick="<%session.setAttribute("passType","Yearly"); %>"><label
						for="YearlyPlan"><%=dec.format(yearlyPrice) %></label></td>
				</tr>
			</table>
			<input type="submit" value="Submit">
		</form>
		<%} %>
	</div>
</body>
</html>