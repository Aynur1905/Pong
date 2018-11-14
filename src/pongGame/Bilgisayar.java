package pongGame;

import java.awt.Color;
import java.awt.Graphics;

public class Bilgisayar implements Oyuncular {
	int y=(GirisEkrani.yukseklik/2)-10;
	int x=0;
	
	int raketYükseklik=70;
	int raketGenislik=20;
	
	private int hiz=0;
	
	public int getHiz() {
		return hiz;
	}

	public void setHiz(int hiz) {
		this.hiz = hiz;
	}

	public void paint(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, raketGenislik, raketYükseklik);

	}
	
	public void update() {	
		 if (y > 60 && y < GirisEkrani.yukseklik - raketYükseklik- 29) {
			 if(Top.y< y) {
				 y+=-2;
			 }
			 else if(Top.y>y) {
				 y+=2;
			 }
		
		 }
		 else if (y == 60)
	    	    y+=2; 
		 else if (y == GirisEkrani.yukseklik-raketYükseklik-29)
	            y-=2;
		
	}

}
