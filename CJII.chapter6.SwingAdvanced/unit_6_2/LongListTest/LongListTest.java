package unit_6_2.LongListTest;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.AbstractListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class LongListTest 
{
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run() 
			{
				JFrame frame = new LongListFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

class LongListFrame extends JFrame
{
	public LongListFrame()
	{
		setTitle("LongListTest");
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		
		wordList = new JList(new WordListModel(3));
		wordList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		wordList.setPrototypeCellValue("www");
		JScrollPane scrollPane = new JScrollPane(wordList);
		
		JPanel p = new JPanel();
		p.add(scrollPane);
		wordList.addListSelectionListener(new ListSelectionListener() 
		{
			public void valueChanged(ListSelectionEvent evt) 
			{
				StringBuilder word = (StringBuilder)wordList.getSelectedValue();
				setSubject(word.toString());
			}
		});
		
		Container contentPane = getContentPane();
		contentPane.add(p,BorderLayout.NORTH);
		label = new JLabel(prefix+suffix);
		contentPane.add(label, BorderLayout.CENTER);
		setSubject("fox");
	}
	
	public void setSubject(String word)
	{
		StringBuilder text = new StringBuilder(prefix);
		text.append(word);
		text.append(suffix);
		label.setText(text.toString());
	}
	

	private static final int DEFAULT_WIDTH = 400;
	private static final int DEFAULT_HEIGHT = 300;
	private JList wordList;
	private JLabel label;
	private String prefix = "The quick brown ";
	private String suffix = " jumps over the lazy dog.";
}

class WordListModel extends AbstractListModel
{
	public WordListModel(int n)
	{
		length = n;
	}
	
	public Object getElementAt(int n) 
	{
		StringBuilder r = new StringBuilder();
		for(int i=0;i<length;i++)
		{
			char c = (char)(FIRST+n%(LAST-FIRST+1));
			r.insert(0, c);
			n = n/(LAST-FIRST+1);
		}
		return r;
	}

	public int getSize() 
	{
		return (int)Math.pow(LAST-FIRST+1, length);
	}
	
	private int length;
	public static final char FIRST = 'a';
	public static final char LAST = 'z';
}
