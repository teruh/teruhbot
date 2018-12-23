package co.teruh.bot.main;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BotConfiguration {
	
	private String token; // Discord bot token
	
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
	
		// Close IO stream now that properties have been set
		ioStream.close();
	}
	
	/**
	 * Set discord bot token
	 * @param token discord bot token
	 */
	public void setToken(String token) {
		this.token = token;
	}
	
	/**
	 * Get discord bot token
	 * @return discord bot token
	 */
	public String getToken() {
		return token;
	}
}