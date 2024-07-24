package databaseMetaData;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseMetadata {
	public static void main(String[] args) {
String url = "jdbc:postgresql://localhost:5432/hospitals";
		
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver is loaded");
			
			Connection con =DriverManager.getConnection(url, "postgres", "Ajit@123");
			
			DatabaseMetaData dmd = con.getMetaData();
			
			String usename=dmd.getUserName();
			String driverversion=dmd.getDriverVersion();
			String drivername=dmd.getDriverName();
			
			
			boolean res = dmd.supportsOuterJoins();
			
			
			System.out.println("username :"+usename);
			System.out.println("Driver name :"+ drivername);
			System.out.println("Driver version :"+ driverversion);
			System.out.println("Suports outer joins : "+ res);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}
