package Controller3;

import java.io.IOException;
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

import dal3.*;
import bean3.*;

import java.sql.*;


/**
 * Servlet implementation class MyServlet
 */
public class MyServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet3() {
       super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.sendRedirect("index.html");

		
		/*UserDAO dao = new UserDAO();
		
		UserBean bean = new UserBean();
		ArrayList<UserBean> users1 = dao.getAllUsers();
		request.setAttribute("users", users1);
		RequestDispatcher rd1 = request.getRequestDispatcher("Two.jsp");
		rd1.forward(request, response);
*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		//try
		//{
		
		/*
		if(opt.equals("2"))
		{
			int val1 = Integer.parseInt(request.getParameter("one"));
			int val2 = Integer.parseInt(request.getParameter("two"));
			int answer = val1+val2;

			//calling JSP
			request.setAttribute("key2", answer);
			RequestDispatcher rd = request.getRequestDispatcher("One.jsp");
			rd.forward(request, response);

		}
		*/
		
			String driverName=request.getParameter("driverName");
			String productCategory=request.getParameter("productCategory");
			String truckNo=request.getParameter("truckNo");
			int quantity=Integer.parseInt(request.getParameter("quantity"));
			int vendorId=Integer.parseInt(request.getParameter("vendorId"));
		
	
		
		
		//code to insert record in the database
			
			UserDAO dao = new UserDAO();
			
			UserBean bean = new UserBean();
			
			bean.driverName = driverName;
			bean.truckNo = truckNo;
			bean.quantity = quantity;
			bean.productCategory = productCategory;
			bean.vendorId = vendorId;
			
			int count = dao.insertUser(bean);
		
			String msg = "<html><body><table border = 1>";
			
			msg+= "<tr><td>"+"DRIVER NAME"+"</td><td>"+driverName+"</td></tr>";
			msg+= "<tr><td>"+"TRUCK NUMBER"+"</td><td>"+truckNo+"</td></tr>";
			msg+= "<tr><td>"+"QUANTITY"+"</td><td>"+quantity+"</td></tr>";
			msg+= "<tr><td>"+"PRODUCT CATEGORY"+"</td><td>"+productCategory+"</td></tr>";
			msg+= "<tr><td>"+"VENDOR ID"+"</td><td>"+vendorId+"</td></tr>";
	
			//	msg+= "<tr><td>"+"DOB"+"</td><td>"+dob+"</td></tr>";
		

			msg += "</table></body></html>";

			response.getWriter().println(msg);
			
			ArrayList<UserBean> users = dao.getUsers(driverName);
			request.setAttribute("users", users);
			RequestDispatcher rd = request.getRequestDispatcher("Twot.jsp");
			rd.forward(request, response);
		
			
		
			
		}

	}


