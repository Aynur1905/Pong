package pongGame;

import java.awt.Color;
import java.awt.Graphics;


public class Oyuncu implements Oyuncular {
	int y=(GirisEkrani.yukseklik/2)-10;
	int x=GirisEkrani.genislik-26;
	
	int raketYükseklik=70;
	int raketGenislik=20;
	
	private int hiz=0;
	
	private int up, down;
	
	public int getHiz() {
		return hiz;
	}

	public void setHiz(int hiz) {
		this.hiz = hiz;
	}
	
	public Oyuncu(int up, int down) {
		this.up=up;
		this.down=down;
	}

	public void paint(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, raketGenislik, raketYükseklik);

	}
	
	public void update() {
		 if (y > 60 && y < GirisEkrani.yukseklik - raketYükseklik- 29)
	            y += hiz;
		 else if (y == 60)
	    	    y+=2; 
		 else if (y == GirisEkrani.yukseklik-raketYükseklik-29)
	            y-=2;
	}
	public void pressed(int keyCode) {
	      if (keyCode == up)
	          hiz = -2;
	      else if (keyCode == down)
	           hiz = 2;
	}
	public void released(int keyCode) {
	      if (keyCode == up || keyCode == down)
	            hiz = 0;
	}
}
