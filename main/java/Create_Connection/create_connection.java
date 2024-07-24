package Create_Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class create_connection {
	public static void main(String[] args) {
		
		try {
			
			Class.forName("org.postgresql.Driver");
			System.out.println("Class loaded");
			Connection con =DriverManager.getConnection("jdbc:postgresql://localhost:5432/Shop","postgres","Ajit@123");
			
			System.out.println(con);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
