package unit_2_1.DomTreeTest;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.table.AbstractTableModel;
import javax.swing.tree.DefaultTreeCellRenderer;

import org.w3c.dom.CDATASection;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Comment;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

public class DOMTreeCellRenderer extends DefaultTreeCellRenderer 
{
	public Component getTreeRendererComponent(JTree tree,Object value,boolean selected,boolean expanded,boolean leaf,int row,boolean hasFocus)
	{
		Node node = (Node)value;
		if(node instanceof Element)
			return elementPanel((Element)node);
		
		super.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);
		if(node instanceof CharacterData)
			setText(characterString((CharacterData)node));
		else
			setText(node.getClass() + ": " + node.toString());
		return this;
	}
	
	public static JPanel elementPanel(Element e)
	{
		JPanel panel = new JPanel();
		panel.add(new JLabel("Element:" + e.getTagName()));
		final NamedNodeMap map = e.getAttributes();
		panel.add(new JTable(new AbstractTableModel()
		{
			public int getColumnCount() 
			{
				return 2;
			}

			public int getRowCount() 
			{
				return map.getLength();
			}

			public Object getValueAt(int r, int c) 
			{
				return c==0?map.item(r).getNodeName():map.item(r).getNodeValue();
			}
		}));
		return panel;
	}
	
	public static String characterString(CharacterData node)
	{
		StringBuilder builder = new StringBuilder(node.getData());
		for(int i = 0;i<builder.length();i++)
		{
			if(builder.charAt(i) == '\r')
			{
				builder.replace(i, i + 1, "\\r");
				i++;
			}else if(builder.charAt(i) == '\n'){
				builder.replace(i, i+1, "\\n");
				i++;
			}else if(builder.charAt(i) == '\t'){
				builder.replace(i, i+1, "\\t");
				i++;
			}
		}
		if(node instanceof CDATASection)
			builder.insert(0, "CDATASection: ");
		else if(node instanceof Text)
			builder.insert(0, "Text: ");
		else if(node instanceof Comment)
			builder.insert(0, "Comment: ");
		
		return builder.toString();
	}
}
