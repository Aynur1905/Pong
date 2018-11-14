package pongGame;

import javax.swing.JFrame;

public class Pencere extends  JFrame{
	public Pencere() {
			
			setSize(GirisEkrani.genislik,GirisEkrani.yukseklik);
			setVisible(true);
			setResizable(false);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
