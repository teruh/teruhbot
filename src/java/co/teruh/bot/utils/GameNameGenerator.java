package co.teruh.bot.utils;

import java.util.Random;

public class GameNameGenerator {

	private static Random random;

	private static String[] gameName = { "with 18 cowboys", "with 28 U.S. Marines", "with Noggin Clontith",
			"Fallout 76", "yer ma", "bog pills", "Melee, with Grug" };

	public static String selectName() {
		random = new Random();
		int num = random.nextInt(gameName.length);
		return gameName[num];
	}

}
