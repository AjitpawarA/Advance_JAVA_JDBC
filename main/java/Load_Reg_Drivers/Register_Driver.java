package Load_Reg_Drivers;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.postgresql.Driver;

public class Register_Driver {
	public static void main(String[] args) {
		
		Driver driver = new Driver();
		try {
			DriverManager.registerDriver(driver);
			
			System.out.println("Driver registered sucessfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
