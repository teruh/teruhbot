package co.teruh.bot.commands;

import java.sql.*;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import co.teruh.bot.main.Database;

public class CommandCurrencyWorth extends Command {

	private Connection connection;
	private PreparedStatement tokenValue;
	private ResultSet resultSet;

	public CommandCurrencyWorth(Database db) {
		this.name = "bogpills";

		connection = db.getConnection();
	}

	@Override
	protected void execute(CommandEvent event) {
		try {
			int numTokens = getTokens(event.getAuthor().getId());
			if (numTokens < 0) {
				event.reply("You are not bog pilled!");
			} else {
				event.reply("You have " + numTokens + " bog pills!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private int getTokens(String userID) throws SQLException {
		int tokens = -1;
		final String sql = "SELECT tokens FROM worth WHERE discord_user_id = ?";

		try {
			tokenValue = connection.prepareStatement(sql);
			tokenValue.setString(1, userID);
			resultSet = tokenValue.executeQuery();
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
