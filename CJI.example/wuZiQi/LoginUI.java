package wuZiQi;

public class LoginUI 
{
	//创建一个主函数   
	public static void main(String[] args)
	{   
		//创建一个登录对象   
		LoginUI lg = new LoginUI();   
		//调用其中的方法   
		lg.UI();   
	}   
	
	public void UI()
	{   
		//先创建一个窗体   
		javax.swing.JFrame jf = new javax.swing.JFrame("五子棋");   
		  
		//设置窗体的大小   
		jf.setSize(500, 400); 
		
		//创建一个流式布局管理器   
		java.awt.FlowLayout fl = new java.awt.FlowLayout();   
		jf.setLayout(fl);   
		 
		//创建一个表格对象   
		javax.swing.JTable table = new javax.swing.JTable();   
		  
		//创建一个表格模型对象   
		MyModel model = new MyModel();   
		  
		//将表格模型加到表格对象中   
		table.setModel(model);   
		  
		//设置表格的高度   
		table.setRowHeight(30);   

		//逐一设置宽度   
		for(int col=0;col<table.getColumnCount();col++)
		{   
			//得到表格列对象   
			javax.swing.table.TableColumn tablecol = table.getColumnModel().getColumn(col);   
			tablecol.setPreferredWidth(30);   
		}   

		//设定点击时是只作用于一个方格   
		table.setRowSelectionAllowed(false);
		
		//将表格添加到窗体中   
		jf.add(table);   
		//关闭窗体时退出程序   
		jf.setDefaultCloseOperation(3);   
		//设置窗体出现时的位置   
		jf.setLocationRelativeTo(null);   
		//将窗体设置为可见   
		jf.setVisible(true);   

		//给表格加监听器   
		table.addMouseListener(new TableListener());   
	}   
}
