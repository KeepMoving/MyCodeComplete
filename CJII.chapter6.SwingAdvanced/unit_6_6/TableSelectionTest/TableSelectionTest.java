package unit_6_6.TableSelectionTest;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class TableSelectionTest 
{
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run() 
			{
			}
		});
	}
}

class TableSelectionFrame extends JFrame
{
	public TableSelectionFrame()
	{
		setTitle("TableSelectionTest");
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		
		model = new DefaultTableModel(10,10);
		for(int i=0;i<model.getRowCount();i++)
			for(int j=0;j<model.getColumnCount();j++)
				model.setValueAt((i+1)*(j+1), i, j);
		
		table = new JTable(model);
		
		add(new JScrollPane(table),"Center");
		
		removedColumns = new ArrayList<TableColumn>();
		
		JMenuBar menuBar = new JMenuBar();
	}
	
	private DefaultTableModel model;
	private JTable table;
	private ArrayList<TableColumn> removedColumns;
	
	private static final int DEFAULT_WIDTH = 400;
	private static final int DEFAULT_HEIGHT = 300;
}
