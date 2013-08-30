package unit_10_8.preferencesTest;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.prefs.BackingStoreException;
import java.util.prefs.InvalidPreferencesFormatException;
import java.util.prefs.Preferences;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class PreferencesTest 
{
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run() 
			{
				PreferencesFrame frame = new PreferencesFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

class PreferencesFrame extends JFrame
{
	public PreferencesFrame()
	{
		Preferences root = Preferences.userRoot(); //注意这里用的是userRoot()
		final Preferences node = root.node("/com/horstman/corejava"); //在Windows平台中，用户参数项在注册表中的根节点是
																	  //HKEY_CURRENT_USER\Software\JavaSoft\Prefs
		int left = node.getInt("left", 0);
		int top = node.getInt("top", 0);
		int width = node.getInt("width", DEFAULT_WIDTH);
		int height = node.getInt("height", DEFAULT_HEIGHT);
		setBounds(left,top,width,height);
		
		//if no title given,ask user
		String title = node.get("title", "");
		if(title.equals(""))
			title = JOptionPane.showInputDialog("Please supply a frame title:");
		if(title == null)
			title = "";
		setTitle(title);
		
		//set up file chooser that shows XML files
		final JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File("."));
		
		//accept all files ending with .xml
		chooser.setFileFilter(new javax.swing.filechooser.FileFilter()
		{

			@Override
			public boolean accept(File f) 
			{
				return f.getName().toLowerCase().endsWith(".xml")||f.isDirectory();
			}

			@Override
			public String getDescription() 
			{
				return "XML files";
			}
			
		});
		
		//set up menus
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu menu = new JMenu("File");
		menuBar.add(menu);
		
		JMenuItem exportItem = new JMenuItem("Export preferences");
		menu.add(exportItem);
		exportItem.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent event) {
				if(chooser.showSaveDialog(PreferencesFrame.this) == JFileChooser.APPROVE_OPTION)
				{
					try {
						FileOutputStream out = new FileOutputStream(chooser.getSelectedFile());
						node.exportSubtree(out);
						out.close();
					} catch (FileNotFoundException fnfe) {
						// TODO Auto-generated catch block
						System.out.println("FileNotFoundException:" + fnfe.getMessage());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (BackingStoreException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		
		JMenuItem importItem = new JMenuItem("Import preferences");
		menu.add(importItem);
		importItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event) 
			{
				if(chooser.showOpenDialog(PreferencesFrame.this) == JFileChooser.APPROVE_OPTION)
				{
					try {
						InputStream in = new FileInputStream(chooser.getSelectedFile());
						Preferences.importPreferences(in);
						in.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvalidPreferencesFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		
		JMenuItem exitItem = new JMenuItem("Exit");
		menu.add(exitItem);
		exitItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				node.putInt("left", getX());
				node.putInt("top", getY());
				node.putInt("width", getWidth());
				node.putInt("height", getHeight());
				node.put("title", getTitle());
				System.exit(0);
			}
		});
	}
		
	public static final int DEFAULT_WIDTH = 300;
	public static final int DEFAULT_HEIGHT = 200;
}