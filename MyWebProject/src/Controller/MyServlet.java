package Controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;



/**
 * Servlet implementation class MyServlet
 */
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
       super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.sendRedirect("index.html");
		response.getWriter().println("link clicked");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String opt = request.getParameter("option");
		
		
		System.out.println(opt);
		
		if(opt.equals("1"))
		{
		String firstName = request.getParameter("firstname");
		String lastName  = request.getParameter("lastname");
		String address  = request.getParameter("address");
		char gender = request.getParameter("gender").equals("male")?'M':'F'; 
		long contact = Long.parseLong(request.getParameter("contactno"));
		System.out.println(request.getParameter("married"));
		boolean married = request.getParameter("married") == null ? false:true;
		String state = request.getParameter("states");
		String date = request.getParameter("dob");
		String dept = request.getParameter("departments");
		
		
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
   	    
		Date dob = null;
		
		try {
			dob = df.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (address.length() < 20) {
			response.getWriter().println("Address value can't be less than 20 characters");
			
		}
		
		String DBURL = "jdbc:oracle:thin:@172.26.132.40:1521:ORCL";
		String DBUSERNAME = "a76core";
		String DBPASSWORD = "a76core";
		
		String msg = "<html><body><table border = 1>";
		
		msg+= "<tr><td>"+"FIRST NAME"+"</td><td>"+firstName+"</td></tr>";
		msg+= "<tr><td>"+"LAST NAME"+"</td><td>"+lastName+"</td></tr>";

		msg+= "<tr><td>"+"DEPARTMENT"+"</td><td>"+dept+"</td></tr>";
		msg+= "<tr><td>"+"ADDRESS"+"</td><td>"+address+"</td></tr>";
		msg+= "<tr><td>"+"CONTACT"+"</td><td>"+contact+"</td></tr>";
		msg+= "<tr><td>"+"GENDER"+"</td><td>"+gender+"</td></tr>";
		msg+= "<tr><td>"+"MARRIED"+"</td><td>"+married+"</td></tr>";
		msg+= "<tr><td>"+"DOB"+"</td><td>"+dob+"</td></tr>";
		msg+= "<tr><td>"+"STATE"+"</td><td>"+state+"</td></tr>";
				
		msg += "</table></body></html>";
		
		response.getWriter().println(msg);
		}
		
	}

}







