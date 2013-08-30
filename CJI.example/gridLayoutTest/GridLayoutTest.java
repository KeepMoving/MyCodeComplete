package gridLayoutTest;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class GridLayoutTest 
{
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run() 
			{
				GridLayoutFrame frame = new GridLayoutFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}
