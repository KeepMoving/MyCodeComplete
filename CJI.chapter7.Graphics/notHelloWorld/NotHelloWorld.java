package notHelloWorld;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class NotHelloWorld 
{
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				NotHelloWorldFrame frame = new NotHelloWorldFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

// A frame that contains a message panel
class NotHelloWorldFrame extends JFrame  //继承关系
{
	public NotHelloWorldFrame()
	{
		setTitle("NotHelloWorld");
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		
		NotHelloWorldPanel panel = new NotHelloWorldPanel(); //聚合关系
		add(panel);
	}
	
	public static final int DEFAULT_WIDTH = 800;
	public static final int DEFAULT_HEIGHT = 600;
}

//A panel that displays a message
class NotHelloWorldPanel extends JPanel
{
	public void paintComponent(Graphics g)
	{
		g.drawString("Not a Hello,world program", MESSAGE_X, MESSAGE_Y);
	}
	
	public static final int MESSAGE_X = 200;
	public static final int MESSAGE_Y = 200;
}

