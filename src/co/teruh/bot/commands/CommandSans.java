package co.teruh.bot.commands;

import java.util.ArrayList;

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
		String text = eventText.substring(eventText.indexOf("t.sans") + "t.sans".length()).toLowerCase();
		//Loop through ALL of the given text-
		String[] words = text.split(" ");
		ArrayList<String> lines = new ArrayList<String>();
		String current = "";
		for(String word:words) {
			if(current.length()+word.length()+1>=30) {
				lines.add(current);
				current = "";
			}
			current+=word+" ";
			if(word.equals(words[words.length-1])) {
				lines.add(current);
				current = "";
			}
		}
		

		try {
			new UTTextbox(578, 152, text, lines);
		} catch (IOException e) {
			e.printStackTrace();
		}

		image = new File("./res/textbox.png");
		event.reply(image, "textbox.png");
	}
	

}
