package Callable_Statement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class callableStatements {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			String url = "jdbc:postgresql://localhost:5432/teachers";

			try {
				Class.forName("org.postgresql.Driver");
				System.out.println("Driver is loaded");

				Connection con = DriverManager.getConnection(url, "postgres", "Ajit@123");

				String query = "call create_teacher_records(?,?,?,?,?,?,?)";
				
				CallableStatement csmt = con.prepareCall(query);
				
				System.out.println("how many products u want to add: ");
				int num = sc.nextInt();
				int a=0;
				while(a<num) {
					System.out.println("Enter id:");
					csmt.setInt(1, sc.nextInt());
					System.out.println("Enter name:");
					csmt.setString(2, sc.next());
					System.out.println("Entr gender:");
					csmt.setString(3, sc.next());
					System.out.println("Enter age:");
					csmt.setInt(4, sc.nextInt());
					System.out.println("Entr email:");
					csmt.setString(5, sc.next());
					System.out.println("Entr pthone:");
					csmt.setString(6, sc.next());
					System.out.println("Entr blood_group:");
					csmt.setString(7, sc.next());
					a++;
					csmt.addBatch();
				}
				
				csmt.executeBatch();

				System.out.println("Data inserted");
				System.out.println(con);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
} 
