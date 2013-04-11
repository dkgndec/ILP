package add;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAL.DbConnection;
import DAL.InsertDoc;
import bean.DOC;

/**
 * Servlet implementation class displayall
 */
public class displayall extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public displayall() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	
		
				
			InsertDoc dao = new InsertDoc(); 
			DOC v=new DOC();
		


		
		Connection DatabaseConnection = null;
		Statement st = null;
		PreparedStatement ps = null;
		Scanner sc = new Scanner(System.in);
		ResultSet rs = null;
		ArrayList<DOC> users = new ArrayList<DOC>();

		
		try{
	
		
			DatabaseConnection = DbConnection.getDatabaseConnection();
			ps = DatabaseConnection.prepareStatement("SELECT * FROM STAFF_ABC_1");
		
			rs = ps.executeQuery();
			

			response.getWriter().println("<html><body><table border=\"1\">"+
					"<tr><td>Doctor :ID</td><td>First Name</td><td>Last Name</td><td>Gender</td><td>Fee</td><td>Dob</td><td>Qualification</td><td>Specialization</td><td>Visiting Days</td><td>Email</td><td>Visiting Time</td><td>contact</td></tr>");
			while(rs.next())
			{
				String msg = "<tr>";
				msg += "<td> " + rs.getString(1) +"</td>";
				msg += " <td>  " + rs.getString(2) +"</td>";
				msg += " <td> " + rs.getString(3) +"</td>";
				msg += "<td> " + rs.getString(4) +"</td>";
				msg += " <td>  " + rs.getString(5) +"</td>";
				msg += " <td> " + rs.getString(6) +"</td>";
				msg += "<td> " + rs.getString(7) +"</td>";
				msg += "<td> " + rs.getString(8) +"</td>";
				msg += "<td> " + rs.getString(9) +"</td>";
				msg += "<td> " + rs.getString(10) +"</td>";
				msg += "<td> " + rs.getString(11) +"</td>";
				msg += "<td> " + rs.getString(12) +"</td>";
				msg += "</tr>"; 
				response.getWriter().println(msg);
				response.getWriter().println("</br>");
			}
			response.getWriter().println("</body></html>");
			
		
	}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
finally
{
try {
if(ps != null)
{
	ps.close();
}
DbConnection.closeConnection();	
} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
	}
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
