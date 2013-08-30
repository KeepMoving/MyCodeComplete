package wuZiQi_AI_6_loginUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StartProgram 
{
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				LoginFrame frame = new LoginFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

class LoginFrame extends JFrame
{
	public LoginFrame()
	{
		setTitle("欢迎进入五子棋世界");
		LoginPanel loginPanel = new LoginPanel();
		add(loginPanel);
		pack(); //排列组件
	}
}

class LoginPanel extends JPanel
{
	public LoginPanel()
	{
		setLayout(new BorderLayout());
		
		JPanel northPanel = new JPanel();	
		final JTextField userRow = new JTextField();
		final JTextField userColumn = new JTextField();
		final JButton start = new JButton("开始");
		final JButton cancel = new JButton("取消");
		
		northPanel.setLayout(new GridLayout(2,3));
		northPanel.add(new JLabel("设定行数:"));
		northPanel.add(userRow);
		northPanel.add(start);
		northPanel.add(new JLabel("设定列数:"));
		northPanel.add(userColumn);
		northPanel.add(cancel);
		add(northPanel,BorderLayout.NORTH);
		
		start.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(userRow.getText() == null || userColumn.getText() == null)
				{
					
					JOptionPane.showMessageDialog(null, "使用默认值！");
					LoginUI loginUI = new LoginUI();
					loginUI.CreateUI();
				}else{
					try {
						Properties props = new Properties();
						FileInputStream in = new FileInputStream("D:\\MyProject\\MyCodeComplete\\CJI.example\\wuZiQi_AI_6_loginUI\\model.properties");
						props.load(in);
						in.close();
						props.setProperty("model.maxRow", userRow.getText());
						props.setProperty("model.maxColumn", userColumn.getText());
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					LoginUI loginUI = new LoginUI();
					loginUI.CreateUI();
				}
			}
		});
		
		cancel.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				userRow.setText("");
				userColumn.setText("");
			}
		});
	}
}