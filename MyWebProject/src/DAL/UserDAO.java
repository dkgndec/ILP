package DAL;
import java.sql.*;
import java.util.*;
import bean.*;

public class UserDAO {

	public int insertUser(UserBean bean)
	{
		int count = 0;
		Connection DatabaseConnection = null;
		PreparedStatement ps = null;
		
		DatabaseConnection = DbConnection.getDatabaseConnection();
		try
		
/*
 * Inserting select query
 */
		{
		String query = "INSERT INTO HMS_ROOM_DAVINDER" +
		" (URN,ROOM_ID,ROOM_TYPE,ROOM_COST,NO_OF_BEDS,DEPARTMENT_ID" +
		") VALUES (SEQUENCE_HMS.NEXTVAL,?,?,?,?,?)";

		//java.sql.Date sqlDob = new java.sql.Date(bean.dob.getTime());

		ps = DatabaseConnection.prepareStatement(query);
		ps.setLong(1, bean.roomid);
		ps.setString(2,bean.type);
		ps.setLong(3, bean.roomcost);
		ps.setLong(4, bean.noofbeds);
		ps.setLong(5, bean.deptid);
		

		count = ps.executeUpdate();
		System.out.println("No of rows updated:" + count);

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return count;
	}
/* 
 * Dummy code 
 deleting a user
 by davinder
 */
	public int DeleteUser(UserBean bean)
	{
		Connection DatabaseConnection = null;
		Statement st = null;
		PreparedStatement ps = null;
		Scanner sc = new Scanner(System.in);
		ResultSet rs = null;
		int rs1=0;
		int dav=0;
		long urn = bean.roomid;
		
		try {
			//creating connection object
			DatabaseConnection = DbConnection.getDatabaseConnection();
			
			ps = DatabaseConnection.
			prepareStatement("DELETE from HMS_ROOM_DAVINDER where urn="+urn); 
			rs = ps.executeQuery();
				
			
			while(rs.next())
			{
				 rs1= rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
		

		//java.sql.Date sqlDob = new java.sql.Date(bean.dob.getTime());
		
		return dav;
		
	}
public ArrayList booking() throws SQLException
{
	ArrayList bookingId=new ArrayList();
	Connection DatabaseConnection = null;
	PreparedStatement ps = null;
	ResultSet rs=null;
	
	DatabaseConnection = DbConnection.getDatabaseConnection();
	try
	{
		String bId="SELECT URN FROM HMS_ROOM_DAVINDER";
		ps = DatabaseConnection.
		prepareStatement(bId); 
		rs = ps.executeQuery();
		while(rs.next())
		{
			UserBean bean=new UserBean();
			bean.urn=rs.getInt(1);
			bookingId.add(bean);
		}
	}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return bookingId;
}

public int update(UserBean bean)
{
	Connection DatabaseConnection = null;
	PreparedStatement ps = null;
	ResultSet rs=null;
	long urn_last= bean.urn;
	long roomcost=bean.roomcost;
	System.out.println(bean.roomcost);
	System.out.println(bean.urn);
	int dav=0;
	int rs1=0;
	
	//DatabaseConnection = DbConnection.getDatabaseConnection();
	try {
		//creating connection object
		DatabaseConnection = DbConnection.getDatabaseConnection();
		
		ps = DatabaseConnection.
		prepareStatement("UPDATE HMS_ROOM_DAVINDER SET room_cost=? where urn=?"); 
		//DatabaseConnection.setAutoCommit(false);
		ps.setLong(1, bean.roomcost);
		ps.setLong(2, bean.urn);
		rs = ps.executeQuery();
		//DatabaseConnection.commit();
			
		
		while(rs.next())
		{
			 rs1= rs.getInt(1);
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}


	

	//java.sql.Date sqlDob = new java.sql.Date(bean.dob.getTime());
	
	return dav;
	
}

	
/**
 * view room details	
 * @return
 */
	
	/*public static ArrayList<UserBean>searchUser(UserBean bean)
	{
		Connection DatabaseConnection = null;
		Statement st = null;
		PreparedStatement ps = null;
		Scanner sc = new Scanner(System.in);
		ResultSet rs = null;
		int rs1=0;
		int dav=0;
		long urn = bean.roomid;
		
		try {
			//creating connection object
			DatabaseConnection = DbConnection.getDatabaseConnection();
			ArrayList<UserBean> user = new ArrayList<UserBean>();
			ps = DatabaseConnection.
			prepareStatement("SELECT * from HMS_ROOM_DAVINDER where urn="+urn); 
			rs = ps.executeQuery();
				
			
			while(rs.next())
			{
				 //rs1= rs.getInt(1);
				UserBean users = new UserBean();
				users.urn= rs.getInt(1);
				users.roomid = rs.getInt(2);

				users.type = rs.getString(3);

				users.roomcost = rs.getInt(4);

				users.noofbeds = rs.getInt(5);

				users.deptid = rs.getInt(6);
				user.add(users);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
		return us

		//java.sql.Date sqlDob = new java.sql.Date(bean.dob.getTime());
		
	
		
		

	}
	
	*/
public ArrayList getData(int s)
{
	ArrayList<UserBean> details = new ArrayList<UserBean>();
	Connection DatabaseConnection = null;
	PreparedStatement ps = null;
	ResultSet rs=null;
	
	DatabaseConnection = DbConnection.getDatabaseConnection();
	try 
	{
		//SQL Query
		String get = "SELECT * FROM HMS_ROOM_DAVINDER WHERE URN=?";
		ps = DatabaseConnection.prepareStatement(get);
		ps.setInt(1, s);
		rs = ps.executeQuery();
		UserBean bean = new UserBean();
		while (rs.next()) 
		{
			bean.urn=rs.getInt(1);
			System.out.println(bean.urn);
			bean.roomid=rs.getInt(2);
			bean.type=rs.getString(3);
			bean.roomcost=rs.getInt(4);
			bean.noofbeds=rs.getInt(5);
			bean.deptid=rs.getInt(6);
			details.add(bean);
			
		}
	} 
	catch (SQLException e)
	{
		String response = "Fail";
		e.printStackTrace();
	}

	return details;

}
		
	
	
	
	
	public int davinder()
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
			prepareStatement("SELECT max(urn) from HMS_ROOM_DAVINDER"); 
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
	
	
	
		
}
