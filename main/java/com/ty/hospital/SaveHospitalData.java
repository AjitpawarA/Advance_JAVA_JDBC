package com.ty.hospital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SaveHospitalData {
	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/hospitals";
		
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver is loaded");
			
			Connection con =DriverManager.getConnection(url, "postgres", "Ajit@123");
			
			
			String sql = "INSERT INTO hospitals (id, name, location, capacity) VALUES\r\n"
					+ "(1, 'City Hospital', 'New York', 200),\r\n"
					+ "(2, 'Green Valley Clinic', 'San Francisco', 150),\r\n"
					+ "(3, 'Mountain View Medical Center', 'Denver', 300),\r\n"
					+ "(4, 'Ocean Breeze Hospital', 'Miami', 250),\r\n"
					+ "(5, 'Desert Oasis Health', 'Phoenix', 180);\r\n"
					+ "";
			
			Statement stm = con.createStatement();
			
			stm.execute(sql);
		
			con.close();
			
			System.out.println("Data inserted");
			System.out.println(con);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}
