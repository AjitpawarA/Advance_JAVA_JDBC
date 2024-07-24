package com.ty.shop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DemoFetchProucts {
	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/Shop";
		try {
			Class.forName("org.postgresql.Driver");
			
			Connection con =DriverManager.getConnection(url, "postgres", "Ajit@123");
			
			String query = "Select * from products";
			
			Statement stm = con.createStatement();
			
			ResultSet rs =stm.executeQuery(query);
			
			
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				double cost = rs.getDouble(3);
				int quantity = rs.getInt(4);
				
				System.out.println("Name : "+ name + " ID : "+ id +" Cost: "+ cost+ " Qut: "+ quantity);
			}
			con.close();
			
			System.out.println("Data displayed sucessfully");
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		System.out.println("Driver is loaded");
		
	}
}
