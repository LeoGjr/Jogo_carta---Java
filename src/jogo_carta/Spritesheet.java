package jogo_carta;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Spritesheet {

	//852x384
	
	public static BufferedImage spritesheet;
	
	public Spritesheet(String path) {
		try {
			spritesheet = ImageIO.read(getClass().getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static BufferedImage getSprite(int x,int y,int width,int height) {
		return spritesheet.getSubimage(x, y, width,height);
	}
	
	
	
}
