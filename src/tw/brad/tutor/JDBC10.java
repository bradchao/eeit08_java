package tw.brad.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

import tw.brad.apis.BCrypt;

public class JDBC10 {
	private static final String URL = "jdbc:mysql://localhost/brad";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static final String checkAccountSQL = "SELECT count(*) count FROM member WHERE account = ?";
	private static final int CHECK_ACCOUNT = 1;
	private static final String CHECK_ACCOUNT_FIELD = "count";
	
	private static final String registerSQL = "INSERT INTO member (account,passwd,name) VALUES (?,?,?)";
	private static final int REG_ACCOUNT = 1;
	private static final int REG_PASSWD = 2;
	private static final int REG_NAME = 3;
	
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
			if (!isAccountExist(account)) {
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
	
	static boolean isAccountExist(String account) throws Exception {
		PreparedStatement pstmt = conn.prepareStatement(checkAccountSQL);
		pstmt.setString(CHECK_ACCOUNT, account);
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		return rs.getInt(CHECK_ACCOUNT_FIELD) > 0;
	}
	
	static int registerAccount(String account, String passwd, String name) throws Exception{
		PreparedStatement pstmt = conn.prepareStatement(registerSQL);
		pstmt.setString(REG_ACCOUNT, account);
		pstmt.setString(REG_PASSWD, BCrypt.hashpw(passwd, BCrypt.gensalt()));
		pstmt.setString(REG_NAME, name);
		
		return pstmt.executeUpdate();
	}
	

}
