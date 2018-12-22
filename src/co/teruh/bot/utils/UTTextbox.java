package co.teruh.bot.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class UTTextbox {

	private final int IMG_WIDTH;
	private final int IMG_HEIGHT;
	private final String IMG_TEXT;
	
	private BufferedImage image;
	private BufferedImage sprite;
	private Graphics2D graphics;
	private File file;
	private Font font;
	
	public UTTextbox(int width, int height, String text) throws IOException {
		IMG_WIDTH = width;
		IMG_HEIGHT = height;
		IMG_TEXT = text;
		
		image = new BufferedImage(IMG_WIDTH, 
				IMG_HEIGHT, 
				BufferedImage.TYPE_INT_RGB);
		sprite = readImage("./res/sans.png");
		graphics = image.createGraphics();
		font = new Font("Comic Sans MS", Font.BOLD, 30);
		
		saveImage(createImage(text));
	}
	
	private BufferedImage createImage(String text) {
		// Draw image background
		graphics.setColor(Color.white);
		graphics.fillRect(0, 0, IMG_WIDTH, IMG_HEIGHT);
		graphics.setColor(Color.black);
		graphics.fillRect(5, 5, (IMG_WIDTH - 10), (IMG_HEIGHT - 10));
		
		// Draw text
		graphics.setColor(Color.white);
		graphics.setFont(font);
		graphics.drawString("* " + text, 140, 70);
		
		// Draw sprite
		graphics.drawImage(sprite, 30, 40, (IMG_WIDTH / 8), (IMG_WIDTH / 8), null);
		
		graphics.dispose();
		
		return image;
	}
	
	private BufferedImage readImage(String resPath) {
		BufferedImage img = null;
		
		try {
			img = ImageIO.read(new File(resPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return img;
	}
	
	private void saveImage(BufferedImage result) throws IOException {
		file = new File("./res/textbox.png");
		ImageIO.write(result, "png", file);
	}
	
}
