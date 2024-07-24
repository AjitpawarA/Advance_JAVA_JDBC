package connectionPool;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConnectionPool {
	public static void main(String[] args) {

		Connection con = ConnectionPool.getConnectionObject();

		String query = "Insert into products values (1025, 'Sam', 23.5, 4)";

		Statement stmt;
		try {
			stmt = con.createStatement();
			boolean res = stmt.execute(query);

			System.out.println("Result :" + res);

			String query2 = "Select * from products";
			boolean res2 = stmt.execute(query2);
			System.out.println("Result 2:" + res2);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
