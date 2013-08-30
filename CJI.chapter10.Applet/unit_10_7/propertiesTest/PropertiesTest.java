package unit_10_7.propertiesTest;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class PropertiesTest 
{
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				PropertiesFrame frame = new PropertiesFrame();
				frame.setVisible(true);
			}
		});
	}
}

class PropertiesFrame extends JFrame
{
	public PropertiesFrame()
	{
		String userDir = System.getProperty("user.home"); //获取当前用户主文件目录地址
		File propertiesDir = new File(userDir,".corejava"); //把属性文件存储在C:\Users\KeepMoving\.corejava\program.properties
		if(!propertiesDir.exists())propertiesDir.mkdir(); //mkdir()在已经存在的目录中创建创建文件夹
		propertiesFile = new File(propertiesDir,"program.properties");
		
		Properties defaultSettings = new Properties(); //设置默认属性
		defaultSettings.put("left", "0");
		defaultSettings.put("top","0");
		defaultSettings.put("width","" + DEFAULT_WIDTH);
		defaultSettings.put("height","" + DEFAULT_HEIGHT);
		defaultSettings.put("title", "");
		
		settings = new Properties(defaultSettings);
		
		if(propertiesFile.exists())
		{
			try {
				FileInputStream in = new FileInputStream(propertiesFile);
				settings.load(in);
			} catch (FileNotFoundException fnfe) {
				System.out.println("FileNotFoundException:" + fnfe.getMessage());
			} catch (IOException ioe) {
				System.out.println("IOException:" + ioe.getMessage());
			}
		}
		
		int left = Integer.parseInt((settings.getProperty("left")!=null)?settings.getProperty("left"):"0");
		int top = Integer.parseInt((settings.getProperty("top")!=null)?settings.getProperty("top"):"0");
		int width = Integer.parseInt((settings.getProperty("width")!=null)?settings.getProperty("width"):"300");
		int height = Integer.parseInt((settings.getProperty("height")!=null)?settings.getProperty("height"):"200");
		setBounds(left,top,width,height);
		
		String title = settings.getProperty("title");
		if(title.equals(""))title = JOptionPane.showInputDialog("Please supply a frame title:");
		if(title == null) title = "";
		setTitle(title);
		
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent event)
			{
				settings.put("left", "" + getX());
				settings.put("top", "" + getY());
				settings.put("width", "" + getWidth());
				settings.put("height", "" + getHeight());
				settings.put("title", "" + getTitle());

				try {
					FileOutputStream out = new FileOutputStream(propertiesFile);
					settings.store(out, "Program Properties");
				} catch (FileNotFoundException fnfe) {
					System.out.println("FileNotFoundException:" + fnfe.getMessage());
				} catch (IOException ioe) {
					System.out.println("IOException:" + ioe.getMessage());
				}
				System.exit(0);
			}
		});
	}
	
	private File propertiesFile;
	private Properties settings;
	public static final int DEFAULT_WIDTH = 400;
	public static final int DEFAULT_HEIGHT = 300;
}