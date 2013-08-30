package unit_4_1.TestDB;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class TestDB 
{
	public static void main(String[] args) 
	{
		try {
			runTest();
		} catch (SQLException ex) {
			for(Throwable t:ex)
			{
				t.printStackTrace();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public static void runTest() throws SQLException,IOException
	{
		Connection conn = getConnection();
		
		try {
			Statement stat = conn.createStatement();
			
			stat.executeUpdate("CREATE TABLE Greeting(Message CHAR(20))");
			stat.executeUpdate("INSERT INTO Greeting VALUES ('Hello,World')");
			
			ResultSet result = stat.executeQuery("SELECT * FROM Greeting");
			
			if(result.next())
				System.out.println(result.getString(1));
			result.close();
			stat.executeUpdate("DROP TABLE Greeting");
		}finally{
			conn.close();
		}
	}
	
	public static Connection getConnection() throws SQLException,IOException
	{
		Properties props = new Properties();
		FileInputStream in = new FileInputStream("D:\\MyProject\\MyCodeComplete\\CJII.chapter4.Database\\unit_4_1\\TestDB\\database.properties");
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
}


