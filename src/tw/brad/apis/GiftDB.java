package tw.brad.apis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class GiftDB {
	private static final String URL = "jdbc:mysql://localhost/brad";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static final String querySQL = """
		SELECT id, name, feature, tel FROM gift
							""";
	private Connection conn;
	private ResultSet rs;
	
	public GiftDB() throws Exception {
		Properties prop = new Properties();
		prop.setProperty("user", USER);
		prop.setProperty("password", PASSWORD);
		conn = DriverManager.getConnection(URL, prop);
		queryDB();
	}
	public void queryDB() throws Exception {queryDB(querySQL);}
	public void queryDB(String sql) throws Exception{
		Statement stmt = conn.createStatement(
				ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		rs = stmt.executeQuery(sql);
	}
	
	public int getRows() {
		try {
			rs.last();
			return rs.getRow();
		}catch(Exception e) {
			return 0;
		}
	}
	
	public int getCols() {
		return 4;
	}
	// row, col => 0-base
	public String getData(int row, int col) {
		try {
			rs.absolute(row+1);
			return rs.getString(col+1);
		}catch(Exception e) {
			return "#ERROR";
		}
	}
	
	
}
