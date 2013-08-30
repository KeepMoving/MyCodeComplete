package unit_4_4.ViewDB;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.spi.SyncProviderException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.sun.rowset.CachedRowSetImpl;

public class ViewDB 
{
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run() 
			{
				JFrame frame = new ViewDBFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

class ViewDBFrame extends JFrame
{
	public ViewDBFrame()
	{
		setTitle("ViewDB");
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		
		tableNames = new JComboBox();
		tableNames.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				showTable((String)tableNames.getSelectedItem());
			}
		});
		add(tableNames,BorderLayout.NORTH);
		
		try {
			readDatabaseProperties();
			Connection conn = getConnection();
			try {
				DatabaseMetaData meta = conn.getMetaData();//返回一个DatabaseMetaData对象，该对象封装了有关数据库连接的元数据;
				//返回某个目录中的所有表的描述，该目录必须符合给定的模式、表名字模式以及类型标准。（模式用于描述一组相关的表和访问权限，
				//而目录描述的是一组相关的模式，这些概念对组织大型数据库非常重要。）
				ResultSet mrs = meta.getTables(null, null, null,new String[]{"TABLE"});
				while(mrs.next())
					tableNames.addItem(mrs.getString(3));
			} finally{
				conn.close();
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, e1);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, e1);
		}
		
		JPanel buttonPanel = new JPanel();
		add(buttonPanel,BorderLayout.SOUTH);
		
		previousButton = new JButton("Previous");
		previousButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				showPreviousRow();
			}
		});
		buttonPanel.add(previousButton);
		
		nextButton = new JButton("Next");
		nextButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				showNextRow();
			}
		});
		buttonPanel.add(nextButton);
		
		deleteButton = new JButton("Delete");
		deleteButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				deleteRow();
			}
		});
		buttonPanel.add(deleteButton);
		
		saveButton = new JButton("Save");
		saveButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				saveChanges();
			}
		});
		buttonPanel.add(saveButton);
	}
	
	public void showTable(String tableName)
	{
		try {
			Connection conn = getConnection();
			try {
				Statement stat = conn.createStatement();
				ResultSet result = stat.executeQuery("SELECT * FROM " + tableName);
				crs = new CachedRowSetImpl();
				crs.populate(result);
			} finally{
				conn.close();
			}
			
			if(scrollPane != null)
				remove(scrollPane);
			dataPanel = new DataPanel(crs);
			scrollPane = new JScrollPane(dataPanel);
			add(scrollPane,BorderLayout.CENTER);
			validate();
			showNextRow();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this,e);
		}
	}
	
	public void showPreviousRow()
	{
		try {
			if(crs == null || crs.isFirst())
				return;
			crs.previous();
			dataPanel.showRow(crs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			for(Throwable t:e)
				t.printStackTrace();
		}
	}
	
	public void showNextRow()
	{
		try {
			if(crs == null || crs.isLast())
				return;
			crs.next();
			dataPanel.showRow(crs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, e);
		}
	}
	
	public void deleteRow()
	{
		try {
			Connection conn = getConnection();
			try {
				crs.deleteRow();
				crs.acceptChanges(conn);
				if(!crs.isLast()){
					crs.next();
				}else if(!crs.isFirst()){
					crs.previous();
				}else{
					crs = null;
				}
				dataPanel.showRow(crs);
			}finally{
				conn.close();
			}
		} catch (SyncProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, e);
		}
	}
	
	public void saveChanges()
	{
		try {
			Connection conn = getConnection();
			try {
				dataPanel.setRow(crs);
				crs.acceptChanges(conn);
			}finally{
				conn.close();
			}
		} catch (SyncProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, e);
		}
	}
	
	private void readDatabaseProperties() throws IOException
	{
		props = new Properties();
		FileInputStream in = new FileInputStream("D:\\MyProject\\MyCodeComplete\\CJII.chapter4.Database\\unit_4_4\\ViewDB\\database.properties");
		props.load(in);
		in.close();
		String drivers = props.getProperty("jdbc.drivers");
		if(drivers != null)
			System.setProperty("jdbc.drivers", drivers);
	}
	
	private Connection getConnection() throws SQLException
	{
		String url = props.getProperty("jdbc.url");
		String username = props.getProperty("jdbc.username");
		String password = props.getProperty("jdbc.password");
		
		return DriverManager.getConnection(url,username,password);
	}
	
	public static final int DEFAULT_WIDTH = 400;
	public static final int DEFAULT_HEIGHT = 200;
	
	private JButton previousButton;
	private JButton nextButton;
	private JButton deleteButton;
	private JButton saveButton;
	private DataPanel dataPanel;
	private Component scrollPane;
	private JComboBox tableNames;
	private Properties props;
	private CachedRowSet crs;
}