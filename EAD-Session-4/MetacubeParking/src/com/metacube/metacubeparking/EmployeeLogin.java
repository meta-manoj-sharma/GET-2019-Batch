package com.metacube.metacubeparking;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
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
 * Servlet implementation class EmployeeLogin.
 */
@WebServlet("/EmployeeLogin")
public class EmployeeLogin extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new employee login.
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeLogin() {
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
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		PrintWriter show = response.getWriter();
		try {
			HttpSession session = request.getSession();
			PreparedStatement statement = (PreparedStatement) ConnectionClass.connect
					.prepareStatement("SELECT Email,password FROM employeeData WHERE Email='" + email + "';");
			ResultSet resultSet;

			resultSet = statement.executeQuery();

			if (resultSet.next() == false) {
				show.println("Employee doesn't exist");
				RequestDispatcher rd = request.getRequestDispatcher("/LoginPage.html");
				rd.include(request, response);

			} else {
				resultSet.beforeFirst();
				while (resultSet.next()) {
					if (!password.equals(resultSet.getString(2))) {
						show.println("Password not match");
						// request dispatcher to send request and response to new page
						RequestDispatcher rd = request.getRequestDispatcher("/LoginPage.html");
						rd.include(request, response);

					} else {

						session.setAttribute("Email", email);
						RequestDispatcher dispatcherObject = request.getRequestDispatcher("/HomePage.jsp");
						dispatcherObject.include(request, response);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
