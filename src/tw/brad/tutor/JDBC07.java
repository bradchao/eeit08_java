package tw.brad.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

public class JDBC07 {

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.setProperty("user", "root");
		prop.setProperty("password", "root");
		
		try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/brad",prop);) {
			Scanner scanner = new Scanner(System.in);
			System.out.print("Keyword:");
			String key = scanner.next();
			String search = "%" + key + "%";
			String sql = "SELECT id, name, tel, addr, city, town, feature FROM gift  " +
						"WHERE name LIKE ? OR feature LIKE ? ORDER BY city, town, addr";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, search);
			pstmt.setString(2, search);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String feature = rs.getString("feature");
				String city = rs.getString("city");
				String town = rs.getString("town");
				String addr = rs.getString("addr");
				System.out.printf("%s:%s:%s%s%s\n", id, name, city,town,addr);
			}
			
			
			
			
			
			
			
		}catch(Exception e) {
			System.out.println(e);
		}

	}

}
