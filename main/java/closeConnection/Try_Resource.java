package closeConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Try_Resource {
	public static void main(String[] args) {
		
		String url = "jdbc:postgresql://localhost:5432/Shop";
		try {
			
			Class.forName("org,postgresql.Driver");
			System.out.println("Driver is loaded");
		} catch (Exception e) {
		}
		try(Connection con = DriverManager.getConnection(url, "postgres", "Ajit@123");) {
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
}
