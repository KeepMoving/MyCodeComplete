package wuZiQi_AI_4_halfAI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

public class TableListener extends MouseAdapter 
{
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
 
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		if(data[row][column] != "A" && data[row][column] != "B")
		{  
			data[row][column] = "A";  
			GameRule gameRule = new GameRule();
			if(gameRule.isTheWinnerA(row, column, data))
			{
				JOptionPane.showMessageDialog(null, "player A win");
				System.out.println("player A win");
			}
		    
			AI ai = new AI(row, column, data, "A");
			int computerNum = 7;
			String location = ai.computerLocation(row, column,computerNum,true);
			String[] locationTemp = location.split("/");
			
			int computerRow = Integer.parseInt(locationTemp[0]);
			int computerColumn = Integer.parseInt(locationTemp[1]);
			
			if(computerRow <0 || computerRow == 10 || computerColumn <0 || computerColumn == 8 || data[computerRow][computerColumn] != null)
			{
				location = ai.computerLocation(row, column, computerNum, false);
				locationTemp = location.split("/");
				
				computerRow = Integer.parseInt(locationTemp[0]);
				computerColumn = Integer.parseInt(locationTemp[1]);
			}
			
			while(computerRow <0 || computerRow == 10 || computerColumn <0 || computerColumn ==8 || data[computerRow][computerColumn] != null)
			{
				computerNum--;
				location = ai.computerLocation(row, column,computerNum,true);
				locationTemp = location.split("/");
				
				computerRow = Integer.parseInt(locationTemp[0]);
				computerColumn = Integer.parseInt(locationTemp[1]);
			}
			
//			System.out.println("-----------------------坐标定位-----------------------");
//			System.out.println("row= " + row + ";column= " + column);
//			System.out.println("computerRow= " + computerRow + ";computerColumn= " + computerColumn);
//			System.out.println();
			
			data[computerRow][computerColumn]= "B";
			GameRule gameRule1 = new GameRule();
			if(gameRule1.isTheWinnerB(row, column, data))
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
