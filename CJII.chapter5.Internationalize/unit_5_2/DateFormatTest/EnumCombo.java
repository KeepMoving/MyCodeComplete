package unit_5_2.DateFormatTest;

import java.util.Map;
import java.util.TreeMap;

import javax.swing.JComboBox;

/*A combo box that lets users chooser from among static field
values whose names are given in the constructor.*/

public class EnumCombo extends JComboBox 
{
	public EnumCombo(Class<?> cl,String[] labels)
	{
		for(String label:labels)
		{
			String name = label.toUpperCase().replace(' ', '_');
			int value = 0;
			try {
				java.lang.reflect.Field f = cl.getField(name);
				value = f.getInt(cl);
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				label = "(" + label + ")";
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				label = "(" + label + ")";
				e.printStackTrace();
			} catch (NoSuchFieldException e) {
				// TODO Auto-generated catch block
				label = "(" + label + ")";
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				label = "(" + label + ")";
				e.printStackTrace();
			}
			table.put(label,value);
			addItem(label);
		}
		setSelectedItem(labels[0]);
	}
	
    /*	
     * Return the value of the field that user selected.
     * @return the static field value
     * */
	public int getValue()
	{
		return table.get(getSelectedItem());
	}
	
	private Map<String,Integer> table = new TreeMap<String,Integer>();
}
