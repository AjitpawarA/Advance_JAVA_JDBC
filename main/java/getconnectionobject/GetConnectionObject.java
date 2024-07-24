package getconnectionobject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class GetConnectionObject {

	public static void main(String[] args) {
		try {

			FileInputStream fis = new FileInputStream("schooldb.properties");

			Properties proprties = new Properties();

			proprties.load(fis);
			String driver_path = proprties.getProperty("driverClassPath");
			Class.forName(driver_path);

			String url = proprties.getProperty("url");

			Connection con = DriverManager.getConnection(url, proprties);
			System.out.println(con);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
