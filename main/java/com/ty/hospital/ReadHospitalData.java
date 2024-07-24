package com.ty.hospital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadHospitalData {
	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/hospitals";
		try {
			Class.forName("org.postgresql.Driver");
			
			Connection con =DriverManager.getConnection(url, "postgres", "Ajit@123");
			
			String query = "Select * from hospitals where id =5";
			
			Statement stm = con.createStatement();
			
			ResultSet rs =stm.executeQuery(query);
			
			
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String loc = rs.getString(3);
				int capacity = rs.getInt(4);
				
				System.out.println("Name : "+ name + " ID : "+ id +" Location: "+ loc+ " Qut: "+ capacity);
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
