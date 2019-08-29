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
 * Servlet implementation class ShowStudents
 */
@WebServlet("/ShowStudents")
public class ShowStudents extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowStudents() 
	{
		super();
		ConnectionClass.connectionQuery();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * method to show data table of students from database
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter show = response.getWriter();
		PreparedStatement statement;
		try 
		{
			// query to get students information from database
			statement = (PreparedStatement) ConnectionClass.connect.prepareStatement("select firstname, lastname, fathersname, email, age, class from student ;");
			ResultSet resultSet = statement.executeQuery();
			show.print("<html><head><title>Students</title></head><body>");
			show.print("<table border = '1'>");
			show.print("<tr><th>FirstName</th><th>LastName</th><th>Father'sName</th><th>Email</th><th>Class</th><th>Age</th></tr" + ">");
			while (resultSet.next()) 
			{
				show.print("<tr><form action = './UpdateStudentDetails'><td>" + resultSet.getString(1) + "</td><td>"
						+ resultSet.getString(2) + "</td><td>" + resultSet.getString(3) + "</td><td >"
						+ resultSet.getString(4) + "</td><td>" + resultSet.getString(5) + "</td><td>"
						+ resultSet.getString(6) + "</td><td>"+ "<a href = 'update?id=" + resultSet.getString(4)
						+ "'>Update</a>");
			}
			show.print("</table>" + "<br><br><a href='homePage.html'>Home Page </a><br>" + "</body></html>");
			show.close();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
