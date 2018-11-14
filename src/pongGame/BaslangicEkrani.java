package pongGame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class BaslangicEkrani extends JWindow {
	
	SecimEkrani se;
	
	static JProgressBar progressBar = new JProgressBar();
	
    static int sayi;
    static Timer timer1;
    
    public BaslangicEkrani() {
    	Container container = getContentPane();
        container.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(10, 10, 480, 260);
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.BLACK);
        container.add(panel);

        JLabel labelTitle = new JLabel("2D PONG GAME ", JLabel.CENTER);
        labelTitle.setFont(new Font("Verdana", Font.BOLD, 25));
        labelTitle.setForeground(Color.WHITE);
        labelTitle.setBounds(0, 0, 280, 30);
        panel.add(labelTitle, BorderLayout.CENTER);
        
        JLabel labelDeveloper = new JLabel("Developed by AYNUR VEYSEL", JLabel.CENTER);
        labelDeveloper.setFont(new Font("Verdana", Font.BOLD, 14));
        labelDeveloper.setForeground(Color.WHITE);
        labelDeveloper.setBounds(0, 0, 280, 30);
        panel.add(labelDeveloper, BorderLayout.SOUTH);

        progressBar.setBounds(55, 180, 390, 15);
        progressBar.setBackground(Color.WHITE);
        progressBar.setStringPainted(true);
        container.add(progressBar);
        progressBarYüklenme();

        setSize(500, 300);
        setLocationRelativeTo(null);

        container.setBackground(Color.BLACK);

        final int dur = 6000;
        final Runnable kapatRunner = new Runnable()
        {
            public void run()
            {
                setVisible(false);
                se=new SecimEkrani();
                dispose();
            }
        };

        final Runnable bekleRunner = new Runnable()
        {
            public void run()
            {
                try
                {
                    Thread.sleep(dur);
                    timer1.stop();
                    SwingUtilities.invokeAndWait(kapatRunner);//Bir uygulama iþ parçacýðýnýn GUI'yi güncellemesi gerektiðinde bu yöntem kullanýlmalýdýr.
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        };
        setVisible(true);
        Thread splashThread = new Thread(bekleRunner, "SplashThread");
        splashThread.start();
    }
    
    public void progressBarYüklenme() {
        ActionListener al = new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	sayi++;
                progressBar.setValue(sayi);//progressBar'ýn deðerini deðiþtir
            }
        };
        timer1 = new Timer(50, al);
        timer1.start();//timerTask nesnesi kullansaydým ActionListener da yazdýklarýmý ayný þekilde timerTask ýn içide run methodunda yazmam gerekirdi
    }
	
	public static void main(String[] args) {
		new BaslangicEkrani();
	}

}
