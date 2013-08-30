package unit_9_15.dialogTest;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class DialogTest 
{
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				DialogFrame frame = new DialogFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

class DialogFrame extends JFrame
{
	public DialogFrame()
	{
		setTitle("DialogTest");
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		
		JMenuItem aboutItem = new JMenuItem("About");
		aboutItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				if(dialog == null)
					dialog = new AboutDialog(DialogFrame.this);
				dialog.setVisible(true);
			}
		});
		fileMenu.add(aboutItem);
		
		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				System.exit(0);
			}
		});
		fileMenu.add(exitItem);
	}
	
	public static final int DEFAULT_WIDTH = 300;
	public static final int DEFAULT_HEIGHT = 200;
	
	private AboutDialog dialog;
}

class AboutDialog extends JDialog
{
	public AboutDialog(JFrame owner)
	{
		super(owner,"About DialogTest",true);
		
		add(new JLabel("<html><h1><i>Core java</i></h1><hr>By Cay Horstmann and Gray Cornell</html>"), //java swing可以直接显示HTML
			BorderLayout.CENTER);
		
		JButton ok = new JButton("Ok");
		ok.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				setVisible(false);
			}
		});
		
		JPanel panel = new JPanel();
		panel.add(ok);
		add(panel,BorderLayout.SOUTH);
		
		setSize(250,150);
	}
}