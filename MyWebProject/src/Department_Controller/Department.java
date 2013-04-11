package Department_Controller;


import java.io.IOException;
import java.text.ParseException;


import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import Add_DAL.*;
import Add_bean.*;


public class Department extends HttpServlet {
       
    public Department() {
       super();
    }

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		}
		

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
	try{
	    String opt = request.getParameter("option");
	
	    if(opt.equals("1"))
	    {
	    int departmentID = Integer.parseInt(request.getParameter("deptid"));
		String departmentName=request.getParameter("deptname");
		int mobileNumber = Integer.parseInt(request.getParameter("mn"));
		int landLineNumber = Integer.parseInt(request.getParameter("ln"));
		int noOfFloorAssistants = Integer.parseInt(request.getParameter("nfa"));
		int noOfNurse = Integer.parseInt(request.getParameter("non"));
		String facilityDescription=request.getParameter("description");		
	
   	    Department_DAO dao = new Department_DAO();
		DepartmentBean bean = new DepartmentBean();
		
		
		bean.departmentID=departmentID;
		bean.departmentName=departmentName;
		bean.mobileNumber=mobileNumber;
		bean.landLineNumber=landLineNumber;
		bean.noOfFloorAssistants=noOfFloorAssistants;
		bean.noOfNurse=noOfNurse;
		bean.facilityDescription=facilityDescription;
		int count = Department_DAO.insertUser(bean);
	    }
	
	    
	    
	    if(opt.equals("2"))
	    {
	    	String departmentName=request.getParameter("deptname");
	    	Department_DAO dao = new Department_DAO();
	 		DepartmentBean bean = new DepartmentBean();
	 		bean.departmentName=departmentName;
	 		int count = Department_DAO.deleteUser(bean);
	    }
	    		
		
	


	    if(opt.equals("3"))
	    {
	    	
	    	ArrayList<DepartmentBean> users=new ArrayList();
	    	int departmentID = Integer.parseInt(request.getParameter("deptid"));
	    	Department_DAO dao = new Department_DAO();
			users = Department_DAO.searchUser(departmentID);
			request.setAttribute("users", users);
	    	RequestDispatcher rd = request.getRequestDispatcher("Update.jsp");
	    	rd.forward(request, response);
			}

	    if(opt.equals("4"))
	    {
	    	ArrayList<DepartmentBean> users=new ArrayList();
	    	int id= Integer.parseInt(request.getParameter("deptid"));
	    	Department_DAO dao = new Department_DAO();
	    	users= dao.searchUser(id);
	    	request.setAttribute("users", users);
	    	RequestDispatcher rd = request.getRequestDispatcher("Search.jsp");
	    	rd.forward(request, response);
	    
	    		System.out.println(id);
	    }
    
	    if(opt.equals("5"))
	    { 
	    	int id= Integer.parseInt(request.getParameter("deptid"));
	    	String departmentName=request.getParameter("deptname");
	 		int mobileNumber = Integer.parseInt(request.getParameter("mn"));
	 		int landLineNumber = Integer.parseInt(request.getParameter("ln"));
	 		int noOfFloorAssistants = Integer.parseInt(request.getParameter("nfa"));
	 		int noOfNurse = Integer.parseInt(request.getParameter("non"));
	 		String facilityDescription=request.getParameter("description");;
	 		Department_DAO dao = new Department_DAO();
	 		DepartmentBean bean = new DepartmentBean();
	 		bean.departmentID=id;
	 		bean.departmentName=departmentName;
	 		bean.mobileNumber=mobileNumber;
	 		bean.landLineNumber=landLineNumber;
	 		bean.noOfFloorAssistants=noOfFloorAssistants;
	 		bean.noOfNurse=noOfNurse;
	 		bean.facilityDescription=facilityDescription;
	 		int count = Department_DAO.updateUser(bean);
	    }
	}
catch(Exception e)
{
	
}

}
	
}





/*

        String departmentName=request.getParameter("deptname");
		int mobileNumber = Integer.parseInt(request.getParameter("mn"));
		int landLineNumber = Integer.parseInt(request.getParameter("ln"));
		int noOfFloorAssistants = Integer.parseInt(request.getParameter("nfa"));
		int noOfNurse = Integer.parseInt(request.getParameter("non"));
		String facilityDescription=request.getParameter("description");;
		Department_DAO dao = new Department_DAO();
		DepartmentBean bean = new DepartmentBean();
		bean.departmentName=departmentName;
		bean.mobileNumber=mobileNumber;
		bean.landLineNumber=landLineNumber;
		bean.noOfFloorAssistants=noOfFloorAssistants;
		bean.noOfNurse=noOfNurse;
		bean.facilityDescription=facilityDescription;
		int count = Department_DAO.updateUser(bean);





ArrayList<DepartmentBean> user = new ArrayList<DepartmentBean>();	
	    int departmentID = Integer.parseInt(request.getParameter("deptid"));
		Department_DAO dao = new Department_DAO();
		DepartmentBean bean = new DepartmentBean();
		bean.departmentID=departmentID;
	    user = Department_DAO.searchUser(bean);
*/