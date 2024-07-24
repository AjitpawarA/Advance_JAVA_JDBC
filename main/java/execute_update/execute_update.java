package execute_update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class execute_update {
	private static String url = "jdbc:postgresql://localhost:5432/Shop";
	public static void main(String[] args) {
		
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver loaded ");
			
			Connection con =DriverManager.getConnection(url,"postgres","Ajit@123");
			System.out.println("Connection established");
			
			Statement stmt = con.createStatement();
			
			String query= "update products set cost = 600 where id = 101";
		
			int res = stmt.executeUpdate(query);
			System.out.println("Res: "+ res);

			String query1= "Insert into products values (71, 'Sam', 23.5, 4)";
			
			int res1 = stmt.executeUpdate(query1);
			System.out.println("Res: "+ res1);
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
