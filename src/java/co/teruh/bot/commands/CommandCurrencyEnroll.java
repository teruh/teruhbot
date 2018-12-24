package co.teruh.bot.commands;

import java.sql.*;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import co.teruh.bot.main.Database;

public class CommandCurrencyEnroll extends Command {

	/**
	 * Used to connection to MySQL db
	 */
	private Connection connection;

	/**
	 * Used to query/modify db
	 */
	private PreparedStatement users;

	/**
	 * Used to handle results from db queries
	 */
	private ResultSet userList;

	/**
	 * Command information
	 * 
	 * @param db database instance
	 */
	public CommandCurrencyEnroll(Database db) {
		this.name = "bogpillme";

		connection = db.getConnection();
	}

	/**
	 * Check user's status in the db. If they are not already in it, add them
	 */
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

	/**
	 * Check if Discord ID exists in db
	 * 
	 * @param userID discord user id
	 * @return if user exists in db
	 * @throws SQLException
	 */
	private boolean isExistingUser(String userID) throws SQLException {
		final String sql = "SELECT discord_user_id FROM worth WHERE discord_user_id = ?";
		try {
			users = connection.prepareStatement(sql);
			users.setString(1, userID);
			userList = users.executeQuery();
			// Return true if id exists in system
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

	/**
	 * Add user to db
	 * 
	 * @param userID discord user id
	 * @throws SQLException
	 */
	private void addUser(String userID) throws SQLException {
		final String sql = "INSERT INTO worth (discord_user_id, tokens) VALUES (?, 0)";
		users = connection.prepareStatement(sql);
		users.setString(1, userID);
		users.execute();
	}
}
