package tw.brad.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

public class JDBC08 {
	private static final String URL = "jdbc:mysql://localhost/brad";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static final int RPP = 7;
	private static final String SQL = "SELECT * FROM gift ORDER BY id LIMIT ?, ?";

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("頁:");
		int page = scanner.nextInt();
		int start = (page - 1) * RPP;
		
		System.out.println("--------");
		Properties prop = new Properties();
		prop.setProperty("user", USER);
		prop.setProperty("password", PASSWORD);
		
		try(Connection conn = DriverManager.getConnection(URL, prop)){
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, start);
			pstmt.setInt(2, RPP);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				System.out.printf("%s:%s\n", id, name);
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}

}
