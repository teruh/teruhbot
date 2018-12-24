package co.teruh.bot.commands;

import java.sql.*;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import co.teruh.bot.main.Database;

public class CommandCurrencyWorth extends Command {

	/**
	 * Used to connection to MySQL db
	 */
	private Connection connection;

	/**
	 * Used to query/modify db
	 */
	private PreparedStatement tokenValue;

	/**
	 * Used to handle results from db queries
	 */
	private ResultSet resultSet;

	/**
	 * Command information
	 * 
	 * @param db database instance
	 */
	public CommandCurrencyWorth(Database db) {
		this.name = "bogpills";

		connection = db.getConnection();
	}

	/**
	 * Check the number user's current in the db
	 */
	@Override
	protected void execute(CommandEvent event) {
		try {
			int numTokens = getTokens(event.getAuthor().getId());
			// If user have -1 tokens, their discord id does not exist
			if (numTokens < 0) {
				event.reply("You are not bog pilled!");
			} else {
				event.reply("You have " + numTokens + " bog pills!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Check how many tokens a user has
	 * 
	 * @param userID discord user id
	 * @return number of tokens corresponding to the user id
	 * @throws SQLException
	 */
	private int getTokens(String userID) throws SQLException {
		int tokens = -1; // number of tokens assigned to userid
		final String sql = "SELECT tokens FROM worth WHERE discord_user_id = ?";

		try {
			tokenValue = connection.prepareStatement(sql);
			tokenValue.setString(1, userID);
			resultSet = tokenValue.executeQuery();
			// Iterate through results, only one result should exist for the id
			while (resultSet.next()) {
				tokens = resultSet.getInt("tokens");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			tokenValue.close();
		}

		return tokens;
	}
}
