<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="js/plan.js"></script>
<meta charset="ISO-8859-1">
<title>Plan Page</title>
</head>
<body onload="showCurrency()">
<%System.out.println(session.getAttribute("Type")); %>
<%if(session.getAttribute("Type")!= null){ %>
 <div id="SelectPlanDiv">
            <br/>
            <h2 align="center">Plan Selection</h2>
            <form:form action="addPlan" method="POST"  modelAttribute="plan">
            <table align="center">
                <tr>
                    <td colspan="3">
                        <label><b>Currency: </b></label>
                        <select path = "currency" name="CurrencySelect" id="CurrencySelect" onchange="showCurrency()" required>
                            <option value="INR">INR</option>
                            <option value="USD">USD</option>
                            <option value="YEN">YEN</option>
                        </select>
                    </td>
                </tr><br>
                <tr>
                    <td colspan="1">
                        <label><b>Vehicle Type: </b></label>
                    </td> 
                    <td colspan="2">
                        <label id="vehicleType"><%=session.getAttribute("Type") %></label>
                    </td>
                    
                </tr><br>
                <tr>
                    <td colspan="1">
                        <label><b>Plan: </b></label>
                    </td> 
                    
                </tr><br>
                <tr>
                    <td colspan="1">
                        <label>
                            <input type="radio"  name="VehiclePlan" id="DailyPlan" value="Daily" required onclick="showTotal()" checked="checked">Daily
                        </label>
                    </td>
                    <td colspan="1">
                        <label>
                            <input type="radio"  name="VehiclePlan" id="MonthlyPlan" value="Monthly" required onclick="showTotal()">Monthly
                        </label>
                    </td>
                    <td colspan="1">
                        <label>
                            <input type="radio" name="VehiclePlan" id="YearlyPlan" value="Yearly" required onclick="showTotal()">Yearly    
                        </label>
                    </td>
                </tr><br>
                <tr>
                    <td align="center">
                        <label id="DailyCost"></label>
                    </td>
                    <td align="center">
                        <label id="MonthlyCost"></label>
                    </td>
                    <td align="center">
                        <label id="YearlyCost"></label>
                    </td>
                </tr><br>
                <tr>
                    <td colspan="3">
                        <label><b>Total Cost: </b></label>
                        <input  path = "price" type="text" name="TotalCost" id="TotalCost" readonly >
                    </td>
                </tr><br>
                <tr>
                    <td colspan="3" align="center">
                        <input type="submit" value="Register">
                    </td>
                </tr>
            </table>
        </form:form>
    </div>
    <% session.removeAttribute("Type");
    	} %>
</body>
</html>