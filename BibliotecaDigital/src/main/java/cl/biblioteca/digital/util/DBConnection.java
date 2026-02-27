package cl.biblioteca.digital.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * SINGLETON
 */
public class DBConnection {
	private static final String URL= "jdbc:mysql://localhost:3306/biblioteca?useSSL=false&serverTimezone=UTC";
	private static final String USER= "israel";
	private static final String PASS= "admin1234";
	
	public static Connection getConnection() throws SQLException {
		//Connection con = DriverManager.getConnection(URL, USER, PASS);
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return DriverManager.getConnection(URL, USER, PASS);
	}
}

