package pongGame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JWindow;

public class SecimEkrani extends JWindow {
	
	JButton button1;
	JButton button2;
	JButton exitButton;
	GirisEkrani ge;
	
	public SecimEkrani() {
		setSize(500, 300);
        setLocationRelativeTo(null);
        setBackground(Color.BLACK);
        
        Container container = getContentPane();
        container.setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBounds(175, 105, 150, 90);
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.BLACK);
        
        container.add(panel);
        
        button1=new JButton("Tek oyunculu");
		button1.addActionListener(e->button1Click());
		button1.setForeground(Color.WHITE);
		button1.setBackground(Color.BLACK);
		button1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(button1,BorderLayout.NORTH);
		
		button2=new JButton("Ýki oyunculu");
		button2.addActionListener(e->button2Click());
		button2.setForeground(Color.WHITE);
		button2.setBackground(Color.BLACK);
		button2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(button2,BorderLayout.CENTER);

		exitButton=new JButton("Çýkýþ");
		exitButton.addActionListener(e->exitButtonClick());
		exitButton.setForeground(Color.WHITE);
		exitButton.setBackground(Color.BLACK);
		exitButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(exitButton,BorderLayout.SOUTH);
		
		container.setBackground(Color.BLACK);
		
		setVisible(true);
		setFocusable(true);
	}
	public void button1Click(){
		GirisEkrani.secim=1;
		ge=new GirisEkrani();
		setVisible(false);
		System.out.println("Tek oyunculu");
	}
    public void button2Click(){
    	GirisEkrani.secim=2;
    	ge=new GirisEkrani();
    	setVisible(false);
    	System.out.println("Ýki oyunculu");
	}
    public void exitButtonClick(){
		System.exit(0);		
    }
 
}
