package closeConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CloseConnection {

	public static void main(String[] args) {
		Connection con = null;
		Scanner sc = new Scanner(System.in);
		
		String url = "jdbc:postgresql://localhost:5432/Shop";

		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver is loaded");

			con = DriverManager.getConnection(url, "postgres", "Ajit@123");

			String query = "insert into products values (?,?,?,?)";

			PreparedStatement prepared_Statements = con.prepareStatement(query);

			System.out.println("how many products u want to add: ");
			int num = sc.nextInt();
			int a = 0;
			while (a < num) {
				System.out.println("Enter id:");
				prepared_Statements.setInt(1, sc.nextInt());
				System.out.println("Enter name:");
				prepared_Statements.setString(2, sc.next());
				System.out.println("Entr cost:");
				prepared_Statements.setDouble(3, sc.nextDouble());
				System.out.println("Enter quantity:");
				prepared_Statements.setInt(4, sc.nextInt());
				a++;
				prepared_Statements.addBatch();
			}

			prepared_Statements.executeBatch();

			System.out.println("Data inserted");
			System.out.println(con);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
