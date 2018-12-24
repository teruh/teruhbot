package co.teruh.bot.main;

import java.sql.*;

public class Database {

	/**
	 * Establish a new connection to a MySQL database
	 * @param sqlIp IP address 
	 * @param sqlDatabaseName
	 * @param sqlUser
	 * @param sqlPassword
	 */
	public Database(String sqlIp, String sqlDatabaseName, String sqlUser, String sqlPassword) {
		Connection connection;
		String url = "jdbc:mysql://" + sqlIp + "/" + sqlDatabaseName + "?user=" + sqlUser + "&password=" + sqlPassword;

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
