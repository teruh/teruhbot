package co.teruh.bot.commands;

import java.util.Random;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class CommandItemBounce extends Command {
	
	public CommandItemBounce() {
		this.name = "itembounce";
	}

	@Override
	protected void execute(CommandEvent event) {
		event.reply(";;play https://www.youtube.com/watch?v=sVXnoanopzA");
	}
	
	
}
