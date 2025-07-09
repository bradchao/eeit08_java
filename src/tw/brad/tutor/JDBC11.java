package tw.brad.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

import tw.brad.apis.BCrypt;
import tw.brad.apis.Member;

public class JDBC11 {
	private static final String URL = "jdbc:mysql://localhost/brad";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static final String loginSQL = "SELECT * FROM member WHERE account = ?";
	private static final int LOGIN_ACCOUNT_FIELD = 1;
	private static final String updatePasswdSQL = "UPDATE member SET passwd = ? WHERE id = ?";
	private static final int UPDATE_PASSWD_FIELD = 1;
	private static final int UPDATE_ID_FIELD = 2;
	private static final String MEMBER_FIELD_ID = "id";
	private static final String MEMBER_FIELD_ACCOUNT = "account";
	private static final String MEMBER_FIELD_PASSWD = "passwd";
	private static final String MEMBER_FIELD_NAME = "name";
	
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
				String hashPasswd = rs.getString(MEMBER_FIELD_PASSWD);
				if (BCrypt.checkpw(passwd, hashPasswd)) {
					int id = rs.getInt(MEMBER_FIELD_ID);
					String name = rs.getString(MEMBER_FIELD_NAME);
					
					Member member = new Member(id, name, account, passwd);
					
					System.out.printf("Welcome, %s", member.getName());
					System.out.println("-----");
					// 詢問是否要修改密碼 => Y/N
					System.out.print("是否要修改密碼(Y/N)");
					if (scanner.next().equals("Y")){
						System.out.print("OLD passwod: ");
						String inputOldPasswd = scanner.next();
						if (passwd.equals(inputOldPasswd)) {
							System.out.print("NEW passwod: ");
							String inputNewPasswd = scanner.next();
							PreparedStatement pstmt2 = conn.prepareStatement(updatePasswdSQL);
							pstmt2.setInt(UPDATE_ID_FIELD, member.getId());
							pstmt2.setString(UPDATE_PASSWD_FIELD, BCrypt.hashpw(inputNewPasswd, BCrypt.gensalt()));
							if (pstmt2.executeUpdate() > 0) {
								System.out.println("UPDATE success");
							}else {
								System.out.println("UPDATE failure");
								
							}
						}else {
							System.out.println("ERROR");
						}
					}
					
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
