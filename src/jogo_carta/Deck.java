package jogo_carta;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Deck {

	public List<Carta> cartas = new ArrayList<Carta>();
	
	public int lastPosX = 0;
	public int lastPosY = 120;
	
	public Deck() {
		for(int i = 0; i < 10; i++) {
			Carta carta = new Carta(0,10);
			carta.sprite = Spritesheet.getSprite(i*71, 0, 71, 95);
			carta.score = i+1;
			cartas.add(carta);
		}
		
		Collections.shuffle(cartas);
	
		/*
		Collections.sort(cartas, new Comparator<Carta>() {
		    @Override
		    public int compare(Carta z1, Carta z2) {
		        if (z1.x > z2.x)
		            return 1;
		        if (z1.x < z2.x)
		            return -1;
		        return 0;
		    }
		});
		*/
		
		for(int i = 0; i < 10; i++) {
			Carta carta = cartas.get(i);
			carta.x = carta.x + (i*30);
		}
		
	}

	public void checkCardPressed() {
		if(Main.pressed) {
			Main.pressed = false;
			for(int i = cartas.size() - 1; i >= 0; i--) {
				Carta tempCarta = cartas.get(i);
				if(Main.mx > tempCarta.x && Main.mx < tempCarta.x + 72) {
					if(Main.my > tempCarta.y && Main.my < tempCarta.x + 95) {
						//Estamos clicando numa carta mais alta!
						if(tempCarta.flip == false) {
						tempCarta.flip = true;
						tempCarta.x = lastPosX;
						lastPosX+=70;
						tempCarta.y = lastPosY;
						Main.score+= (tempCarta.score);
						//System.out.println("Virou");
						return;
						}
					}
				}
			}
		}
	}


	public void tick() {
		for(int i = 0; i < cartas.size(); i++) {
			cartas.get(i).tick();
		}
		
		checkCardPressed();
	}
	
	public void render(Graphics g) {
		for(int i = 0; i < cartas.size(); i++) {
			cartas.get(i).render(g);
		}
	}
	
}
