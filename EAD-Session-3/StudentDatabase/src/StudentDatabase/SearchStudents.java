package StudentDatabase;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class SearchStudents
 */
@WebServlet("/SearchStudents")
public class SearchStudents extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchStudents() 
	{
		super();
		// calling connection class to established connection with mySql
		ConnectionClass.connectionQuery();
	}
	/**
	 * method to search student data from student name
	 * @param request and response from page and to the page
	 */
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter show = response.getWriter();
		String firstName = request.getParameter("studentFirstName");
		String lastName = request.getParameter("studentLastName");
		try 
		{
			// calling database using query to get student data
			PreparedStatement statement = (PreparedStatement) ConnectionClass.connect.prepareStatement(" select firstName, lastname, fathersName, email, age, class "
							+ " from student where firstname= '" + firstName + "' and lastname = '"
							+ lastName + "' order by class;");
			ResultSet resultSet = statement.executeQuery();
			// html page to show data table
			show.print("<html><head><title>Students</title></head><body>");
			show.print("<table border = '1'>");
			show.print("<tr><th>FirstName</th><th>LastName</th><th>Father'sName</th><th>Email</th><th>Age</th><th>Class</th></tr" + ">");
			while (resultSet.next()) 
			{
				show.print("<tr><form action = 'UpdateStudentDetails'''><td>" + resultSet.getString(1) + "</td><td>"
						+ resultSet.getString(2) + "</td><td>" + resultSet.getString(3) + "</td><td >"
						+ resultSet.getString(4) + "</td><td>" + resultSet.getString(5) + "</td><td>"
                        + resultSet.getString(6) + "</td><td></form></td></tr>");
			}
			show.print("</table>" + "<br><br><a href='homePage.html'>Home Page </a><br>" + "</body></html>");
			show.close();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
