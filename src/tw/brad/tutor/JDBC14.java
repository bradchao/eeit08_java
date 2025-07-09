package tw.brad.tutor;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import tw.brad.apis.Bike;

public class JDBC14 {
	private static final String URL = "jdbc:mysql://localhost/brad";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static final String updateSQL = "UPDATE member SET bike = ? WHERE id = ?";
	
	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.setProperty("user", USER);
		prop.setProperty("password", PASSWORD);
		
		Bike b1 = new Bike();
		b1.upSpeed().upSpeed().upSpeed().upSpeed();
		System.out.println(b1);
		
		try (Connection conn = DriverManager.getConnection(URL, prop);){
			
			PreparedStatement pstmt = conn.prepareStatement(updateSQL);
			pstmt.setObject(1, b1);
			pstmt.setInt(2, 1);
			
			pstmt.executeUpdate();
			System.out.println("OK");
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
