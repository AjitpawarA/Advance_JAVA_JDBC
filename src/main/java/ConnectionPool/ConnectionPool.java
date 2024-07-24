package ConnectionPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
	private static List<Connection> connectionsPool = new ArrayList<Connection>();
	private static String driverpath = "org.postgresql.Driver";
	private static String URL = "jdbc:postgresql://localhost:5432/car_app__jdbc";
	private static String user = "postgres";
	private static String passward = "Ajit@123";

	private static final int poolSize = 5;

	static {
		try {
			Class.forName(driverpath);

			for (int i = 0; i < poolSize; i++) {
				connectionsPool.add(createConnection());
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getConnectionObject() {
		if (!connectionsPool.isEmpty()) {
			return connectionsPool.remove(0);
		} else {
			return createConnection();
		}
	}

	public void returnConnectionObject(Connection connection) {
		if (connectionsPool.size() < poolSize) {
			connectionsPool.add(connection);
		} else {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private static Connection createConnection() {
		Connection connection = null;

		try {
			connection = DriverManager.getConnection(URL, user, passward);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return connection;
	}

}
