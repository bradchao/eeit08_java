package tw.brad.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;
import java.util.Scanner;

public class JDBC10 {
	private static final String URL = "jdbc:mysql://localhost/brad";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static final String checkAccountSQL = "";
	private static final String registerSQL = "";
	private static Connection conn;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Account: ");
		String account = scanner.next();
		System.out.print("Password: ");
		String passwd = scanner.next();
		System.out.print("Name: ");
		String name = scanner.next();
		System.out.println("---");
		
		Properties prop = new Properties();
		prop.setProperty("user", USER);
		prop.setProperty("password", PASSWORD);
		
		try{
			conn = DriverManager.getConnection(URL, prop);
			if (checkAccount(account)) {
				int n = registerAccount(account, passwd, name);
				if (n > 0) {
					System.out.println("Register Success");
				}else {
					System.out.println("Register Failure");
				}
			}else {
				System.out.println("Account is EXIST!");
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	static boolean checkAccount(String account) throws Exception {
		PreparedStatement pstmt = conn.prepareStatement(checkAccountSQL);
		return true;
	}
	
	static int registerAccount(String account, String passwd, String name) throws Exception{
		PreparedStatement pstmt = conn.prepareStatement(registerSQL);
		return 1;
	}
	

}
