import java.sql.*;
import java.util.*;

public class DatabaseTest {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String DBURL = "jdbc:oracle:thin:@172.26.132.40:1521:ORCL";
		String DBUSERNAME = "a76core";
		String DBPASSWORD = "a76core";
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		Connection DatabaseConnection = null;
		Statement st = null;
		Scanner sc = new Scanner(System.in);
		
		try {
			//loading the driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			//creating connection object
			DatabaseConnection = DriverManager.getConnection(DBURL, DBUSERNAME,
					DBPASSWORD);
			
			System.out.println("Enter old contact:");
			
			String oldContact = sc.nextLine();
			
			System.out.println("Enter new contact:");
			
			String newContact = sc.nextLine();
			
			String query = "UPDATE TAB_594045_ASSOCIATE SET CONTACT = '"+newContact+"' WHERE CONTACT = '"+oldContact+"'";
			
			st = DatabaseConnection.createStatement();
			
			int count = st.executeUpdate(query);
			
			System.out.println("No of rows updated:" + count);
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
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
		}
	}

}




