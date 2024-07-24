package com.ty.hospital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeletaHospitalByID {
	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/hospitals";
		try {
			Class.forName("org.postgresql.Driver");

			Connection con = DriverManager.getConnection(url, "postgres", "Ajit@123");

			String query = "Delete from hospitals where id=5";

			Statement stm = con.createStatement();

			stm.execute(query);

			con.close();

			System.out.println("Data deleted");

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		System.out.println("Driver is loaded");

	}
}
