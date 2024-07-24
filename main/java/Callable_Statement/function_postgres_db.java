package Callable_Statement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class function_postgres_db {
	static Connection con = null;

	public static void countByBG() {
		CallableStatement csmt;
		try {
			csmt = con.prepareCall("select count_by_bloodgroup(?)");
			csmt.setString(1, "o+");
			ResultSet rs = csmt.executeQuery();
			rs.next();
			System.out.println("Count :" + rs.getInt(1));
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void countByGender() {
		CallableStatement csmt;
		try {
			csmt = con.prepareCall("select count_by_gender(?)");
			csmt.setString(1, "female");
			ResultSet rs = csmt.executeQuery();
			rs.next();
			System.out.println("Count :" + rs.getInt(1));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("found");
	}

	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/teachers";

		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver is loaded");
			con = DriverManager.getConnection(url, "postgres", "Ajit@123");

			countByGender();

			countByBG();
			System.out.println(con);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
