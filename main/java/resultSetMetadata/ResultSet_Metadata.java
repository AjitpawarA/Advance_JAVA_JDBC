package resultSetMetadata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSet_Metadata {

	private static String url = "jdbc:postgresql://localhost:5432/Shop";
	public static void main(String[] args) {
		
		try {
			Class.forName("org.postgresql.Driver");
			
			System.out.println("Driver loaded");
			
			Connection con = DriverManager.getConnection(url,"postgres","Ajit@123");
			
			System.out.println("Connnection established");
			
			String query = "Select * from products";
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			ResultSetMetaData rmt = rs.getMetaData();
			
			int colcount=rmt.getColumnCount();
			String second_col_name = rmt.getColumnName(2);
			String third_col_name = rmt.getColumnName(3);
			
			System.out.println("colcount: "+ colcount);
			System.out.println("second_col_name: "+ second_col_name);
			System.out.println("third_col_name: "+ third_col_name);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
