package tw.brad.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class JDBC16 {
	private static final String URL = "jdbc:mysql://localhost/north";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static final String querySQL = """
							SELECT o.EmployeeID, e.FirstName, e.LastName, SUM(od.UnitPrice*od.Quantity) sum 
							FROM `orders` o
							JOIN orderdetails od ON o.OrderID = od.OrderID
							JOIN employees e ON o.EmployeeID = e.EmployeeID
							GROUP BY o.EmployeeID
							ORDER BY sum desc			
							""";
	
	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.setProperty("user", USER);
		prop.setProperty("password", PASSWORD);
		
		try (Connection conn = DriverManager.getConnection(URL, prop);
			PreparedStatement pstmt = conn.prepareStatement(querySQL);){
			ResultSet rs = pstmt.executeQuery();
			int rank = 1;
			while (rs.next()) {
				String id = rs.getString("EmployeeID");
				String fname = rs.getString("FirstName");
				String lname = rs.getString("LastName");
				String sum = rs.getString("sum");
				System.out.printf("%d => %s : %s : %s : %s\n", rank++, id, fname, lname,  sum);
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
