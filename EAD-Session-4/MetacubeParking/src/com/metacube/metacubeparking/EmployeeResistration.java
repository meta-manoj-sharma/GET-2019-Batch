package com.metacube.metacubeparking;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class EmployeeResistration.
 */
@WebServlet("/EmployeeResistration")
public class EmployeeResistration extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new employee resistration.
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeResistration() {
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
		String gender = request.getParameter("gender");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirm");
		String email = request.getParameter("email");
		String contact = request.getParameter("contact");
		String orgnization = request.getParameter("Organization");
		String error = "";
		RegistrationValidation validate = new RegistrationValidation();
		error = validate.validate(name, password, confirmPassword, email,contact);
		if (error == "") {
			try {
				// To insert data into database and process it
				PreparedStatement statement = (PreparedStatement) ConnectionClass.connect.prepareStatement("INSERT INTO employeeData(Name, gender, password, Email, contactNumber, organization) VALUES(?,?,?,?,?,?);");
				ConnectionClass.connect.setAutoCommit(false);
				statement.setString(1, name);
				statement.setString(2, gender);
				statement.setString(3, password);
				statement.setString(4, email);
				statement.setString(5, contact);
				statement.setString(6, orgnization);
				statement.executeUpdate();
				// commit the data into database
				ConnectionClass.connect.commit();
				statement = (PreparedStatement) ConnectionClass.connect.prepareStatement("SELECT employeeId FROM employeeData WHERE Email='" + email + "';");
				ResultSet resultSet = statement.executeQuery();
				show.print("<html><head><title>Confirmation Page</title></head><body>");
				show.print("<h4>Data Inserted Successfully....Employee Id : ");
				while (resultSet.next()) {
					show.print(resultSet.getString(1));
				}
				show.print("</h4><br><br>");
				HttpSession session = request.getSession();
				session.setAttribute("Email", email);
				RequestDispatcher dispatcherObject = request.getRequestDispatcher("/Vehicle.html");
				dispatcherObject.include(request, response);
				show.print("</table></body></html>");
			} catch (SQLIntegrityConstraintViolationException e) {
				error = "Email Address Already Exists";
				try {
					// rollback the changes when process failed
					ConnectionClass.connect.rollback();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (error.equals("Email Address Already Exists")) {
					RequestDispatcher dispatcherObject = null;
					show.println("<div align='center'><p><b><font color=red>" + error + "</font></b></p><br></div>");
					dispatcherObject = request.getRequestDispatcher("/Registration.html");
					dispatcherObject.include(request, response);
				}
			}
		} else {
			RequestDispatcher dispatcherObject = null;
			show.println("<div align='center'><p><b><font color=red>" + error + "</font></b></p><br></div>");
			dispatcherObject = request.getRequestDispatcher("/Resistration.html");
			dispatcherObject.include(request, response);
		}
	}
	/**
	 * Do post.
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter show = response.getWriter();
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String contact = request.getParameter("contact");
		String orgnization = request.getParameter("Organization");
		String confirmPassword = request.getParameter("confirm");
		String error = "";
		RegistrationValidation validate = new RegistrationValidation();
		error = validate.validate(name, password, confirmPassword, email, contact);
		if (error == "") {
			try {
				PreparedStatement statement = (PreparedStatement) ConnectionClass.connect
						.prepareStatement("UPDATE employeeData SET employeeData.Name = '"
								+ name + "', employeeData.gender = '"
								+ gender + "', employeeData.password = '"
								+ password + "', employeeData.contactNumber = '"
								+ contact + "', employeeData.organization = '"
								+ orgnization + "' WHERE employeeData.Email = '"
								+ email + "';");
				ConnectionClass.connect.setAutoCommit(false);
				statement.executeUpdate();
				show.print("<html><head><title>Confirmation Page</title></head><body>");
				show.print("<h4>Data updated Successfully... ");
				show.print("</h4><br><br>");
				HttpSession session = request.getSession();
				session.setAttribute("Email", email);
				RequestDispatcher dispatcherObject = request.getRequestDispatcher("/LoginPage.html");
				dispatcherObject.include(request, response);
				ConnectionClass.connect.commit();
			} catch (SQLIntegrityConstraintViolationException e) {
				error = "Email Address Already Exists";
				
				try {
					// rollback the changes when process failed
					ConnectionClass.connect.rollback();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (error.equals("Email Address Already Exists")) {
					RequestDispatcher dispatcherObject = null;
					show.println("<div align='center'><p><b><font color=red>" + error + "</font></b></p><br></div>");
					dispatcherObject = request.getRequestDispatcher("//Update.jsp");
					dispatcherObject.include(request, response);
				}
			}
		} else {
			RequestDispatcher dispatcherObject = null;
			show.println("<div align='center'><p><b><font color=red>" + error + "</font></b></p><br></div>");
			dispatcherObject = request.getRequestDispatcher("/Update.jsp");
			dispatcherObject.include(request, response);
		}
	}
}
