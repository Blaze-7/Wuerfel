package main;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.Timer;

public class Main extends Frame{
  private static final long serialVersionUID = 1L;
  static int ergZahl;
  static int rZahl;
  static Random rand = new Random();
  
  public Main(){
    setSize( 500, 500 );
    setLayout(null);
    addWindowListener( new WindowAdapter() {
      @Override
      public void windowClosing ( WindowEvent e ) { System.exit( 0 ); }
    } );
    
  }

  
  public static void main( String[] args ){
	  Main m = new Main();
	  JButton wuerfel = new JButton("Würfeln");

	    
	    wuerfel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rZahl = rand.nextInt(6) + 1;
				
				Timer timer = new Timer(220,
						new java.awt.event.ActionListener() {
							private int count = 10;

							@Override
							public void actionPerformed(
									java.awt.event.ActionEvent e) {
								if (count <= 0) {
									ergZahl = rZahl;
									m.repaint();
									((Timer) e.getSource()).stop();
								} else {
									Random dot = new Random();
									ergZahl = 1 + dot.nextInt(6);
									m.repaint();
									count--;
								}
							}
						});

				timer.start();

				ergZahl = rZahl;
				m.repaint();
			}
		});
		wuerfel.setBounds(170, 415, 100, 50);
		wuerfel.setPreferredSize(new Dimension(200,80));
		m.add(wuerfel);
    m.setVisible( true );
  }
  @Override
  public void paint( Graphics g ){
	super.paint(g);
	g.drawRect(100, 50, 300, 300);
	g.fillRect(100, 50, 300, 300);
	g.drawString("Hier die erwürfelte Zahl " + ergZahl,150,400);
	drawCube(g,ergZahl);
  }
  
  public void drawCube(Graphics g, int zahl){
	  switch(zahl){
		case 1:
			
			g.setColor(Color.WHITE);
			g.fillOval(220,170,50,50);//MItte
			break;
		
		case 2:
			g.setColor(Color.WHITE);
			g.fillOval(310, 75, 50, 50);//Oben Rechts
			g.fillOval(130, 265, 50, 50);//Unten Links
		break;
		
		case 3:
			g.setColor(Color.WHITE);
			g.fillOval(310, 75, 50, 50);//Oben Rechts
			g.fillOval(130, 265, 50, 50);//Unten Links
			g.fillOval(220,170,50,50);//Mitte
		break;
		case 4:
			g.setColor(Color.WHITE);
			g.fillOval(310, 75, 50, 50);//Oben Rechts
			g.fillOval(310, 265, 50, 50);//Unten Rechts
			
			g.fillOval(130, 75, 50, 50);//Oben Links
			g.fillOval(130, 265, 50, 50);//Unten Links
			break;
		case 5:
			g.setColor(Color.WHITE);
			g.fillOval(310, 75, 50, 50);//Oben Rechts
			g.fillOval(310, 265, 50, 50);//Unten Rechts
			g.fillOval(220,170,50,50);//Mitte
			g.fillOval(130, 75, 50, 50);//Oben Links
			g.fillOval(130, 265, 50, 50);//Unten Links
		break;
		
		case 6:
			g.setColor(Color.WHITE);
			g.fillOval(310, 75, 50, 50);//Oben Rechts
			g.fillOval(310, 265, 50, 50);//Unten Rechts
			g.fillOval(310,170,50,50);//Mitte Rechts
			
			
			g.fillOval(130, 75, 50, 50);//Oben Links
			g.fillOval(130, 265, 50, 50);//Unten Links
			g.fillOval(130,170,50,50);//Mitte Links
		break;
		}
  }
  

}
