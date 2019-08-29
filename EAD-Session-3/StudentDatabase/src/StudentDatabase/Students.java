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
 * Servlet implementation class Students
 * @author Manoj Sharma
 * Dated 29 august 2019
 */
@WebServlet("/Students")
public class Students extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Students()
	{
		super();
		ConnectionClass.connectionQuery();
	}
/**
 * method to get data from html page
 * @param request and response from page and to the page
 */
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter show = response.getWriter();
		String firstName = request.getParameter("studentFirstName");
		String lastName = request.getParameter("studentLastName");
		String fathersName = request.getParameter("fathersName");
		String email = request.getParameter("email");
		int age = Integer.valueOf(request.getParameter("age"));
		String classOfStudent = request.getParameter("class");
		try 
		{
			// To insert data into database and process it 
			PreparedStatement statement = (PreparedStatement) ConnectionClass.connect.prepareStatement("INSERT INTO student(firstname, lastname, fathersname, email, age, class) VALUES(?,?,?,?,?,?);");
			ConnectionClass.connect.setAutoCommit(false);
			statement.setString(1, firstName);
			statement.setString(2, lastName);
			statement.setString(3, fathersName);
			statement.setString(4, email);
			statement.setInt(5, age);
			statement.setString(6, classOfStudent);
			statement.executeUpdate();
			// commit the data into database
			ConnectionClass.connect.commit();
			show.print("<html><head><title>Students</title></head><body>");
			show.print("<h2>Data Inserted Successfully....</h2><br><br>");
			show.print("<a href='homePage.html'>Home Page </a><br>");
			show.print("</table></body></html>");
		} catch (SQLException e) 
		{   
			show.print("<html><head><title>Students</title></head><body>");
			show.print("<h3>"+e.getMessage()+"</h3><br><br>");
			show.print("</table></body></html>");
			System.out.println(e.getMessage());
			try 
			{
				// rollback the changes when process failed
				ConnectionClass.connect.rollback();
			} catch (SQLException e1) 
			{
				e1.printStackTrace();
			}
		}
	}
}
