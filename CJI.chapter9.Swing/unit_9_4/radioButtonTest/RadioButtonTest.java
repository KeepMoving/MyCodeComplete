package unit_9_4.radioButtonTest;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class RadioButtonTest 
{
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				RadioButtonFrame frame = new RadioButtonFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

class RadioButtonFrame extends JFrame
{
	public RadioButtonFrame()
	{
		setTitle("RadioButtonTest");
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		
		//add the sample text label
		label = new JLabel("The quick brown fox jumps over the lazy dog.");
		label.setFont(new Font("Serif",Font.PLAIN,DEFAULT_SIZE));
		add(label,BorderLayout.CENTER);
		
		//add the radio button
		buttonPanel = new JPanel();
		group = new ButtonGroup(); //构造一个ButtonGroup对象
		
		addRadioButton("Small",8);
		addRadioButton("Mediun",12);
		addRadioButton("Large",18);
		addRadioButton("Extra large",36);
		
		add(buttonPanel,BorderLayout.SOUTH);
	}
	
	public void addRadioButton(String name,final int size)
	{
		boolean selected = size == DEFAULT_SIZE;
		JRadioButton button = new JRadioButton(name,selected);
		group.add(button); //把各个button添加到ButtonGroup对象中
		buttonPanel.add(button); //在把当前按钮添加到buttonPanel面板中
		
		//this listener sets the label font size
		ActionListener listener = new ActionListener() //注意在面向对象中在构造一个按钮对象后直接设置它的响应函数
		{
			public void actionPerformed(ActionEvent event)
			{
				//size refers to the final parameter of the addRadioButton
				//method
				label.setFont(new Font("Serif",Font.PLAIN,size));
			}
		};
		
		button.addActionListener(listener); //在按钮对象中添加响应函数
	}
	
	public static final int DEFAULT_WIDTH = 400;
	public static final int DEFAULT_HEIGHT = 300;
	
	private JPanel buttonPanel;
	private ButtonGroup group;
	private JLabel label;
	
	private static final int DEFAULT_SIZE = 12;
}