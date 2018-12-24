package co.teruh.bot.main;

import java.sql.*;

public class Database {
	
	private Connection connection;

	/**
	 * Establish a new connection to a MySQL database
	 * @param sqlIp IP address 
	 * @param sqlDatabaseName SQL Database name
	 * @param sqlUser SQL user
	 * @param sqlPassword SQL user password
	 */
	public Database(String sqlIp, String sqlDatabaseName, String sqlUser, String sqlPassword) {
		String url = "jdbc:mysql://" + sqlIp + "/" + sqlDatabaseName + "?user=" + sqlUser + "&password=" + sqlPassword;

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		return connection;
	}
}
