package execute;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class execute_query {
	private static String url = "jdbc:postgresql://localhost:5432/Shop";
	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver loaded");
			
			Connection con = DriverManager.getConnection(url,"postgres","Ajit@123");
			System.out.println("Conection establised");
			
			Statement stmt = con.createStatement();
			
			String query = "Insert into products values (11, 'Sam', 23.5, 4)";
			boolean res = stmt.execute(query);
			
			System.out.println("Result :"+ res);
			
			
			String query2 = "Select * from products";
			boolean res2 = stmt.execute(query2);
			System.out.println("Result 2:" +res2);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
