package co.teruh.bot;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BotConfiguration {
	
	private String token;
	
	public BotConfiguration(String propFile) throws IOException {		
		InputStream ioStream = getClass().getClassLoader().getResourceAsStream(propFile);
		Properties config = new Properties();
		config.load(ioStream);
		
		setToken(config.getProperty("token"));
	}
	
	public void setToken(String token) {
		this.token = token;
	}
	
	public String getToken() {
		return this.token;
	}
}