package com.ty.shop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DemoSaveProduct {
	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/Shop";
		
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver is loaded");
			
			//step 2
			
			Connection con =DriverManager.getConnection(url, "postgres", "Ajit@123");
			
			//step 3 
			//create statement
			
			String sql = "INSERT INTO products (id, name, cost, quantity) VALUES"
					+ "(1, 'Samsung', 23.5, 4),\r\n"
					+ "(2, 'Sony', 15.0, 5),\r\n"
					+ "(3, 'LG', 2000.0, 3),\r\n"
					+ "(4, 'Apple', 300.0, 6),\r\n"
					+ "(5, 'Panasonic', 1.8, 7),\r\n"
					+ "(6, 'Microsoft', 25.0, 2),\r\n"
					+ "(7, 'Dell', 28.2, 3),\r\n"
					+ "(8, 'HP', 23.2, 5),\r\n"
					+ "(9, 'Lenovo', 19.25, 4);\r\n"
					+ "";
			
			Statement stm = con.createStatement();
			
			// step 4 - execute the query
			stm.execute(sql);
			
			//step 5 - close the connection
			con.close();
			
			System.out.println("Data inserted");
			System.out.println(con);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
