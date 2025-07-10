package tw.brad.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class JDBC17 {
	private static final String URL = "jdbc:mysql://localhost/brad";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static final String querySQL = """
							SELECT * FROM gift
							""";
	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.setProperty("user", USER);
		prop.setProperty("password", PASSWORD);
		
		try (Connection conn = DriverManager.getConnection(URL, prop);){
			
			PreparedStatement pstmt = conn.prepareStatement(querySQL,
					ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE
					);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			System.out.println(rs.getString("name"));
			rs.absolute(4);
			System.out.println(rs.getString("name"));
			rs.first();
			System.out.println(rs.getString("name"));
			rs.last();
			System.out.println(rs.getString("name"));
			rs.absolute(8);
			rs.updateString("feature", "很好喝");
			rs.updateString("tel", "0800-000-123");
			rs.updateRow();
			rs.absolute(1);
			System.out.println(rs.getString("name"));
			rs.absolute(8);
			System.out.println(rs.getString("feature"));
			rs.absolute(10);
			rs.deleteRow();
			System.out.println("-----");
			System.out.println(rs.getString("name"));
			rs.moveToInsertRow();
			rs.updateString("name", "不來的禮盒");
			rs.updateString("feature", "送禮自用都粉好");
			rs.insertRow();
			
			System.out.println("OK");
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
