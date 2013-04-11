package DAL2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection implements Constant{
	
private static Connection DatabaseConnection;
	
	private static void openConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			DatabaseConnection = DriverManager.getConnection(DBURL, DBUSERNAME,
					DBPASSWORD);
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void closeConnection() {
		try {
			if(DatabaseConnection != null)
			{
				DatabaseConnection.close();
				DatabaseConnection = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getDatabaseConnection() {
		
		if(DatabaseConnection == null)
		{
			openConnection();
		}
		return DatabaseConnection;
	}



}
