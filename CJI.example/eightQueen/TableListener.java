package eightQueen;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Stack;

public class TableListener extends MouseAdapter 
{
	public void mouseReleased(MouseEvent e) 
	{   
		try {
			Properties props = new Properties();
			FileInputStream in = new FileInputStream("D:\\MyProject\\MyCodeComplete\\CJI.example\\eightQueen\\model.properties");
			props.load(in);
			in.close();
			this.modelLength = Integer.parseInt(props.getProperty("model.maxLength"));
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
		
		data[0][0] = "X";
		this.locationStack.push("0/0");
		
		String locationTemp;
		String locationDelete = "0/0";
		
		for(int j = 2;j<this.modelLength;j++)
		{
			inner:
			{
				for(int i = 0;i<j;i++)
				{
					locationTemp = i+"/"+j;
					if(locationTemp != locationDelete && !gameRule.isLined(locationStack, locationTemp))
					{
						locationStack.push(locationTemp);
						break inner;
					}
				}
		
				for(int i = j-1;i>=0;i--)
				{
					locationTemp = j+"/"+i;
					if(locationTemp != locationDelete && !gameRule.isLined(locationStack, locationTemp))
					{
						locationStack.push(locationTemp);
						break inner;
					}
				}
				
				j = j-2;
				locationDelete = locationStack.pop();
			}
		}
		
		System.out.println("locationStack size = " + locationStack.size());
		while(!locationStack.isEmpty())
		{
			String locationData[] = locationStack.pop().split("/");
			System.out.println("locationData[0] = " + locationData[0] + " " + locationData[1]);
			data[Integer.parseInt(locationData[0])][Integer.parseInt(locationData[1])] = "X";
		}
		
		//刷新表格   
		table.updateUI();   
	}   
	
	private GameRule gameRule = new GameRule();
	private int modelLength = 8;
	private Stack<String> locationStack = new Stack<String>();
}
