package wuZiQi_AI_5_success_plus;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JOptionPane;

public class TableListener extends MouseAdapter 
{
	public void mouseReleased(MouseEvent e) 
	{   
		try {
			Properties props = new Properties();
			FileInputStream in = new FileInputStream("D:\\MyProject\\MyCodeComplete\\CJI.example\\wuZiQi_AI_5_success_plus\\model.properties");
			props.load(in);
			in.close();
			this.maxRow = Integer.parseInt(props.getProperty("model.maxRow"));
			this.maxColumn = Integer.parseInt(props.getProperty("model.maxColumn"));
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
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
		    
			AI ai = new AI(row, column,data,"A");
			int computerNum = 7;
			String location = ai.computerLocation(row, column,computerNum,true);
			String[] locationTemp = location.split("/");
			
			int computerRow = Integer.parseInt(locationTemp[0]);
			int computerColumn = Integer.parseInt(locationTemp[1]);
			
			if(computerRow <0 || computerRow == maxRow || computerColumn <0 || computerColumn == maxColumn || data[computerRow][computerColumn] != null)
			{
				location = ai.computerLocation(row, column, computerNum, false);
				locationTemp = location.split("/");
				
				computerRow = Integer.parseInt(locationTemp[0]);
				computerColumn = Integer.parseInt(locationTemp[1]);
			}
			
			while(computerRow <0 || computerRow == maxRow || computerColumn <0 || computerColumn == maxColumn || data[computerRow][computerColumn] != null)
			{
				computerNum--;
				location = ai.computerLocation(row, column,computerNum,true);
				locationTemp = location.split("/");
				
				computerRow = Integer.parseInt(locationTemp[0]);
				computerColumn = Integer.parseInt(locationTemp[1]);
			}
			
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
	
	private int maxRow = 10;
	private int maxColumn = 8;
}
