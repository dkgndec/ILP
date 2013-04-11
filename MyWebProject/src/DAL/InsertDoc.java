package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import bean.DOC;
import bean.UserBean;

public class InsertDoc {
	
	public int insertUser(DOC bean)
	{
		int count = 0;
		Connection DatabaseConnection = null;
		PreparedStatement ps = null;
		
		
		DatabaseConnection = DbConnection.getDatabaseConnection();
		try
		{
		
			
			
			String query = "INSERT INTO STAFF_ABC_1 " +
			" (DR_ID,first_name,last_name,gender,fee,dob,qualification,specialization," +
			" visiting_days,email,Visiting_Time,contact) VALUES (sqdr.nextval,?,?,?,?,?,?,?,?,?,?,?)";
						
					java.sql.Date doe = new java.sql.Date(bean.dob.getTime());
						
						ps = DatabaseConnection.prepareStatement(query);
						ps.setString(1, bean.firstName);
						ps.setString(2, bean.lastName);
						ps.setLong(3, bean.gender);
						
					
						ps.setInt(4, bean.fee);
						ps.setDate(5, doe);
						ps.setString(6, bean.qualification);
						ps.setString(7, bean.specialization);
						//String a=bean.visting[0]+bean.visting[1]+bean.visting[2]+bean.visting[3]+bean.visting[4];
						
						ps.setString(8, bean.visting);
						
						ps.setString( 9, bean.email);
						
						
						ps.setString(10, bean.Visiting_Time);
						ps.setLong(11,bean.contact);
						//ps.setInt(12, bean.departmentid);
						count = ps.executeUpdate();
						System.out.println("No of rows updated:" + count);
						Statement st = null;
						st = DatabaseConnection.createStatement();
						if (count>=1)
						{
							//st = DatabaseConnection.createStatement();
							//String Query2="select QUANTITY from GROUP6_ITEMS where item_code="+code+"";
							//ResultSet rs =st.executeQuery(Query2);
						
						//	while(rs.next()){
							//int	k=rs.getInt("QUANTITY");
						//	System.out.print(k);
							///}
						
							//String Query1= "UPDATE GROUP6_ITEMS set QUANTITY=QUANTITY-"+bean.quant+" where item_code="+bean.code+"";
							//int count1 = st.executeUpdate(Query1);
							//System.out.println(count1);
							
						}
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
	public int UpadateUser(DOC bean)
	{
		int count = 0;
		Connection DatabaseConnection = null;
		PreparedStatement ps = null;
		
		
		DatabaseConnection = DbConnection.getDatabaseConnection();
		try
		{
		
			
			
String query = "update STAFF_ABC_1  set first_name=?,last_name=?,gender=?,fee=?,dob=?,qualification=?,specialization=? ,visiting_days=?,email=?,Visiting_Time=?,contact=? where dr_id=?";
						
					java.sql.Date doe = new java.sql.Date(bean.dob.getTime());
						
						ps = DatabaseConnection.prepareStatement(query);
						ps.setString(1, bean.firstName);
						ps.setString(2, bean.lastName);
						ps.setLong(3, bean.gender);
						
					
						ps.setInt(4, bean.fee);
						ps.setDate(5, doe);
						ps.setString(6, bean.qualification);
						ps.setString(7, bean.specialization);
						//String a=bean.visting[0]+bean.visting[1]+bean.visting[2]+bean.visting[3]+bean.visting[4];
						
						ps.setString(8, bean.visting);
						
						ps.setString( 9, bean.email);
						
						
						ps.setString(10, bean.Visiting_Time);
						ps.setLong(11,bean.contact);
					//	ps.setInt(12, bean.departmentid);
						ps.setInt(12, bean.id);
						count = ps.executeUpdate();
						System.out.println("No of rows updated:" + count);
						Statement st = null;
						st = DatabaseConnection.createStatement();
						System.out.println("No of rows updated:" + count);
							//String Query2="select QUANTITY from GROUP6_ITEMS where item_code="+code+"";
							//ResultSet rs =st.executeQuery(Query2);
						
						//	while(rs.next()){
							//int	k=rs.getInt("QUANTITY");
						//	System.out.print(k);
							///}
						
							//String Query1= "UPDATE GROUP6_ITEMS set QUANTITY=QUANTITY-"+bean.quant+" where item_code="+bean.code+"";
							//int count1 = st.executeUpdate(Query1);
							//System.out.println(count1);
							
						
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
	
	public int deleteUser(DOC bean)
	{
		int count = 0;
		Connection DatabaseConnection = null;
		PreparedStatement ps = null;
		Statement st = null;
		
		DatabaseConnection = DbConnection.getDatabaseConnection();
		try
		{
		
		
			
String query = "delete from STAFF_ABC_1 where dr_id=?";
						
ps = DatabaseConnection.prepareStatement(query);
				ps.setInt(1,bean.id);

						count = ps.executeUpdate();
						System.out.println("No of rows updated:" + count);
						
						
					
							//String Query2="select QUANTITY from GROUP6_ITEMS where item_code="+code+"";
							//ResultSet rs =st.executeQuery(Query2);
						
						//	while(rs.next()){
							//int	k=rs.getInt("QUANTITY");
						//	System.out.print(k);
							///}
						
							//String Query1= "UPDATE GROUP6_ITEMS set QUANTITY=QUANTITY-"+bean.quant+" where item_code="+bean.code+"";
							//int count1 = st.executeUpdate(Query1);
							//System.out.println(count1);
							
						
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


}

	