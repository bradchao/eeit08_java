package tw.brad.tutor;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONArray;
import org.json.JSONObject;

public class JDBC06 {

	public static void main(String[] args) {
		try {
			URL url = new URL("https://data.moa.gov.tw/Service/OpenData/ODwsv/ODwsvAgriculturalProduce.aspx");
			HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
			
			BufferedReader reader = 
				new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line; StringBuffer sb = new StringBuffer();
			while ( (line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			reader.close();
			conn.disconnect();
			System.out.println("Parse....");
			parseJSON(sb.toString());
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	static void parseJSON(String json) {
		Properties prop = new Properties();
		prop.setProperty("user", "root");
		prop.setProperty("password", "root");
		
		try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/brad",prop);) {
			
			String sql = "INSERT INTO gift (name,addr,tel,city,town,feature,picurl,lat,lng) " + 
						"VALUES (?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			JSONArray root = new JSONArray(json);
			System.out.println(root.length());
			for (int i=0; i<root.length(); i++) {
				JSONObject row = root.getJSONObject(i);
				String name = row.getString("Name");
				String addr = row.getString("SalePlace");
				String tel = row.getString("ContactTel");
				String city = row.getString("County");
				String town = row.getString("Township");
				
				String feature = row.getString("Feature");
				String picurl = row.getString("Column1");
				
				String lat = row.getString("Latitude");
				String lng = row.getString("Longitude");
				
				pstmt.setString(1, name);
				pstmt.setString(2, addr);
				pstmt.setString(3, tel);
				pstmt.setString(4, city);
				pstmt.setString(5, town);
				pstmt.setString(6, feature);
				pstmt.setString(7, picurl);
				
				try {
					pstmt.setDouble(8, Double.parseDouble(lat));
					pstmt.setDouble(9, Double.parseDouble(lng));
				}catch(Exception e) {
					pstmt.setDouble(8, 0.0);
					pstmt.setDouble(9, 0.0);
				}
				pstmt.executeUpdate();
				
			}
			System.out.println("Finish");
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
