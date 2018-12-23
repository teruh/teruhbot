package co.teruh.bot.commands;

import java.util.Random;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class CommandChief extends Command {
	
	public CommandChief() {
		this.name = "is this it";
	}

	@Override
	protected void execute(CommandEvent event) {
	}
	
	private int determine() {
		Random random = new Random();
		int num = random.nextInt(1);
		return num;
	}
}
