package unit_10_3.notHelloWorldApplet;
/*
 * 由于该类在类包unit_10_3.notHelloWorldApplet下，
 * 所以要把对应applet的html文件放到unit_10_3的父文件里，
 * 修改html类地址，详见NotHelloWorldApplet.html
 */
import java.awt.EventQueue;

import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class NotHelloWorldApplet extends JApplet 
{
	public void init()
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				JLabel label = new JLabel("Not a hello,World applet",SwingConstants.CENTER);
				add(label);
			}
		});
	}
}
