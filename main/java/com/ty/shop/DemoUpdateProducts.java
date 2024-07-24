package com.ty.shop;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DemoUpdateProducts {
	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/Shop";
		try {
			Class.forName("org.postgresql.Driver");
			
			Connection con =DriverManager.getConnection(url, "postgres", "Ajit@123");
			
			String query = "UPDATE products SET quantity=20 WHERE id=2";
			
			Statement stm = con.createStatement();
			
			stm.execute(query);
			
			con.close();
			
			System.out.println("Data updated");
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		System.out.println("Driver is loaded");
		
	}
}
