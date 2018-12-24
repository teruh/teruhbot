package co.teruh.bot.utils;

import java.util.ArrayList;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import co.teruh.bot.main.Teruhbot;

public class UTTextbox {

	private final int IMG_WIDTH; // Width of the image
	private final int IMG_HEIGHT; // Height of the image
	private final String IMG_TEXT; // Text to be drawn on the image

	private BufferedImage image; // Image container for entire image
	private BufferedImage sprite; // Image container for character sprite
	private Graphics2D graphics; // Used for rendering on bufferedimage
	private File file; // Used for image IO
	private Font font; // Used for image text

	/**
	 * Create a new image
	 * 
	 * @param width  width of the image
	 * @param height height of the image
	 * @param text   image text
	 * @param lines  array of text to display on photo
	 * @throws IOException
	 * @throws FontFormatException 
	 */
	public UTTextbox(int width, int height, String text, String spriteName, ArrayList<String> lines) throws IOException, FontFormatException {
		IMG_WIDTH = width;
		IMG_HEIGHT = height;
		IMG_TEXT = text;

		image = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, BufferedImage.TYPE_INT_RGB);
		sprite = ImageIO.read(Teruhbot.class.getResourceAsStream("/img/" + spriteName + ".png"));
		graphics = image.createGraphics();
		font = Font.createFont(Font.TRUETYPE_FONT, Teruhbot.class.getResourceAsStream("/font/" + spriteName + ".ttf")).deriveFont(Font.PLAIN, 30);

		// Create a new image with passed text, and write it to a file
		saveImage(createImage(lines));
	}

	/**
	 * Create an Undertale-style dialogue textbox
	 * 
	 * @param lines lines of text in textbox
	 * @return BufferedImage result
	 */
	private BufferedImage createImage(ArrayList<String> lines) {
		// Draw white border
		graphics.setColor(Color.white);
		graphics.fillRect(0, 0, IMG_WIDTH, IMG_HEIGHT);

		// Draw inner black rectangle
		graphics.setColor(Color.black);
		graphics.fillRect(5, 5, (IMG_WIDTH - 10), (IMG_HEIGHT - 10));

		// Draw text
		graphics.setColor(Color.white);
		graphics.setFont(font);
		graphics.drawString("*" + lines.get(0), 140, 50);
		for (int i = 1; i < lines.size(); i++) {
			graphics.drawString(lines.get(i), 175, (i * 40) + 50);
		}

		// Draw character sprite
		graphics.drawImage(sprite, 30, 40, (IMG_WIDTH / 8), (IMG_WIDTH / 8), null);

		graphics.dispose();
		return image;
	}

	/**
	 * Write created BufferedImage to file
	 * 
	 * @param result
	 * @throws IOException
	 */
	private void saveImage(BufferedImage result) throws IOException {
		file = new File("textbox.png");
		ImageIO.write(result, "png", file);
	}

}
