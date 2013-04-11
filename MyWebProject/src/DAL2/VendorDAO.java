package DAL2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




import Bean2.VendorBean;
import DAL2.DbConnection;

public class VendorDAO {
	public static final DbConnection DbConnection = null;
	

	public int insertVendor(VendorBean bean)
	{
		int count = 0;
		Connection DatabaseConnection = null;
		PreparedStatement ps = null;
		
		DatabaseConnection = DbConnection.getDatabaseConnection();
		try
		{
		String query = "INSERT INTO TBL_vendor" +
		" (vendor_id,vendor_name,company_name,addr_line1,addr_line2,city,state,phone_no,emailno)" +
		 "VALUES (seq_590561.NEXTVAL,?,?,?,?,?,?,?,?)";

		ps = DatabaseConnection.prepareStatement(query);
		ps.setString(1, bean.vendor_Name);
		ps.setString(2,bean.company);
		ps.setString(3, bean.addrline1);
		ps.setString(4, bean.addrline2);
		ps.setString(5, bean.city);
		ps.setString(6, bean.state);
		ps.setLong(7, bean.contactno);
		ps.setString(8,bean.email );

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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//database insertion completed

		
		
		return count;
	}
	public  int getVendorid()
	{

		Connection DatabaseConnection = null;
		Statement st = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int id=0;
		try {
			//creating connection object
			DatabaseConnection = DbConnection.getDatabaseConnection();

			ps = DatabaseConnection.
			prepareStatement("Select max(vendor_id) from tbl_vendor" );
			rs = ps.executeQuery();
				
			
			while(rs.next())
			{
			id=rs.getInt(1);
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
		System.out.println(id);
		return id ;

	}
	
	

}
