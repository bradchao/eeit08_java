package tw.brad.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;
import java.util.Scanner;

public class JDBC04 {

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.setProperty("user", "root");
		prop.setProperty("password", "root");
		
		try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/brad",prop);) {
			Scanner scanner = new Scanner(System.in);
			System.out.print("Name:");
			String name = scanner.next();
			System.out.print("Tel:");
			String tel = scanner.next();
			System.out.print("Birthday:");
			String birthday = scanner.next();
			String sql = "INSERT INTO cust (cname,tel,birthday) VALUES (?,?,?)";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, tel);
			pstmt.setString(3, birthday);
			
			int n = pstmt.executeUpdate();
			if (n > 0) {
				System.out.println("insert success");
			}else {
				System.out.println("insert failure");
			}			
			
			
			
			
			
			
		
		}catch (Exception e) {
			System.out.println(e);
		}

	}

}
