package pongGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Raket extends JPanel implements ActionListener, KeyListener {
	
	Oyuncu oyuncu = new Oyuncu(KeyEvent.VK_UP, KeyEvent.VK_DOWN);
	Oyuncu2 oyuncu2;
	Bilgisayar bilgisayar;
	Top top=new Top();
	
	
	public Raket() {
		if(GirisEkrani.secim==1) {
			bilgisayar=new Bilgisayar();
			System.out.println("bilgisayar oluþturuldu");
		}else {
			oyuncu2 = new Oyuncu2(KeyEvent.VK_W, KeyEvent.VK_S);
			System.out.println("oyuncu oluþturuldu");
		}
		
		Timer timer=new Timer(15,this);
		timer.start();
		
		addKeyListener(this);
		setFocusable(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		update();
		repaint();	
	}
	
	public void update() {
		oyuncu.update();
		
		if(GirisEkrani.secim==1){
			bilgisayar.update();
			top.carpismaBilgisayar(bilgisayar);
		}
		else {
			oyuncu2.update();
			top.carpismaRakip(oyuncu2);
		}
		top.update();
		top.carpisma(oyuncu);
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0,GirisEkrani.genislik, GirisEkrani.yukseklik);
		
		g.setColor(Color.WHITE);
		g.drawLine(0, 60, GirisEkrani.genislik, 60);
		g.drawLine(GirisEkrani.genislik/2, 60, GirisEkrani.genislik/2 , GirisEkrani.yukseklik);
		g.drawOval(GirisEkrani.genislik/2-30, GirisEkrani.yukseklik/2, 60, 60);//genislik/2-30  ->  60/2=30
		
		oyuncu.paint(g);
		if(GirisEkrani.secim==1){
			bilgisayar.paint(g);
		}else {
			oyuncu2.paint(g);
		}
		top.paint(g);
		
		g.setColor(Color.WHITE);
		g.setFont(new Font("MV Boli", Font.PLAIN, 25));
		g.drawString(Integer.toString(GirisEkrani.puan2), GirisEkrani.genislik/2-30, 30);
		g.drawString(":", GirisEkrani.genislik/2, 30);
		g.drawString(Integer.toString(GirisEkrani.puan1), GirisEkrani.genislik/2+30, 30);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		oyuncu.pressed(e.getKeyCode());
		if(GirisEkrani.secim==2){
			oyuncu2.pressed(e.getKeyCode());
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		oyuncu.released(e.getKeyCode());
		if(GirisEkrani.secim==2){
			oyuncu2.released(e.getKeyCode());
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}
}
