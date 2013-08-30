package dataAccess;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataAccess {
	private String CONNECTION_STRING = "jdbc:sqlserver://localhost:1433;DatabaseName=MyDatabase";
	private String connErrInfo;
	private Connection conn;
	private Statement stmt;
	
	public DataAccess()
	{
		if(conn == null)
		{
			conn = GetConnObj();
		}
	}
	
	public Connection GetConnObj()
	{
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(CONNECTION_STRING,"xiaovfight","123");
			if(conn != null)
			{
				System.out.println("已连接到数据库！");
			}
			return conn;
		} catch (ClassNotFoundException ex) {
			this.connErrInfo += ";dbConn ex:" + ex.toString();
			ex.printStackTrace();
		} catch (SQLException es) {
			this.connErrInfo += ";dbConn es:" + es.getMessage();
			es.printStackTrace();
		}
		return null;
	}
	
	
	public String commonUpdate(String rSqlString)
	{
		if(conn!=null)
		{
			try {
				stmt = conn.createStatement();
				if(stmt.execute(rSqlString))
				{
					System.out.println("已执行更新！");
				}
				
			} catch (SQLException e) {
				return e.getMessage();
			}
		}
		return "";
	}
	
	public ResultSet commonSelect(String rSqlString)
	{
		if(conn!=null)
		{
			try {
				Statement stmt = conn.createStatement();
				if(stmt != null)
				{
					System.out.println("已创建会话！");
					System.out.println("查询语句为："+ rSqlString);
				}
				
				ResultSet result = stmt.executeQuery(rSqlString);

				return result;
			} catch (SQLException es) {
				System.out.println("SQLException:" + es.getMessage());
			}
		}
		return null;
	}
	
	public void close()
	{
		if(conn!=null)
		{
			try {
				conn.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public String getConnErrInfo() {
		return connErrInfo;
	}

	public void setConnErrInfo(String connErrInfo) {
		this.connErrInfo = connErrInfo;
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public Statement getStmt() {
		return stmt;
	}

	public void setStmt(Statement stmt) {
		this.stmt = stmt;
	}

	public static void main(String[] args) throws SQLException 
	{
		DataAccess dataAccess = new DataAccess();
		
		java.util.Date startDate = new java.util.Date();
		ResultSet rs = dataAccess.commonSelect("select * from info_book");
		
		while(rs.next())
		{
			int temp = (int)rs.getInt("bookID");
			System.out.println("Data:"+ temp);
		}
		
		java.util.Date endDate = new java.util.Date();
		long period = endDate.getTime() - startDate.getTime();
		System.out.println("耗费时间:"+period);
		
		dataAccess.close();
	}

}
