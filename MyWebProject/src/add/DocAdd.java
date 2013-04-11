package add;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAL.DbConnection;
import DAL.InsertDoc;
import DAL.UserDAO;
import bean.DOC;
import bean.UserBean;

/**
 * Servlet implementation class DocAdd
 */
public class DocAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DocAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String opt = request.getParameter("option");
		System.out.println(opt);
				
			
			int id = Integer.parseInt(request.getParameter("id"));
			InsertDoc dao = new InsertDoc(); 
			DOC v=new DOC();
		v.id=id;


		
		Connection DatabaseConnection = null;
		Statement st = null;
		PreparedStatement ps = null;
		Scanner sc = new Scanner(System.in);
		ResultSet rs = null;
		ArrayList<DOC> users = new ArrayList<DOC>();

		
		try{
	
		
			DatabaseConnection = DbConnection.getDatabaseConnection();
			ps = DatabaseConnection.prepareStatement("SELECT * FROM STAFF_ABC_1 where Dr_ID=?");
			ps.setInt(1, v.id);
			rs = ps.executeQuery();
		
			response.getWriter().println("<html><body><table border=\"1\">"+
					"<tr><td>Doctor :ID</td><td>First Name</td><td>Last Name</td><td>Gender</td><td>Fee</td><td>Dob</td><td>Qualification</td><td>Specialization</td><td>Visiting Days</td><td>Email</td><td>Visiting Time</td><td>contact</td></tr>");
			while(rs.next())
			{
				String msg = "<tr>";
				
				v.firstName=rs.getString(2);
				v.lastName=rs.getString(3);
				v.gender=rs.getString(4).charAt(0);
				v.fee=rs.getInt(5);
				v.dob=rs.getDate(6);
				v.qualification=rs.getString(7);
				v.specialization=rs.getString(8);
				v.visting=rs.getString(9);
				v.email=rs.getString(10);
				v.Visiting_Time=rs.getString(11);
				v.contact=rs.getLong(12);	
				users.add(v);
			}
				request.setAttribute("users",users);
				System.out.println("data in arrayList"+users.size());
				response.getWriter().println("</br>");
				RequestDispatcher rd= request.getRequestDispatcher("search.jsp");
				rd.forward(request,response);
			
		
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
	}}
		
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String opt = request.getParameter("option");
System.out.println(opt);
		
		if(opt.equals("1"))
		{
		String firstName = request.getParameter("fname");
		String lastName  = request.getParameter("lastname");
		String qua = request.getParameter("qname");
		String mail = request.getParameter("email");
		char gender = request.getParameter("gender").equals("M")?'M':'F'; 
		long contact = Long.parseLong(request.getParameter("cnumber"));
		//System.out.println(request.getParameter("married"));
		String special  = request.getParameter("sname");
 String visiting=request.getParameter("visting");
		String date = request.getParameter("mydate");
		String Visiting_Time = request.getParameter("vt");
		int fee=Integer.parseInt(request.getParameter("fee"));
		int departmentid=Integer.parseInt(request.getParameter("depid"));
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
   	    Date bill = null;
		try {
			bill = df.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			InsertDoc dao = new InsertDoc();
			 DOC v=new DOC();
		v.firstName=firstName;
		v.lastName=lastName;
		v.qualification=qua;
		v.email=mail;
		v.gender=gender;
		v.contact=contact;
		v.specialization=special;
		v.fee=fee;
		v.dob=bill;
		v.Visiting_Time=Visiting_Time;
		v.visting=visiting;
		v.departmentid=departmentid;
			
		
			int count = dao.insertUser(v);
			response.sendRedirect("succes.html");
			
	
	}
	
		
}
}
