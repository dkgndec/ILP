package Add_DAL;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;

import Add_bean.DepartmentBean;


public class Department_DAO {

	public static int insertUser(DepartmentBean bean)
	{
		int count = 0;
		ResultSet rs = null;
		Connection DatabaseConnection = null;
		PreparedStatement ps = null;
				
		DatabaseConnection = DbConnection.getDatabaseConnection();
		try
		{
		String query = "INSERT INTO HMS_DEPARTMENT_1 VALUES(?,?,?,?,?,?,?)";
		ps = DatabaseConnection.prepareStatement(query);
		ps.setInt(1, bean.departmentID);
		ps.setString(2,bean.departmentName);
		ps.setInt(3, bean.mobileNumber);
		ps.setInt(4, bean.landLineNumber);
		ps.setInt(5, bean.noOfFloorAssistants);
		ps.setInt(6, bean.noOfNurse);
		ps.setString(7, bean.facilityDescription);
		count = ps.executeUpdate();
		System.out.println("No of rows updated:" + count);

	} catch (SQLException e) {
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
		    } 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//database insertion completed

		
	return count;
	}
	

	public static int deleteUser(DepartmentBean bean)
	{
		int count = 0;
		ResultSet rs = null;
		Connection DatabaseConnection = null;
		PreparedStatement ps = null;
				
		DatabaseConnection = DbConnection.getDatabaseConnection();
		try
		{
		String query = "DELETE FROM HMS_DEPARTMENT_1 WHERE departmentName=?";
		ps = DatabaseConnection.prepareStatement(query);
		String departmentName=bean.departmentName;
		ps.setString(1,bean.departmentName);
		count = ps.executeUpdate();
		System.out.println("No of rows delete :" + count);

	} catch (SQLException e) {
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
		    } 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//database insertion completed

		
	return count;
	}
	
	
	public static int updateUser(DepartmentBean bean)
	{
		int count = 0;
		ResultSet rs = null;
		Connection DatabaseConnection = null;
		PreparedStatement ps = null;
		DatabaseConnection = DbConnection.getDatabaseConnection();
		System.out.println("out");
		try
		{
		System.out.println("in");
		String query = "UPDATE HMS_DEPARTMENT_1 SET MOBILENUMBER =?,LANDLINENUMBER =?,NOOFFLOORASSISTANTS =?,NOOFNURSE =?,FACILITYDESCRIPTION =? WHERE departmentID=?";
		ps = DatabaseConnection.prepareStatement(query);
		ps.setInt(1, bean.mobileNumber);
		ps.setInt(2, bean.landLineNumber);
		ps.setInt(3, bean.noOfFloorAssistants);
		ps.setInt(4, bean.noOfNurse);
		ps.setString(5, bean.facilityDescription);
		ps.setInt(6,bean.departmentID);
		count = ps.executeUpdate();
		System.out.println("No of rows updated:" + count);
		

	} catch (SQLException e) {
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
		    } 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//database insertion completed

		
	return count;
	}
	
	public static ArrayList<DepartmentBean>searchUser(int id)
	{

		Connection DatabaseConnection = null;
		Statement st = null;
		PreparedStatement ps = null;
		Scanner sc = new Scanner(System.in);
		ResultSet rs = null;
		ArrayList<DepartmentBean> user = new ArrayList<DepartmentBean>();
		
		try {
			//creating connection object
			DatabaseConnection = DbConnection.getDatabaseConnection();

			ps = DatabaseConnection.
			prepareStatement("SELECT *  FROM  HMS_DEPARTMENT_1 where departmentID=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			System.out.println(id);
			while(rs.next())
			{
				DepartmentBean users = new DepartmentBean();
				users.departmentID = rs.getInt(1);
				users.departmentName = rs.getString(2);
				users.mobileNumber=rs.getInt(3);
				users.landLineNumber=rs.getInt(4);
				users.noOfFloorAssistants=rs.getInt(5);
				users.noOfNurse=rs.getInt(6);
				users.facilityDescription= rs.getString(7);
				user.add(users);
			}
			
		} catch (SQLException e) {
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
				DbConnection.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return user;
	}
	
/*	
	public static DE searchUpdateUser(DepartmentBean bean)
	{
		int count = 0;
		ResultSet rs = null;
		Connection DatabaseConnection = null;
		PreparedStatement ps = null;
		DatabaseConnection = DbConnection.getDatabaseConnection();
		System.out.println("out");
		try
		{
		System.out.println("in");
		String query = "Select * from HMS_DEPARTMENT WHERE departmentID=?";
		ps = DatabaseConnection.prepareStatement(query);
		ps.setInt(1, bean.departmentID);
		count = ps.executeUpdate();
		System.out.println("No of rows updated:" + count);

	} catch (SQLException e) {
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
		    } 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//database insertion completed

		
	return count;
	}
	*/
}


/*


int id= Integer.parseInt(request.getParameter("product_id"));
UserDAO dao = new UserDAO();
ArrayList<UserBean> users= dao.searchUsers(id);
request.setAttribute("users", users);
RequestDispatcher rd = request.getRequestDispatcher("four.jsp");
rd.forward(request, response);

*/