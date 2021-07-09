package fahrtenbuch.data;

import java.sql.*;

public class database_Conection {

	private static database_Conection instance;

	private database_Conection() {
	}

	public static database_Conection getInstance() {
		if (instance == null) {
			instance = new database_Conection();
		}
		return instance;
	}

	private static Connection conn;

	public void createNewDatabase(String fileName) {
		String loca = System.getProperty("user.dir") + "\\database";

		String url = "jdbc:sqlite:" + loca + "\\" + fileName;
		conn = null;

		try {

			conn = DriverManager.getConnection(url);
			System.out.println("Connect durchgefuehrt ....");
			conn.setAutoCommit(false);
			System.out.println(conn.getAutoCommit());
		} catch (Exception e) {
			System.err.println("Error while connecting to database");
			e.printStackTrace();
			System.exit(1);
		}
	}

	public static Connection getConnection() {
		return conn;
	}
	
	public void initialise() throws SQLException {
		DatabaseMetaData dbm = conn.getMetaData();
		// check if "employee" table is there
		ResultSet tables = dbm.getTables(null, null, "person", null);
		if (tables.next()) {
			System.out.println("tabelle existiert");
		}
		else {
		  System.out.println("tabelle existiert nicht");
		}
	}
}
