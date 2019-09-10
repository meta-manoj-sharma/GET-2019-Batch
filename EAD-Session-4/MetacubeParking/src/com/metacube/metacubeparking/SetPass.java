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
 * Servlet implementation class SetPass.
 */
@WebServlet("/SetPass")
public class SetPass extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new sets the pass.
	 * @see HttpServlet#HttpServlet()
	 */
	public SetPass() {
		super();
		ConnectionClass.connectionQuery();
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
		
		HttpSession session = request.getSession();
		PrintWriter show = response.getWriter();
		String type = (String) session.getAttribute("Type");
		int number = (Integer) session.getAttribute("Number");
		String price = request.getParameter("Price");
		String typeOfPlan = (String) session.getAttribute("passType");
		try {
			// To insert data into database and process it
			PreparedStatement statement = (PreparedStatement) ConnectionClass.connect.prepareStatement("INSERT INTO SetPass VALUES(?,?,?,?);");
			ConnectionClass.connect.setAutoCommit(false);
			statement.setInt(1, number);
			statement.setString(2, type);
			statement.setString(3, price);
			statement.setString(4, typeOfPlan);
			statement.executeUpdate();
			// commit the data into database
			ConnectionClass.connect.commit();
			show.print("<html><head><title>Confirmation Page</title></head><body>");
			show.print("<h4>Plan Activated Successfully");
			show.print("</h4><br><br>");
			RequestDispatcher rd = request.getRequestDispatcher("LoginPage.html");
			rd.include(request, response);
		} catch (SQLException e) {
			show.print("<h4>" + e.getMessage() + "</h4><br><br>");
			System.out.println(e.getMessage());
			try {
				// rollback the changes when process failed
				ConnectionClass.connect.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		show.print("</table></body></html>");
	}
}
