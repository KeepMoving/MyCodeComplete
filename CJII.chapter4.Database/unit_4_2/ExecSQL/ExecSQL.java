package unit_4_2.ExecSQL;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class ExecSQL 
{
	public static void main(String[] args) 
	{
		try {
			Scanner in;
			if(args.length == 0)
				in = new Scanner(System.in);
			else 
				in = new Scanner(new File(args[0]));
			
			Connection conn = getConnection();
			try {
				Statement stat = conn.createStatement();
				while(true)
				{
					if(args.length == 0)
						System.out.println("Enter command or EXIT to exit:");
					
					if(!in.hasNextLine())
						return;
					
					String line = in.nextLine();
					if(line.equalsIgnoreCase("EXIT"))
						return;
					if(line.trim().endsWith(";"))
					{
						line = line.trim();
						line = line.substring(0,line.length() - 1);
					}
					try {
						boolean hasResultSet = stat.execute(line);
						if(hasResultSet)
							showResultSet(stat);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				conn.close();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException,IOException
	{
		Properties props = new Properties();
		FileInputStream in = new FileInputStream("D:\\MyProject\\MyCodeComplete\\CJII.chapter4.Database\\unit_4_2\\ExecSQL\\database.properties");
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
	
	public static void showResultSet(Statement stat) throws SQLException
	{
		ResultSet result = stat.getResultSet();
		ResultSetMetaData metaData = result.getMetaData();
		int columnCount = metaData.getColumnCount();
		
		for(int i = 1; i <= columnCount;i++)
		{
			if(i>1)
				System.out.println(", ");
			System.out.println(metaData.getColumnLabel(i));
		}
		System.out.println();
		
		while(result.next())
		{
			for(int i = 1;i <= columnCount;i++)
			{
				if(i>1)
					System.out.println(", ");
				System.out.println(result.getString(i));
			}
			System.out.println();
		}
		result.close();
	}
}
