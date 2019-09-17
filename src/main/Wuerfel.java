package main;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

public class Wuerfel extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static int Zahl;

	public static void main(String a[]) {

		Random rand = new Random();
		JFrame frame = new JFrame("Würfelmaster");
		frame.setSize(new Dimension(500, 500));
		frame.setLayout(null);
		JButton wuerfel = new JButton("Würfeln");
		
		wuerfel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Zahl = (rand.nextInt(6) + 1);
				
			}
		});
		wuerfel.setBounds(10, 300, 100, 100);
		wuerfel.setPreferredSize(new Dimension(200,80));
		frame.add(wuerfel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);


	}

	public void paint(Graphics g) {
		super.paint(g);
		g.drawString("Hier die erwürfelte Zahl" + Zahl, 50, 80);
		repaint();
	}

}