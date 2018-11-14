package pongGame;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JOptionPane;

public class Top {
	int boyut=10;
	
	int x=(GirisEkrani.genislik-boyut)/2;
	static int y=(GirisEkrani.yukseklik-50)/2;
	
	int xhiz=2;
	int yhiz=2;
	
	public void paint(Graphics g) {
    	g.setColor(Color.GREEN);
    	g.fillOval(x, y,boyut,boyut);
	}
	
	public void update() {
		x+=xhiz;
		y+=yhiz;
		
		if (x<15) {
			GirisEkrani.puan2++;
			if(GirisEkrani.puan2==10) {
				JOptionPane.showMessageDialog(null, "1.Oyuncu: "+ GirisEkrani.puan2 + "\n2.Oyuncu:" + GirisEkrani.puan1 + "\n1.Oyuncu Kazandý");
				System.exit(0);
			}
			x=(GirisEkrani.genislik-boyut)/2;
			y=(GirisEkrani.yukseklik-50)/2;
			System.out.println("puan2: " + GirisEkrani.puan2);
			
			xhiz=-xhiz;
		}
		else if(x+boyut>GirisEkrani.genislik-15) {
			GirisEkrani.puan1++;
			if(GirisEkrani.puan1==10) {
				JOptionPane.showMessageDialog(null, "1.Oyuncu: "+ GirisEkrani.puan2 + "\n2.Oyuncu:" + GirisEkrani.puan1 +"\n2.Oyuncu Kazandý");
				System.exit(0);
			}
			x=(GirisEkrani.genislik-boyut)/2;
			y=(GirisEkrani.yukseklik-50)/2;
			
			System.out.println("puan: " + GirisEkrani.puan1);
			xhiz=-xhiz;
		}
		if (y<60) {
			yhiz=-yhiz;
		}
		else if(y+boyut+29>=GirisEkrani.yukseklik) {
			yhiz=-yhiz;
		}
	}
	
	 public void carpisma(Oyuncu oyuncu) {
		 if (x+boyut>oyuncu.x){ 
	    		if(y+boyut>=oyuncu.y && y <= oyuncu.y+oyuncu.raketYükseklik) {
	    			xhiz=-xhiz;
	    			System.out.println("hýz deðiþti");
	        	}
	    		
	    	}
	    }
	 
	 	public void carpismaRakip(Oyuncu2 oyuncu2) {
			 if (x<oyuncu2.x+oyuncu2.raketGenislik){ 
		    		if(y+boyut>=oyuncu2.y && y <= oyuncu2.y+oyuncu2.raketYükseklik) {
		    			xhiz=-xhiz;
		    			System.out.println("2 hýz deðiþti");
		        	}
		    	}
	 	}
	 
	 	public void carpismaBilgisayar(Bilgisayar bilgisayar) {
		   if (x<bilgisayar.x+bilgisayar.raketGenislik){ 
	    		if(y+boyut>=bilgisayar.y && y <= bilgisayar.y+bilgisayar.raketYükseklik) {
	    			xhiz=-xhiz;
	    			System.out.println("2 hýz deðiþti");
	        	}
	    	}
	 	}
}
