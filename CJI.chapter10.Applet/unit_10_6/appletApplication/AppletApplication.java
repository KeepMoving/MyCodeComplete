package unit_10_6.appletApplication;

import java.awt.EventQueue;

import javax.swing.JFrame;

import unit_10_3.notHelloWorldApplet.NotHelloWorldApplet;
import unit_10_5.appletFrame.AppletFrame;

public class AppletApplication extends NotHelloWorldApplet //类AppletApplication继承NotHelloWorldApplet
{
	//调用NotHelloWorldApplet的Applet
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				AppletFrame frame = new AppletFrame(new NotHelloWorldApplet());
				frame.setTitle("NotHelloWorldApplet");
				frame.setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
	
	public static final int DEFAULT_WIDTH = 200;
	public static final int DEFAULT_HEIGHT = 200;
}
