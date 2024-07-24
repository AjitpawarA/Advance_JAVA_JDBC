import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Resultset {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String url = "jdbc:postgresql://localhost:5432/Shop";
		try {
			Class.forName("org.postgresql.Driver");

			Connection con = DriverManager.getConnection(url, "postgres", "Ajit@123");

			String query = "select * from products";

			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				System.out.println("id : " + rs.getInt(1));
				System.out.println("name : " + rs.getString(2));
				System.out.println("cost : " + rs.getDouble(3));
				System.out.println("quantity : " + rs.getInt(4));
				System.out.println("================");
			}
			System.out.println("Data fetched");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
