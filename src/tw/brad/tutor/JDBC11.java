package tw.brad.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

import tw.brad.apis.BCrypt;

public class JDBC11 {
	private static final String URL = "jdbc:mysql://localhost/brad";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static final String loginSQL = "SELECT * FROM member WHERE account = ?";
	private static final int LOGIN_ACCOUNT_FIELD = 1;
	
	private static Connection conn;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Account: ");
		String account = scanner.next();
		System.out.print("Password: ");
		String passwd = scanner.next();
		System.out.println("---");
		
		Properties prop = new Properties();
		prop.setProperty("user", USER);
		prop.setProperty("password", PASSWORD);
		
		try{
			conn = DriverManager.getConnection(URL, prop);
			PreparedStatement pstmt = conn.prepareStatement(loginSQL);
			pstmt.setString(LOGIN_ACCOUNT_FIELD, account);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				String hashPasswd = rs.getString("passwd");
				if (BCrypt.checkpw(passwd, hashPasswd)) {
					String name = rs.getString("name");
					System.out.printf("Welcome, %s", name);
					System.out.println("-----");
					// 詢問是否要修改密碼 => Y/N
					
					
				}else {
					// passwd ERROR
					System.out.println("Login Failure");
				}
			}else {
				// account NOT EXIST
				System.out.println("Login Failure");
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	

}
