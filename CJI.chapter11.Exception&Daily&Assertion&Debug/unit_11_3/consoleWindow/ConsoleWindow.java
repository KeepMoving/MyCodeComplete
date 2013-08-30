package unit_11_3.consoleWindow;
/*
 * 如果想要启用jconsole监视JVM资源，
 * 需要在Open Run Dialog-->arguments-->VM Arguments中
 * 添加-Dcom.sun.management.jmxremote，
 * 再在windows命令提示符中启动jconsole
 */
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class ConsoleWindow 
{
	public static void init()
	{
		JFrame frame = new JFrame();
		frame.setTitle("ConsoleWindow");
		final JTextArea output = new JTextArea();
		output.setEditable(false);
		frame.setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		frame.setLocation(DEFAULT_LEFT,DEFAULT_TOP);
		frame.setFocusableWindowState(false);
		frame.setVisible(true);
		
		PrintStream consoleStream = new PrintStream(new OutputStream()
		{
			@Override
			public void write(byte[] b, int off, int len) throws IOException 
			{
				output.append(new String(b,off,len));
			}

			@Override
			public void write(int b) throws IOException 
			{
			}
		});
		
		System.setOut(consoleStream);
		System.setErr(consoleStream);
	}
	
	public static final int DEFAULT_WIDTH = 330; 
	public static final int DEFAULT_HEIGHT = 330; 
	public static final int DEFAULT_LEFT = 330;
	public static final int DEFAULT_TOP = 330; 
}
