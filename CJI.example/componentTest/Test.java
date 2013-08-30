package componentTest;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class Test 
{
	public static void main(String[] args) 
	{
	   JFrame frame=new JFrame();
		   
	   final int FRAME_WIDTH=300;
	   final int FRAME_HEIGHT=300;
	   frame.setSize(FRAME_WIDTH,FRAME_HEIGHT);
	   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   
	   CircleComponent component=new CircleComponent();
	   
	   frame.setContentPane(component);
	   frame.setVisible(true);
	}
}

class CircleComponent extends JComponent 
{
	 public  void paint(Graphics g)
	 {
		  Graphics2D g2=(Graphics2D) g;
		  Ellipse2D.Double ellipse=new Ellipse2D.Double(100,100,100,100);
		  g2.setColor(Color.PINK);
		  g2.draw(ellipse);
		  g2.fill(ellipse);
		  Ellipse2D.Double ellipse2=new Ellipse2D.Double(150,150,50,50);
		  g2.setColor(Color.WHITE);
		  g2.draw(ellipse2);
		  g2.fill(ellipse2);
	 }
}

