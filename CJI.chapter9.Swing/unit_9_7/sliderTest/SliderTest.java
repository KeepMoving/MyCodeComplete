package unit_9_7.sliderTest;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.util.Dictionary;
import java.util.Hashtable;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderTest 
{
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				SliderTestFrame frame = new SliderTestFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

class SliderTestFrame extends JFrame
{
	public SliderTestFrame()
	{
		setTitle("SliderTest");
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		
		sliderPanel = new JPanel();
		sliderPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		//common listener for all sliders
		listener = new ChangeListener()
		{
			public void stateChanged(ChangeEvent event)
			{
				//update text field when the slider value changes
				JSlider source = (JSlider) event.getSource();
				textField.setText("" + source.getValue());
			}
		};
		
		//add a plain slider
		JSlider slider = new JSlider();
		addSlider(slider,"plain");
		
		//add a slider with major and minor ticks
		slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		addSlider(slider,"Ticks");
		
		//add a slider that snaps to ticks
		slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setSnapToTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		addSlider(slider,"Snap to ticks");
		
		//add a slider with no track
		slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		slider.setPaintTrack(false);
		addSlider(slider,"No track");
		
		//add an inverted slider
		slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		slider.setInverted(true);
		addSlider(slider,"Inverted");
		
		//add a slider with numeric labels
		slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		addSlider(slider,"Labels");
		
		//add a slider with alphabetic labels
		slider = new JSlider();
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		addSlider(slider,"Labels");
		
		//add a slider with alphabetic labels
		slider = new JSlider();
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		
		Dictionary<Integer ,Component> labelTable = new Hashtable<Integer,Component>();
		labelTable.put(0,new JLabel("A"));
		labelTable.put(0,new JLabel("B"));
		labelTable.put(0,new JLabel("C"));
		labelTable.put(0,new JLabel("D"));
		labelTable.put(0,new JLabel("E"));
		labelTable.put(0,new JLabel("F"));
		
		slider.setLabelTable(labelTable);
		addSlider(slider,"Custom lables");
		
		//add a slider with icon labels
		slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setSnapToTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(20);
		
		labelTable = new Hashtable<Integer,Component>();
		
		labelTable.put(0, new JLabel(new ImageIcon("020.gif")));
		labelTable.put(0, new JLabel(new ImageIcon("021.gif")));
		labelTable.put(0, new JLabel(new ImageIcon("022.gif")));
		labelTable.put(0, new JLabel(new ImageIcon("024.gif")));
		labelTable.put(0, new JLabel(new ImageIcon("025.gif")));
		labelTable.put(0, new JLabel(new ImageIcon("026.gif")));
		
		slider.setLabelTable(labelTable);
		addSlider(slider,"Icon labels");
		
		//add the text field that display the slider value
		
		textField = new JTextField();
		add(sliderPanel,BorderLayout.CENTER);
		add(textField,BorderLayout.SOUTH);
	}
	
	public void addSlider(JSlider s ,String description)
	{
		s.addChangeListener(listener);
		JPanel panel = new JPanel();
		panel.add(s);
		panel.add(new JLabel(description));
		sliderPanel.add(panel);
	}
	
	public static final int DEFAULT_WIDTH = 500;
	public static final int DEFAULT_HEIGHT = 500;
	
	private JPanel sliderPanel;
	private JTextField textField;
	private ChangeListener listener;
}