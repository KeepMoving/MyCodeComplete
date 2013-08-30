package unit_5_2.DateFormatTest;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import unit_9_11.GBC.GBC;

/*
 * This frame contains comboBoxes to pick a locale ,
 * date and time formats ,text fields to display formated date and time,
 * buttons to parse the text field contents, and a "leninet " checkbox. */
public class DateFormatFrame extends JFrame 
{
	public DateFormatFrame()
	{
		setTitle("DateFormatTest");
		
		setLayout(new GridBagLayout());
		add(new JLabel("Locale"),new GBC(0,0).setAnchor(GBC.EAST));
		add(new JLabel("Date style"),new GBC(0,1).setAnchor(GBC.EAST));
		add(new JLabel("Time style"),new GBC(2,1).setAnchor(GBC.EAST));
		add(new JLabel("Date"),new GBC(0,2).setAnchor(GBC.EAST));
		add(new JLabel("Time"),new GBC(0,3).setAnchor(GBC.EAST));
		add(localeCombo,new GBC(1,0,2,1).setAnchor(GBC.WEST));
		add(dateStyleCombo,new GBC(1,0,2,1).setAnchor(GBC.WEST));
		add(timeStyleCombo,new GBC(1,1).setAnchor(GBC.WEST));
		add(dateParseButton,new GBC(3,1).setAnchor(GBC.WEST));
		add(timeParseButton,new GBC(3,3).setAnchor(GBC.WEST));
		add(lenientCheckBox,new GBC(1,2,2,1).setFill(GBC.HORIZONTAL));
		add(dateText,new GBC(1,2,2,1).setFill(GBC.HORIZONTAL));
		add(timeText,new GBC(1,3,2,1).setFill(GBC.HORIZONTAL));
	
		locales = (Locale[])DateFormat.getAvailableLocales().clone();
		Arrays.sort(locales,new Comparator<Locale>()
				{
					public int compare(Locale l1,Locale l2)
					{
						return l1.getDisplayName().compareTo(l2.getDisplayName());
					}
				});
		for(Locale loc:locales)
		{
			localeCombo.addItem(loc.getDisplayName());
		}
		localeCombo.setSelectedItem(Locale.getDefault().getDisplayName());
		currentDate = new Date();
		currentTime = new Date();
		updateDisplay();
		
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				updateDisplay();
			}
		};
		
		localeCombo.addActionListener(listener);
		dateStyleCombo.addActionListener(listener);
		timeStyleCombo.addActionListener(listener);
		
		dateParseButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				String d = dateText.getText().trim();
				try {
					currentDateFormat.setLenient(lenientCheckBox.isSelected());
					Date date = currentDateFormat.parse(d);
					currentDate = date;
					updateDisplay();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					dateText.setText("Parse error: " + d);
				}
			}
		});
		
		timeParseButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				String t = timeText.getText().trim();
				try {
					currentDateFormat.setLenient(lenientCheckBox.isSelected());
					Date date = currentTimeFormat.parse(t);
					currentTime = date;
					updateDisplay();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					timeText.setText("Parse error: " + t);
				}
			}
		});
		pack();
	}
	
	/*updates the display and formats the date according to the user settings*/
	public void updateDisplay()
	{
		Locale currentLocale = locales[localeCombo.getSelectedIndex()];
		int dateStyle = dateStyleCombo.getValue();
		currentDateFormat = DateFormat.getDateInstance(dateStyle,currentLocale);
		String d = currentDateFormat.format(currentDate);
		dateText.setText(d);
		int timeStyle = timeStyleCombo.getValue();
		currentTimeFormat = DateFormat.getTimeInstance(timeStyle,currentLocale);
		String t = currentTimeFormat.format(currentTime);
		timeText.setText(t);
	}
	
	private Locale[] locales;
	private Date currentDate;
	private Date currentTime;
	private DateFormat currentDateFormat;
	private DateFormat currentTimeFormat;
	private JComboBox localeCombo = new JComboBox();
	private EnumCombo dateStyleCombo = new EnumCombo(DateFormat.class,new String[]{"Default","Full","Long","Medium","Short"});
	private EnumCombo timeStyleCombo = new EnumCombo(DateFormat.class,new String[]{"Default","Full","Long","Medium","Short"});
	private JButton dateParseButton = new JButton("Parse date");
	private JButton timeParseButton = new JButton("Parse time");
	private JTextField dateText = new JTextField(30);
	private JTextField timeText = new JTextField(30);
	private JCheckBox lenientCheckBox = new JCheckBox("Parse lenient",true);
}
