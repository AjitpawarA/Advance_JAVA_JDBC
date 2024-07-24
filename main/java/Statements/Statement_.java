package Statements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Statement_ {
	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/Shop";
		try {
			Class.forName("org.postgresql.Driver");
			
			Connection con =DriverManager.getConnection(url, "postgres", "Ajit@123");
			
			String query = "Select * from products";
			
			Statement stm = con.createStatement();
			
			boolean rs =stm.execute(query);
			
			System.out.println(rs);
			
		} catch (ClassNotFoundException e) {
			
			
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
