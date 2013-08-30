package unit_2_2.GridBagTest;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class GridBagTest 
{
	public static void main(final String[] args) 
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run() 
			{
//				String filename = args.length == 0?"fontdialog.xml":args[0];
				String filename = "fontdialog.xml";
				JFrame frame = new FontFrame(filename);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}
