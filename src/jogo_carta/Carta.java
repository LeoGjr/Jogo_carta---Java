package jogo_carta;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Carta {

	public BufferedImage sprite;
	
	public static BufferedImage cartaVirada = Spritesheet.getSprite(852, 384, 70,97);
	
	public int type = 0;
	public int score = 0;
	
	public int x,y;
	
	public boolean flip = false;
	
	public Carta(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		if(flip == false) {
			g.drawImage(cartaVirada, x,y,72,95,null);
		}else {
			g.drawImage(sprite, x,y,72,95,null);
		}
	}
}
