package unit_9_8.menuTest;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

public class MenuTest 
{
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				MenuFrame frame = new MenuFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

class MenuFrame extends JFrame
{
	public MenuFrame()
	{
		setTitle("MenuTest");
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		
		JMenu fileMenu = new JMenu("File"); //添加File按钮
		fileMenu.add(new TestAction("New"));
		
		JMenuItem openItem = fileMenu.add(new TestAction("Open"));//添加open按钮
		openItem.setAccelerator(KeyStroke.getKeyStroke("ctrl O"));//添加键盘映射快捷键
		
		fileMenu.addSeparator(); //在open选项下添加隔线
		
		saveAction = new TestAction("Save"); //新建save按钮
		JMenuItem saveItem = fileMenu.add(saveAction);//添加save按钮
		saveItem.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));//添加键盘映射快捷键，而不需要打开按钮
		
		saveAsAction = new TestAction("Save As");//新建另存为按钮
		fileMenu.add(saveAsAction);
		fileMenu.addSeparator();
		
		fileMenu.add(new AbstractAction("Exit") //添加推出按钮并设置响应函数
		{
			public void actionPerformed(ActionEvent event)
			{
				System.exit(0);
			}
		});
		
		readonlyItem = new JCheckBoxMenuItem("Read-only"); //在Menu上添加只读复选框，将这个菜单项设为禁用状态，以使屏蔽掉这些暂时不适用的命令
		readonlyItem.addActionListener(new ActionListener() //设置只读按钮响应函数，被禁用的菜单项被现实为灰色
		{
			public void actionPerformed(ActionEvent event)
			{
				//下述三条语句是用来设置文件是否可以被保存
				boolean saveOK = !readonlyItem.isSelected(); //saveOK等于复选框被选择的相反值
				saveAction.setEnabled(saveOK);
				saveAsAction.setEnabled(saveOK);
			}
		});
		
		ButtonGroup group = new ButtonGroup(); //新建单选框用户组
		JRadioButtonMenuItem insertItem = new JRadioButtonMenuItem("Insert");
		insertItem.setSelected(true);
		JRadioButtonMenuItem overtypeItem = new JRadioButtonMenuItem("Overtype");
		
		group.add(insertItem);
		group.add(overtypeItem);
		
		Action cutAction = new TestAction("Cut");
		cutAction.putValue(Action.SMALL_ICON, new ImageIcon("cut.gif"));
		Action copyAction = new TestAction("Copy");
		copyAction.putValue(Action.SMALL_ICON, new ImageIcon("copy.gif"));
		Action pasteAction = new TestAction("Paste");
		pasteAction.putValue(Action.SMALL_ICON, new ImageIcon("paste.gif"));
		
		JMenu editMenu = new JMenu("Edit");
		editMenu.add(cutAction);
		editMenu.add(copyAction);
		editMenu.add(pasteAction);
		
		JMenu optionMenu = new JMenu("Options");
		
		optionMenu.add(readonlyItem);
		optionMenu.addSeparator();
		optionMenu.add(insertItem);
		optionMenu.add(overtypeItem);
		
		editMenu.addSeparator();
		editMenu.add(optionMenu);//注意是在编辑菜单下添加option弹出按钮，注意两个都是JMenu类型 
		
		JMenu helpMenu = new JMenu("Help");
		helpMenu.setMnemonic('H');//设置热键，需要设置Alt+H
		
		JMenuItem indexItem = new JMenuItem("Index");//注意这里是JMenuItem类型
		indexItem.setMnemonic('I');
		helpMenu.add(indexItem);
		
		Action aboutAction = new TestAction("About");
		aboutAction.putValue(Action.MNEMONIC_KEY, new Integer('A'));
		helpMenu.add(aboutAction);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(helpMenu);
		
		popup = new JPopupMenu();
		popup.add(cutAction);
		popup.add(copyAction);
		popup.add(pasteAction);
		
		JPanel panel = new JPanel();
		panel.setComponentPopupMenu(popup);
		add(panel);
		
		panel.addMouseListener(new MouseAdapter(){});
	}
	
	public static final int DEFAULT_WIDTH = 300;
	public static final int DEFAULT_HEIGHT = 200;
	
	private Action saveAction;
	private Action saveAsAction;
	private JCheckBoxMenuItem readonlyItem;
	private JPopupMenu popup;
}

class TestAction extends AbstractAction
{
	public TestAction(String name)
	{
		super(name);
	}
	
	public void actionPerformed(ActionEvent event)
	{
		System.out.println(getValue(Action.NAME) + "selected.");
	}
}