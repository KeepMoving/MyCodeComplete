package unit_4_3.QueryDB;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class QueryDB 
{
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				JFrame frame = new QueryDBFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}
