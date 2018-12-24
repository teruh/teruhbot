package co.teruh.bot.commands;

import java.sql.*;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import co.teruh.bot.main.Database;

public class CommandCurrencyEnroll extends Command {

	private Connection connection;
	private PreparedStatement users;
	private ResultSet userList;

	public CommandCurrencyEnroll(Database db) {
		this.name = "bogpillme";

		connection = db.getConnection();
	}

	@Override
	protected void execute(CommandEvent event) {
		try {
			if (!(isExistingUser(event.getAuthor().getId()))) {
				addUser(event.getAuthor().getId());
				event.reply("You've been bog pilled. Adding to database...");
			} else {
				event.reply("You have already been bog pilled!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private boolean isExistingUser(String userID) throws SQLException {
		final String sql = "SELECT discord_user_id FROM worth WHERE discord_user_id = ?";
		try {
			users = connection.prepareStatement(sql);
			users.setString(1, userID);
			userList = users.executeQuery();
			if (userList.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			users.close();
		}

		return false;
	}

	private void addUser(String userID) throws SQLException {
		final String sql = "INSERT INTO worth (discord_user_id, tokens) VALUES (?, 0)";
		users = connection.prepareStatement(sql);
		users.setString(1, userID);
		users.execute();
	}
}
