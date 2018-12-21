package co.teruh.bot;

import java.io.IOException;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Teruhbot extends ListenerAdapter {
	
	public static void main(String[] args) throws LoginException, IOException {
		BotConfiguration botConfig = new BotConfiguration("bot.properties");
		
		JDA jda = new JDABuilder(botConfig.getToken()).build();
		jda.addEventListener(new Teruhbot());
	}
}