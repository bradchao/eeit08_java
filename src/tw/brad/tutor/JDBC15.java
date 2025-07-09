package tw.brad.tutor;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import tw.brad.apis.Bike;

public class JDBC15 {
	private static final String URL = "jdbc:mysql://localhost/brad";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static final String querySQL = "SELECT * FROM member WHERE id = ?";
	
	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.setProperty("user", USER);
		prop.setProperty("password", PASSWORD);
		
		try (Connection conn = DriverManager.getConnection(URL, prop);){
			
			PreparedStatement pstmt = conn.prepareStatement(querySQL);
			pstmt.setInt(1, 1);
			
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			
			InputStream in = rs.getBinaryStream("bike");
			ObjectInputStream oin = new ObjectInputStream(in);
			Object obj = oin.readObject();
			Bike bike = (Bike)obj;
			System.out.println(bike);

			oin.close();
			
			
			System.out.println("OK");
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
