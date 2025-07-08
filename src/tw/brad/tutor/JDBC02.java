package tw.brad.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

// String connectionUrl = "jdbc:sqlserver://localhost;encrypt=true;database=AdventureWorks;integratedSecurity=true;"  
// Connection con = DriverManager.getConnection(connectionUrl);  

public class JDBC02 {
	public static void main(String[] args) {
//		try {
//			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/brad?user=root&password=root");
//			System.out.println("OK1");
//			conn.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
//		try {
//			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/brad","root","root");
//			System.out.println("OK2");
//			conn.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
		Properties prop = new Properties();
		prop.setProperty("user", "root");
		prop.setProperty("password", "root");
		
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/brad",prop);
			System.out.println("OK3");
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
	}
}
