package unit_4_3.QueryDB;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import unit_9_11.GBC.GBC;

public class QueryDBFrame extends JFrame 
{
	public QueryDBFrame()
	{
		setTitle("QueryDB");
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		setLayout(new GridBagLayout());
		
		authors = new JComboBox();
		authors.setEditable(false);
		authors.addItem("Any");
		
		publishers = new JComboBox();
		publishers.setEditable(false);
		publishers.addItem("Any");
		
		result = new JTextArea(4,50);
		result.setEditable(false);
		
		priceChange = new JTextField(8);
		priceChange.setText("-5.00");
		
		try {
			conn = getConnection();
			Statement stat = conn.createStatement();
			String query = "SELECT Name FROM Authors";
			ResultSet rs = stat.executeQuery(query);
			while(rs.next())
				authors.addItem(rs.getString(1));
			rs.close();
			
			query = "SELECT Name FROM Publishers";
			rs = stat.executeQuery(query);
			while(rs.next())
				publishers.addItem(rs.getString(1));
			rs.close();
			stat.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		add(authors,new GBC(0,0,2,1));
		add(publishers,new GBC(2,0,2,1));
		
		JButton queryButton = new JButton("Query");
		queryButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				executeQuery();
			}
		});
		add(queryButton,new GBC(0,1,1,1).setInsets(3));
		
		JButton changeButton = new JButton("Change prices");
		changeButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				changePrices();
			}
		});
		add(changeButton,new GBC(2,1,1,1).setInsets(3));
		add(priceChange,new GBC(3,1,1,1).setFill(GBC.HORIZONTAL));
		add(new JScrollPane(result),new GBC(0,2,4,1).setFill(GBC.BOTH).setWeight(100, 100));
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent event)
			{
				try {
					if(conn != null)
						conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					for(Throwable t:e)
						t.printStackTrace();
				}
			}
		});
	}
	
	private void executeQuery()
	{
		ResultSet rs = null;
		
		try {
			String author = (String) authors.getSelectedItem();
			String publisher = (String) publishers.getSelectedItem();
			if(!author.equals("Any")&&!publisher.equals("Any"))
			{
				try {
					if(authorPublisherQueryStmt == null)
						authorPublisherQueryStmt = conn.prepareStatement(authorPublisherQuery);
					authorPublisherQueryStmt.setString(1, author);
					authorPublisherQueryStmt.setString(2, publisher);
					rs = authorPublisherQueryStmt.executeQuery();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(!author.equals("Any") && publisher.equals("Any")){
				try {
					if(authorQueryStmt == null)
						authorQueryStmt = conn.prepareStatement(authorQuery);
					authorQueryStmt.setString(1, author);
					rs = authorQueryStmt.executeQuery();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(author.equals("Any") && !publisher.equals("Any")){
				try {
					if(publisherQueryStmt == null)
						publisherQueryStmt = conn.prepareStatement(publisherQuery);
					publisherQueryStmt.setString(1, publisher);
					rs = publisherQueryStmt.executeQuery();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				try {
					if(allQueryStmt == null)
						allQueryStmt = conn.prepareStatement(allQuery);
					rs = allQueryStmt.executeQuery();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			result.setText("");
			while(rs.next())
			{
				result.append(rs.getString(1));
				result.append(", ");
				result.append(rs.getString(2));
				result.append("\n");
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			for(Throwable t:e)
				result.append(t.getMessage());
		}
	}
	
	public void changePrices()
	{
		String publisher = (String)publishers.getSelectedItem();
		if(publisher.equals("Any"));
		{
			result.setText("I am sorry,but I cannot do that.");
//			return;
		}
		
		try {
			if(priceUpdateStmt == null)
				priceUpdateStmt = conn.prepareStatement(priceUpdate);
			priceUpdateStmt.setString(1, priceChange.getText());
			priceUpdateStmt.setString(2, publisher);
			int r = priceUpdateStmt.executeUpdate();
			result.setText(r + " records updated.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException,IOException
	{
		Properties props = new Properties();
		FileInputStream in = new FileInputStream("D:\\MyProject\\MyCodeComplete\\CJII.chapter4.Database\\unit_4_3\\QueryDB\\database.properties");
		props.load(in);
		in.close();
		
		String drivers = props.getProperty("jdbc.drivers");
		if(drivers != null)
			System.setProperty("jdbc.drivers", drivers);
		String url = props.getProperty("jdbc.url");
		String username = props.getProperty("jdbc.username");
		String password = props.getProperty("jdbc.password");
		
		return DriverManager.getConnection(url,username,password);
	}
	
	public static final int DEFAULT_WIDTH = 400;
	public static final int DEFAULT_HEIGHT = 400;
	
	private JComboBox authors;
	private JComboBox publishers;
	private JTextField priceChange;
	private JTextArea result;
	private Connection conn;
	private PreparedStatement authorQueryStmt;
	private PreparedStatement authorPublisherQueryStmt;
	private PreparedStatement publisherQueryStmt;
	private PreparedStatement allQueryStmt;
	private PreparedStatement priceUpdateStmt;
	
	private static final String authorPublisherQuery = 
		    "SELECT Books.Price,Books.Title " +
	        	"FROM Books,BooksAuthors,Authors,Publishers" +
	        		"WHERE Authors.Author_Id = BooksAuthors.Author_Id AND " +
	                      "BooksAuthor.ISBN = Books.ISBN AND " +
	                      "Books.Publisher_Id = Publishers.Publisher_Id AND " +
	                      "Authors.Name = ? AND " +
	                      "Publishers.Name = ?"; 
	
	private static final String authorQuery = 
			"SELECT Books.Price,Books.Title " +
				"FROM Books,BooksAuthors,Authors,Publishers" +
					"WHERE Authors.Author_Id = BooksAuthor.Author_Id AND " +
					      "BooksAuthors.ISBN = Books.ISBN AND " +
					      "Books.Publisher_Id = Publishers.Publisher_Id AND " +
					      "Authors.Name = ? And " +
					      "Publishers.Name = ?";
	
	private static final String publisherQuery = 
		   	"SELECT Books.Price,Books.Title " +
		   		"FROM Books,Publishers" +
		   			"WHERE Books.Publisher_Id = Publisher.Publisher_Id AND " +
		   			      "Author.Name = ?";
	
	private static final String allQuery = "SELECT Books.Price,Books.Title FROM Books";
	
	private static final String priceUpdate = 
		"UPDATE Books SET Price = Price + ?" + 
			"WHERE Books.Publisher_Id = (SELECT Publisher_Id FROM Publishers WHERE Name = ?)";
}
