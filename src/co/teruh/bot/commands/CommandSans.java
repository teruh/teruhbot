package co.teruh.bot.commands;

import java.io.File;
import java.io.IOException;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import co.teruh.bot.utils.UTTextbox;
import net.dv8tion.jda.core.entities.Message;

public class CommandSans extends Command {

	private File image;

	public CommandSans() {
		this.name = "sans";
	}

	@Override
	protected void execute(CommandEvent event) {
		Message eventMsg = event.getMessage();
		String eventText = eventMsg.getContentDisplay();
		String text = eventText.substring(eventText.indexOf("t.sans") + "t.sans".length());

		try {
			new UTTextbox(578, 152, text);
		} catch (IOException e) {
			e.printStackTrace();
		}

		image = new File("./res/textbox.png");
		event.reply(image, "textbox.png");
	}

}
