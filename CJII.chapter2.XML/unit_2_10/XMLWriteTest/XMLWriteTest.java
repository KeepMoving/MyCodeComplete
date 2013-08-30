package unit_2_10.XMLWriteTest;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class XMLWriteTest 
{
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run() 
			{
				XMLWriteFrame frame = new XMLWriteFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}
