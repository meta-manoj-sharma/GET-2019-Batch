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
 * Servlet implementation class UpdateStudentDetails
 */
@WebServlet("/UpdateStudentDetails")
public class UpdateStudentDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateStudentDetails() {
		super();
		ConnectionClass.connectionQuery();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * method to get data of a particular student by its mail id and show it on html page 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String studentEmailId = request.getParameter("id");
		PrintWriter show = response.getWriter();
		try {
			PreparedStatement statement = (PreparedStatement) ConnectionClass.connect.prepareStatement(" select firstName, lastname, fathersName, email, age, class "
							+ " from student where Email='" + studentEmailId + "';");
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				show.print("<html><head><title>Students</title></head><body> ");
				show.print("<form action='' method='Post'> ");
				show.print("<label><b>first Name</b></label> ");
				show.print("<input type='text' name='studentFirstName' value='" + resultSet.getString(1) + "' Required><br><br> ");
				show.print("<label><b>last Name</b></label> ");
				show.print("<input type='text' name='studentLastName' value='" + resultSet.getString(2) + "' Required><br><br> ");
				show.print("<label><b>father's Name</b></label> ");
				show.print("<input type='text' name='fathersName'value='" + resultSet.getString(3) + "' Required><br><br> ");
				show.print("<label><b>email id</b></label> ");
				show.print("<input type='email' name='email' value='" + resultSet.getString(4) + "' Readonly><br><br> ");
				show.print("<label><b>Age</b></label> ");
				show.print("<input type='number' name='age'value='" + resultSet.getString(5) + "' Required><br><br> ");
				show.print("<label><b>Class</b></label> ");
				show.print("<input type='text' name='class'value='" + resultSet.getString(6) + "' Required><br><br> ");
				show.print("<input type='submit' value='Update'><br><br> ");
				show.print("</form>	</body></html> ");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * method to insert updated data into database table
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter show = response.getWriter();
		String firstName = request.getParameter("studentFirstName");
		String lastName = request.getParameter("studentLastName");
		String fathersName = request.getParameter("fathersName");
		String email = request.getParameter("email");
		int age = Integer.valueOf(request.getParameter("age"));
		String classOfStudent = request.getParameter("class");

		try {
			PreparedStatement statement = (PreparedStatement) ConnectionClass.connect.prepareStatement("update student set student.firstName= '"
							+ firstName + "',student.lastName= '" + lastName + "',student.fathersName= '" + fathersName
							+ "',student.age= '" + age + "',student.class= '" + classOfStudent + "'" + " where student.Email = '" + email + "';");
			statement.executeUpdate();
			show.print("<html><head><title>Students</title></head><body>");
			show.print("<h2>Data Updated Successfully....</h2><br><br>");
			show.print("<a href='homePage.html'>Home Page </a><br>");
			show.print("</table></body></html>");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
