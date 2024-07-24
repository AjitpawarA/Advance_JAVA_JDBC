package Statements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class prepared_statement_delete_query {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String url = "jdbc:postgresql://localhost:5432/Shop";
		try {
			Class.forName("org.postgresql.Driver");

			Connection con = DriverManager.getConnection(url, "postgres", "Ajit@123");

			String query = "delete from products where id = ?";

			PreparedStatement pstmt = con.prepareStatement(query);
			System.out.println("Enter id:");
			pstmt.setInt(1, sc.nextInt());

			pstmt.execute();
			System.out.println("Data deleted");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
