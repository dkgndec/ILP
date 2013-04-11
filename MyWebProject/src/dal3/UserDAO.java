package dal3;
import java.sql.*;
import java.util.*;

import bean3.*;


public class UserDAO {

	public int insertUser(UserBean bean)
	{
		int count = 0;
		Connection DatabaseConnection = null;
		PreparedStatement ps = null;
		
		DatabaseConnection = DbConnection.getDatabaseConnection();
		try
		{
		String query = "INSERT INTO GOODSRECIEVING " +
		" (receipt,driver_name,truck_no,quantity,product_category,vendor_id)" +
		" VALUES (seq_GoodsRecieving.NEXTVAL,?,?,?,?,?)";
		
		
		

		//java.sql.Date sqlDob = new java.sql.Date(bean.dob.getTime());

		ps = DatabaseConnection.prepareStatement(query);
		ps.setString(1, bean.driverName);
		ps.setString(2,bean.truckNo+"");
		ps.setString(3,bean.quantity+"");
		ps.setString(4, bean.productCategory);
		ps.setString(5, bean.vendorId+"");
		
		
	//	ps.setDate(6, sqlDob);

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
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//database insertion completed

		
		
		return count;
	}
	
	public ArrayList<UserBean> getUsers(String name)
	{

		Connection DatabaseConnection = null;
		Statement st = null;
		PreparedStatement ps = null;
		Scanner sc = new Scanner(System.in);
		ResultSet rs = null;
		ArrayList<UserBean> users = new ArrayList<UserBean>();
		
		try {
			//creating connection object
			DatabaseConnection = DbConnection.getDatabaseConnection();

			ps = DatabaseConnection.
			prepareStatement("SELECT receipt,driver_name,truck_no FROM GoodsRecieving where driver_name=?");
			ps.setString(1,name);
			rs = ps.executeQuery();
				
			
			while(rs.next())
			{
				UserBean user = new UserBean();
				user.receipt = rs.getString(1);
				user.driverName = rs.getString(2);
				user.truckNo = rs.getString(3);
				users.add(user);
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
		
		return users;
	}
	
	
	
}
