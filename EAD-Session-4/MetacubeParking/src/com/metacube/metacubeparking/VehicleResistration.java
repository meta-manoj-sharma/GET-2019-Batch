package com.metacube.metacubeparking;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class VehicleResistration.
 */
@WebServlet("/VehicleResistration")
public class VehicleResistration extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new vehicle resistration.
	 * @see HttpServlet#HttpServlet()
	 */
	public VehicleResistration() {
		super();
		ConnectionClass.connectionQuery();
	}

	/**
	 * Do get.
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter show = response.getWriter();
		String name = request.getParameter("name");
		String type = request.getParameter("vehicle");
		int number = Integer.parseInt(request.getParameter("number"));
		int empId = Integer.parseInt(request.getParameter("empId"));
		String identification = request.getParameter("identification");
		String error = "";
		VehicleValidation validate = new VehicleValidation();
		error = validate.validate(name, type, number, empId);
		if (error == "") {
			try {
				HttpSession session = request.getSession();
				ConnectionClass.connect.setAutoCommit(false);
				PreparedStatement statement1 = (PreparedStatement) ConnectionClass.connect.prepareStatement(" set foreign_key_checks=0; ");
				statement1.executeQuery();
				PreparedStatement statement = (PreparedStatement) ConnectionClass.connect.prepareStatement(" INSERT INTO vehicle (Name, Type, Number, employeeId, identification) VALUES(?,?,?,?,?);");
				statement.setString(1, name);
				statement.setString(2, type);
				statement.setInt(3, number);
				statement.setInt(4, empId);
				statement.setString(5, identification);
				statement.executeUpdate();
				// commit the data into database
				ConnectionClass.connect.commit();
				show.print("<h2>Data Inserted Successfully...</h2>");
				session.setAttribute("Number", number);
				session.setAttribute("Type", type);
				RequestDispatcher rd = request.getRequestDispatcher("/GetPass.jsp");
				rd.include(request, response);
			} catch (Exception e) {
				System.out.println(e);
				try {
					// rollback the changes when process failed
					ConnectionClass.connect.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			show.print("</table></body></html>");
		} else {
			RequestDispatcher rd = null;
			show.println("<div align='center'><p><b><font color=red>" + error + "</font></b></p><br></div>");
			rd = request.getRequestDispatcher("/Vehicle.html");
			rd.include(request, response);
		}
	}
}
