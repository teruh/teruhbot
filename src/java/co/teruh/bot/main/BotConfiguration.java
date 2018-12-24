package co.teruh.bot.main;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BotConfiguration {
	
	private String token; // Discord bot token
	private String prefix;
	private String sqlIp;
	private String sqlDatabaseName;
	private String sqlUser;
	private String sqlPassword;
	
	/**
	 * Read and store bot configuration attributes
	 * @param propFile path to file
	 * @throws IOException
	 */
	public BotConfiguration(String propFile) throws IOException {		
		// Load configuration file
		InputStream ioStream = getClass().getClassLoader().getResourceAsStream(propFile);
		Properties config = new Properties();
		config.load(ioStream);
		
		// Save properties
		setToken(config.getProperty("token"));
		setPrefix(config.getProperty("prefix"));
		setSqlIp(config.getProperty("sql_ip"));
		setSqlDatabaseName(config.getProperty("sql_db_name"));
		setSqlUser(config.getProperty("sql_user"));
		setSqlPassword(config.getProperty("sql_pw"));
		
		// Close IO stream now that properties have been set
		ioStream.close();
	}
	
	/**
	 * Get discord bot token
	 * @return discord bot token
	 */
	public String getToken() {
		return token;
	}
	
	/**
	 * Set discord bot token
	 * @param token discord bot token
	 */
	private void setToken(String token) {
		this.token = token;
	}
	
	/**
	 * Get command prefix
	 * @return command prefix
	 */
	public String getPrefix() {
		return prefix;
	}
	
	/**
	 * Set command prefix
	 * @param prefix command prefix
	 */
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	/**
	 * Get user's SQL Database IP
	 * @return SQL database IP
	 */
	public String getSqlIp() {
		return sqlIp;
	}

	/**
	 * Set user's SQL Database IP
	 * @param sqlIp SQL database IP
	 */
	private void setSqlIp(String sqlIp) {
		this.sqlIp = sqlIp;
	}

	/**
	 * Get user's SQL Database name
	 * @return SQL database name
	 */
	public String getSqlDatabaseName() {
		return sqlDatabaseName;
	}

	/**
	 * Set user's SQL Database name
	 * @param sqlDatabaseName SQL database name
	 */
	private void setSqlDatabaseName(String sqlDatabaseName) {
		this.sqlDatabaseName = sqlDatabaseName;
	}

	/**
	 * Get user's SQL username
	 * @return SQL username
	 */
	public String getSqlUser() {
		return sqlUser;
	}

	/**
	 * Set user's SQL username
	 * @param sqlUser SQL username
	 */
	private void setSqlUser(String sqlUser) {
		this.sqlUser = sqlUser;
	}

	/**
	 * Get user's SQL user password
	 * @return SQL password
	 */
	public String getSqlPassword() {
		return sqlPassword;
	}

	/**
	 * Set user's SQL user password
	 * @param sqlPassword SQL password
	 */
	private void setSqlPassword(String sqlPassword) {
		this.sqlPassword = sqlPassword;
	}
}