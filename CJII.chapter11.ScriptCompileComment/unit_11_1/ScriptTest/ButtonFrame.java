package unit_11_1.ScriptTest;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ButtonFrame extends JFrame 
{
	public ButtonFrame()
	{
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		
		panel = new JPanel();
		panel.setName("panel");
		add(panel);
		
		yellowButton = new JButton("Yellow");
		yellowButton.setName("yellowButton");
		
		blueButton = new JButton("Blue");
		blueButton.setName("blueButton");
		
		redButton = new JButton("Red");
		redButton.setName("redButton");
		
		panel.add(yellowButton);
		panel.add(blueButton);
		panel.add(redButton);
	}
	
	public static final int DEFAULT_WIDTH = 300;
	public static final int DEFAULT_HEIGHT = 200;
	
	private JPanel panel;
	private JButton yellowButton;
	private JButton blueButton;
	private JButton redButton;
}
