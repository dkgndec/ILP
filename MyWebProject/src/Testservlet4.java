

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAL.DbConnection;
import DAL.UserDAO;
import bean.UserBean;

/**
 * Servlet implementation class Testservlet4
 */
public class Testservlet4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Testservlet4() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	/*	System.out.println("hello");
		String id=(String)request.getParameter("booking");
		ArrayList<UserBean> getDetails=new ArrayList<UserBean>();
		UserDAO dao=new UserDAO();
		getDetails=dao.getData(id);
		System.out.println(id);
		//response.sendRedirect("fwdupdate.jsp");
		RequestDispatcher rd=request.getRequestDispatcher("fwdupdate.jsp");
		request.setAttribute("objfwdupdate",getDetails);
		request.setAttribute("booking",id);
		rd.forward(request,response);
		System.out.println("hell");
			}
*/
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("hello");
		int id=Integer.parseInt(request.getParameter("booking"));
		ArrayList<UserBean> getDetails=new ArrayList<UserBean>();
		UserDAO dao=new UserDAO();
		getDetails=dao.getData(id);
		System.out.println(getDetails.size());
		request.setAttribute("detail",getDetails);
		request.setAttribute("booking",id);
		//response.sendRedirect("fwdupdate.jsp");
		RequestDispatcher rd=request.getRequestDispatcher("fwdupdate.jsp");
		rd.forward(request,response);
		
	/*
		
		Connection DatabaseConnection = null;
		Statement st = null;
		PreparedStatement ps = null;
		Scanner sc = new Scanner(System.in);
		ResultSet rs = null;
		int rs1=0;
		int dav=0;
		//long urn = bean.roomid;
	try{	
		DatabaseConnection = DbConnection.getDatabaseConnection();
		int productid1 = Integer.parseInt(request.getParameter("booking"));
		ps = DatabaseConnection.
		prepareStatement("SELECT * FROM HMS_ROOM_DAVINDER where URN=?");
		ps.setInt(1, productid1);
		rs = ps.executeQuery();
		
		
		response.getWriter().println("<html><body><table border=\"1\">"+
				"<tr><td>URN</td><td>roomid</td><td>roomtype</td><td>RoomCost</td><td>no of beds</td><td>dept ID</td></tr>");
		while(rs.next())
		{
			String msg = "<tr>";
			msg += "<td> " + rs.getInt(1) +"</td>";
			msg += " <td>  " + rs.getInt(2) +"</td>";
			msg += " <td> " + rs.getString(3) +"</td>";
			msg += "<td> " + rs.getInt(4) +"</td>";
			msg += " <td>  " + rs.getInt(5) +"</td>";
			msg += " <td> " + rs.getInt(6) +"</td>";
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
			if(rs!= null)
			{
				rs.close();
			}
			if(st != null)
			{
				st.close();
			}
			if(DatabaseConnection != null)
			{
				DatabaseConnection.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}*/

	}}
