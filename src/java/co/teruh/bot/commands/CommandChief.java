package co.teruh.bot.commands;

import java.util.Random;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class CommandChief extends Command {
	
	public CommandChief() {
		this.name = "it";
	}

	@Override
	protected void execute(CommandEvent event) {
		if (determine() == 1) {
			event.reply("Chief says: this is it.");
		} else {
			event.reply("Chief says: this is not it.");
		}
	}
	
	private int determine() {
		Random random = new Random();
		int num = random.nextInt(2);
		return num;
	}
}
