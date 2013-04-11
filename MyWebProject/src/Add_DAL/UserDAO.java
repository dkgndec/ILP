package Add_DAL;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import Add_bean.UserBean;
import bean.*;


public class UserDAO {

	public int insertUser(UserBean bean)
	{
		int count = 0;
		ResultSet rs = null;
		Connection DatabaseConnection = null;
		PreparedStatement ps = null;
		Date dateOfEntry =new Date();
		
		DatabaseConnection = DbConnection.getDatabaseConnection();
		try
		{
		String query = "INSERT INTO addproduct VALUES(seq_product_id.NEXTVAL,?,?,?,?,?,?,?,?)";
		java.sql.Date sqlDoe = new java.sql.Date(dateOfEntry.getTime());
		
		ps = DatabaseConnection.prepareStatement(query);
		ps.setString(1, bean.productName);
		ps.setDouble(2,bean.costPrice);
		ps.setDouble(3, bean.sellingPrice);
		ps.setString(4, bean.description);
		ps.setString(5, bean.company);
		ps.setString(6, bean.productType);
		ps.setString(7, bean.promotionalCode);
		ps.setDate(8, sqlDoe);       
		count = ps.executeUpdate();
		System.out.println("No of rows updated:" + count);

	} catch (SQLException e) {
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
		    } 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//database insertion completed

		
	return count;
	}
	
	
	//to project the data 0k report
	
	public ArrayList<UserBean>getUsers()
	{

		Connection DatabaseConnection = null;
		Statement st = null;
		PreparedStatement ps = null;
		Scanner sc = new Scanner(System.in);
		ResultSet rs = null;
		ArrayList<UserBean> user = new ArrayList<UserBean>();
		
		try {
			//creating connection object
			DatabaseConnection = DbConnection.getDatabaseConnection();

			ps = DatabaseConnection.
			prepareStatement("SELECT * FROM addproduct");
			rs = ps.executeQuery();
		
			while(rs.next())
			{
				UserBean users = new UserBean();
				users.productName = rs.getString(2);
				users.costPrice = rs.getDouble(3);
				users.sellingPrice = rs.getDouble(4);
				users.description=rs.getString(5);
				users.company=rs.getString(6);
				users.productType=rs.getString(7);
				users.promotionalCode=rs.getString(8);
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
	
	
	public int pid()
	{

		Connection DatabaseConnection = null;
		Statement st = null;
		PreparedStatement ps = null;
		Scanner sc = new Scanner(System.in);
		ResultSet rs = null;
		int rs1=0;
		
		
		try {
			//creating connection object
			DatabaseConnection = DbConnection.getDatabaseConnection();
			
			ps = DatabaseConnection.
			prepareStatement("SELECT max(product_id) from addproduct "); 
			rs = ps.executeQuery();
				
			
			while(rs.next())
			{
				 rs1= rs.getInt(1);
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
		System.out.println(rs1);
		return rs1;
	}
	
	
	

	public ArrayList<UserBean> searchUsers(int id)
	{
    	Connection DatabaseConnection = null;
		Statement st = null;
		PreparedStatement ps = null;
		Scanner sc = new Scanner(System.in);
		ResultSet rs = null;
		ArrayList<UserBean> list = new ArrayList<UserBean>();
		
		try {
			//creating connection object
			DatabaseConnection = DbConnection.getDatabaseConnection();

			ps = DatabaseConnection.
			prepareStatement("SELECT * FROM addproduct where product_id=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
				
			
			while(rs.next())
			{
				UserBean bean1 = new UserBean();
				bean1.productID=rs.getInt(1);
				bean1.productName = rs.getString(2);
				bean1.costPrice = rs.getDouble(3);
				bean1.sellingPrice = rs.getDouble(4);
				bean1.description=rs.getString(5);
				bean1.company=rs.getString(6);
				bean1.productType=rs.getString(7);
				bean1.promotionalCode=rs.getString(8);
				list.add(bean1);
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
		
		return list;
	}
	
	
}
