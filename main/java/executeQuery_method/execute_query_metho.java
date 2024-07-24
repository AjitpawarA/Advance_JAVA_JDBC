package executeQuery_method;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class execute_query_metho {
	
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
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				double cost = rs.getDouble("cost");
				int qut = rs.getInt("quantity");
				System.out.println("-----------------");
				System.out.println(id+" "+name+" "+cost+" "+qut);
				
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
