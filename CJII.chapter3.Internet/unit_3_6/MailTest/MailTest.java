package unit_3_6.MailTest;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class MailTest 
{
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run() 
			{
				JFrame frame = new MailTestFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}
