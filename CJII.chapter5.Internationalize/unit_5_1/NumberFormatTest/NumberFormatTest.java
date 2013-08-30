package unit_5_1.NumberFormatTest;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class NumberFormatTest 
{
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run() 
			{
				JFrame frame = new NumberFormatFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}
