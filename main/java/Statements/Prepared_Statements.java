package Statements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Prepared_Statements {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String url = "jdbc:postgresql://localhost:5432/Shop";
		try {
			Class.forName("org.postgresql.Driver");

			Connection con = DriverManager.getConnection(url, "postgres", "Ajit@123");

			String query = "Insert into products values (?,?,?,?)";

			PreparedStatement pstmt = con.prepareStatement(query);
			System.out.println("Enter id:");
			pstmt.setInt(1, sc.nextInt());
			System.out.println("Enter name:");
			pstmt.setString(2, sc.next());
			System.out.println("Entr cost:");
			pstmt.setDouble(3, sc.nextDouble());
			System.out.println("Enter quantity:");
			pstmt.setInt(4, sc.nextInt());

			pstmt.execute();
			System.out.println("Data inserteed");

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
