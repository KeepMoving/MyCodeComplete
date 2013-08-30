package unit_3_5.InterruptibleSocketTest;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class InterruptibleSocketTest 
{
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run() 
			{
				JFrame frame = new InterruptibleSocketFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}
