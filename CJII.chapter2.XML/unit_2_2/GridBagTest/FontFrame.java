package unit_2_2.GridBagTest;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class FontFrame extends JFrame 
{
	public FontFrame(String filename)
	{
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		setTitle("GridBagTest");
		
		gridbag = new GridBagPane(filename);
		add(gridbag);
		
		face = (JComboBox) gridbag.get("face");
		size = (JComboBox) gridbag.get("size");
		bold = (JCheckBox) gridbag.get("bold");
		italic = (JCheckBox) gridbag.get("italic");
		
		face.setModel(new DefaultComboBoxModel(new Object[]{"Serif","SansSerif","Monospaced","Dialog","DialogInput"}));
		size.setModel(new DefaultComboBoxModel(new Object[]{"8","Sans10","12","15","18","24","36","48"}));
		
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				setSample();
			}
		};
		
		face.addActionListener(listener);
		size.addActionListener(listener);
		bold.addActionListener(listener);
		italic.addActionListener(listener);
		setSample();
	}
	
	public void setSample()
	{
		String fontFace = (String)face.getSelectedItem();
		int fontSize = Integer.parseInt((String)size.getSelectedItem());
		JTextArea sample = (JTextArea)gridbag.get("sample");
		int fontStyle = (bold.isSelected()?Font.BOLD:0) + (italic.isSelected()?Font.ITALIC:0);
		
		sample.setFont(new Font(fontFace,fontStyle,fontSize));
		sample.repaint();
	}
	
	private GridBagPane gridbag;
	private JComboBox face;
	private JComboBox size;
	private JCheckBox bold;
	private JCheckBox italic;
	private static final int DEFAULT_WIDTH = 400;
	private static final int DEFAULT_HEIGHT = 400;
}
