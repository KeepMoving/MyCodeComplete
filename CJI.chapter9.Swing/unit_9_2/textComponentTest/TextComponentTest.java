package unit_9_2.textComponentTest;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class TextComponentTest 
{
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable(){
			public void run()
			{
				TextComponentFrame frame = new TextComponentFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

class TextComponentFrame extends JFrame
{
	public TextComponentFrame()
	{
		setTitle("TextComponentTest");
		setSize(DEFAUTL_WIDTH,DEFAULT_HEIGHT);
		
		final JTextField textField = new JTextField(); //设置标准输入框
		final JPasswordField passwordField = new JPasswordField(); //设置密码输入框
		
		JPanel northPanel = new JPanel(); //开启一个面板
		northPanel.setLayout(new GridLayout(2,2)); //设置面板布局为流布局2X2
		northPanel.add(new JLabel("User name:",SwingConstants.RIGHT)); //第一行第一列插入名为"User name："的标签
		northPanel.add(textField); //第一行第二列插入textField文本域
		northPanel.add(new JLabel("Password: ",SwingConstants.RIGHT)); //第二行第一列插入名为"Password："的标签
		northPanel.add(passwordField); //第二行第二列插入passwordField文本域
		
		add(northPanel,BorderLayout.NORTH); //把以上面板添加到TextComponent容器的上部
		
		final JTextArea textArea = new JTextArea(8,40); //设置文本域
		JScrollPane scrollPane = new JScrollPane(textArea); //添加水平滚动条
		
		add(scrollPane,BorderLayout.CENTER); //把滚动条添加图形中部
		
		JPanel southPanel = new JPanel(); //产生一个面板
		
		JButton insertButton = new JButton("Insert"); //产生一个按钮
		southPanel.add(insertButton); //把按钮添加到面板中
		insertButton.addActionListener(new ActionListener() //设置按钮响应函数
		{
			public void actionPerformed(ActionEvent event) //按钮响应函数功能为把输入文本域中的内容复制到输出文本域中
			{
				textArea.append("User name: " + textField.getText() + "Password: " + 
								new String(passwordField.getPassword()) + "\n"); 
			}
		});
		
		add(southPanel,BorderLayout.SOUTH); //添加面板到容器的南端
		
	}
	
	public static final int DEFAUTL_WIDTH = 300;
	public static final int DEFAULT_HEIGHT = 300;
}