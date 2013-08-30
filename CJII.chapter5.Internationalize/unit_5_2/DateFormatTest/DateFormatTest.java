package unit_5_2.DateFormatTest;

import java.awt.EventQueue;

import javax.swing.JFrame;

/*This program demonstrates formatting dates under various locales*/
public class DateFormatTest 
{
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run() 
			{
				JFrame frame = new DateFormatFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}
