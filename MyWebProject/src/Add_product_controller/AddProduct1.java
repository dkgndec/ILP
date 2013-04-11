package Add_product_controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import Add_DAL.*;
import Add_bean.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
 




public class AddProduct1 extends HttpServlet {
       
    public AddProduct1() {
       super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		UserDAO dao = new UserDAO();
		ArrayList<UserBean> users= dao.getUsers();
		request.setAttribute("users", users);
		RequestDispatcher rd = request.getRequestDispatcher("three.jsp");
		rd.forward(request, response);
		
	}
		
		
	
		




	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String productName = request.getParameter("productname");
	    double costPrice= Double.parseDouble(request.getParameter("cp"));
	    double sellingPrice= Double.parseDouble(request.getParameter("sp"));
		String description  = request.getParameter("description");
		String company = request.getParameter("company");
		String productType = request.getParameter("type");
		String promotionalCode = request.getParameter("pcode");
		
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
   	    Date dateOfEntry =new Date();
	
		// jdbc starts
		
   	    UserDAO dao = new UserDAO();
		UserBean bean = new UserBean();
		
		
		bean.productName = productName;
	    bean.costPrice=costPrice;
		bean.sellingPrice=sellingPrice;
		bean.description=description;
		bean.company=company;
		bean.productType=productType;
		bean.promotionalCode=promotionalCode;
		
		int count = dao.insertUser(bean);
		
		
		String msg = "<html><body><table border=2>";
		
		msg+= "<tr><td>"+"PRODUCT NAME"+"</td><td>"+productName+"</td></tr>";
		msg+= "<tr><td>"+"COST PRICE"+"</td><td>"+costPrice+"</td></tr>";
		msg+= "<tr><td>"+"SELLING PRICE"+"</td><td>"+sellingPrice+"</td></tr>";
		msg+= "<tr><td>"+"DESCRIPTION"+"</td><td>"+description+"</td></tr>";
		msg+= "<tr><td>"+"COMPANY"+"</td><td>"+company+"</td></tr>";
		msg+= "<tr><td>"+"PRODUCT TYPE"+"</td><td>"+productType+"</td></tr>";
		msg+= "<tr><td>"+"DATE OF ENTRY"+"</td><td>"+dateOfEntry+"</td></tr>";
						
		msg += "</table></body></html>";
		
		response.getWriter().println(msg);
		
	    ArrayList<UserBean> users= dao.getUsers();
		request.setAttribute("users", users);
		RequestDispatcher rd = request.getRequestDispatcher("Two.jsp");
		rd.forward(request, response);
		
				
		
		}
	}
	







