package pongGame;

import java.awt.Graphics;

public class GirisEkrani extends Pencere{
	
	final static int genislik = 607;//pencerenin kendi kenarlarý
	final static int yukseklik = 533;
	
	static int  puan1=0;
	static int  puan2=0;
	
	static int secim;
	
	Raket raket =new Raket();
	
	public GirisEkrani() {
		super.setTitle("Pong");
		 setLocationRelativeTo(null);
	}
	

	public void paint(Graphics g) {
		raket.paint(g);
		add(raket);
	}

}
