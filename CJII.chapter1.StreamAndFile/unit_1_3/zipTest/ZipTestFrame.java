package unit_1_3.zipTest;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.jdesktop.swingworker.SwingWorker;

public class ZipTestFrame extends JFrame 
{
	public ZipTestFrame()
	{
		setTitle("ZipTest");
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("File");
		
		JMenuItem openItem = new JMenuItem("Open");
		menu.add(openItem);
		openItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new File("."));
				int r = chooser.showOpenDialog(ZipTestFrame.this);
				if(r == JFileChooser.APPROVE_OPTION)
				{
					zipname = chooser.getSelectedFile().getPath();
					fileCombo.removeAllItems();
					scanZipFile();
				}
			}
		});
		
		JMenuItem exitItem = new JMenuItem("Exit");
		menu.add(exitItem);
		exitItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				System.exit(0);
			}
		});
		
		menuBar.add(menu);
		setJMenuBar(menuBar);
		
		fileText = new JTextArea();
		fileCombo = new JComboBox();
		fileCombo.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				loadZipFile((String)fileCombo.getSelectedItem());
			}
		});
		
		add(fileCombo,BorderLayout.SOUTH);
		add(new JScrollPane(fileText),BorderLayout.CENTER);
	}
	
	public void scanZipFile()
	{
		new SwingWorker<Void ,String>()
		{
			protected Void doInBackground() throws Exception
			{
				ZipInputStream zin = new ZipInputStream(new FileInputStream(zipname));
				ZipEntry entry;
				while((entry = zin.getNextEntry())!= null)
				{
					publish(entry.getName());
					zin.closeEntry();
				}
				zin.close();
				return null;
			}
			
			protected void process(List<String> names)
			{
				for(String name:names)
					fileCombo.addItem(name);
			}
		}.execute();
	}
	
	public void loadZipFile(final String name)
	{
		fileCombo.setEditable(false);
		fileText.setText("");
		new SwingWorker<Void,String>()
		{
			protected Void doInBackground() throws Exception
			{
				try {
					ZipInputStream zin = new ZipInputStream(new FileInputStream(zipname));
					ZipEntry entry;
					
					while((entry = zin.getNextEntry())!= null)
					{
						if(entry.getName().equals(name))
						{
							Scanner in = new Scanner(zin);
							while(in.hasNextLine())
							{
								fileText.append(in.nextLine());
								fileText.append("\n");
							}
						}
						zin.closeEntry();
					}
					zin.close();
				} catch (RuntimeException e) {
					// TODO Auto-generated catch block
					System.out.println("RuntimeException:" + e.getMessage());
					e.printStackTrace();
				}
				
				return null;
			}
			
			protected void done()
			{
				fileCombo.setEnabled(true);
			}
		}.execute();
	}
	
	private static final long serialVersionUID = -6355287031047173767L;
	public static final int DEFAULT_WIDTH = 400;
	public static final int DEFAULT_HEIGHT = 300;
	private JComboBox fileCombo;
	private JTextArea fileText;
	private String zipname;
}
