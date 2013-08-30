package wuZiQi;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

public class TableListener extends MouseAdapter 
{
	private int count =0; 
	public void mouseReleased(MouseEvent e) 
	{   
		//获得点击的元素   
		Object obj = e.getSource();            
		 
		//将obj强制转型   
		javax.swing.JTable table = (javax.swing.JTable)obj;   
	  
		//得到表格模型对象   
		javax.swing.table.TableModel tablemodel = table.getModel();   
		 
		//强制转化为MyModel对象   
		MyModel mymodel = (MyModel)tablemodel;   
		
		//得到MyModel中的二维数组   
		String[][] data = mymodel.GetData(); 
		
		//得到执行的行   
		int row = table.getSelectedRow();   
		 
		//得到执行的列   
		int column = table.getSelectedColumn(); 
		
		if(data[row][column] != "A" && data[row][column] != "B" && count==0)
		{   
			data[row][column]= "A";  
			count++;
			GameRule gameRule = new GameRule();
			if(gameRule.isTheWinnerA(row, column, data))
			{
				JOptionPane.showMessageDialog(null, "player A win");
				System.out.println("player A win");
			}
		}else if(data[row][column] != "A" && data[row][column] != "B"){   
			data[row][column]= "B";   
			count = 0;  
			GameRule gameRule = new GameRule();
			if(gameRule.isTheWinnerB(row, column, data))
			{
				JOptionPane.showMessageDialog(null, "player B win");
				System.out.println("player B win");			
			}
		}else{
			JOptionPane.showMessageDialog(null, "请不要重复输入！");	
		}
		
		//刷新表格   
		table.updateUI();   
	}   
}
