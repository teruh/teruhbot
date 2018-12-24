package co.teruh.bot.main;

import java.io.IOException;

import javax.security.auth.login.LoginException;

import com.jagrosh.jdautilities.command.CommandClient;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;

import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;

import co.teruh.bot.commands.*;
import co.teruh.bot.utils.GameNameGenerator;

public class Teruhbot {

	/**
	 * Create a new instance of our bot
	 * 
	 * @param args command-line arguments
	 * @throws LoginException
	 * @throws IOException
	 */
	public static void main(String[] args) throws LoginException, IOException {
		// Read bot settings
		BotConfiguration botConfig = new BotConfiguration("bot.properties");

		// Connect to MySQL database
		Database db = new Database(botConfig.getSqlIp(), botConfig.getSqlDatabaseName(), botConfig.getSqlUser(),
				botConfig.getSqlPassword());

		// Initialize JDA-Utils command engine
		CommandClientBuilder command = new CommandClientBuilder().setOwnerId(botConfig.getToken())
				.setPrefix(botConfig.getPrefix()).setGame(Game.playing(GameNameGenerator.selectName()))
				.addCommands(new CommandSans(), new CommandChief(), new CommandCurrencyEnroll(db),
						new CommandCurrencyWorth(db));
		EventWaiter eventWaiter = new EventWaiter();
		CommandClient commandClient = command.build();

		// Initialize JDA bot
		JDA jda = new JDABuilder(botConfig.getToken()).build();
		jda.addEventListener(eventWaiter);
		jda.addEventListener(commandClient);
	}
}