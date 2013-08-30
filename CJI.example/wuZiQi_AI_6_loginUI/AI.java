package wuZiQi_AI_6_loginUI;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class AI 
{
	public AI(int row,int column,String[][] data,String player)
	{
//		this.AIRow = row;
//		this.AIColumn = column;
		try {
			Properties props = new Properties();
			FileInputStream in = new FileInputStream("D:\\MyProject\\MyCodeComplete\\CJI.example\\wuZiQi_AI_6_loginUI\\model.properties");
			props.load(in);
			in.close();
			this.maxRow = Integer.parseInt(props.getProperty("model.maxRow"));
			this.maxColumn = Integer.parseInt(props.getProperty("model.maxColumn"));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.countMaxDownList = new ArrayList<Integer>();
		this.countMaxTopList = new ArrayList<Integer>();
		this.countMaxLeftList = new ArrayList<Integer>();
		this.countMaxRightList = new ArrayList<Integer>();
		this.countMaxLeftTopList = new ArrayList<Integer>();
		this.countMaxRightDownList = new ArrayList<Integer>();
		this.countMaxLeftDownList = new ArrayList<Integer>();
		this.countMaxRightTopList = new ArrayList<Integer>();
		
		this.leftSearch(row, column, data, player);
		this.rightSearch(row, column, data, player);
		this.topSearch(row, column, data, player);
		this.downSearch(row, column, data, player);
		this.leftTopSearch(row, column, data, player);
		this.rightDownSearch(row, column, data, player);
		this.leftDownSearch(row, column, data, player);
		this.rightTopSearch(row, column, data, player);
		
		for(int index = 0; index < this.countMaxLeftList.size();index++)
		{
			if(this.countMaxLeftList.get(index) != 2){
				maxLengthLeftPriority++;
				
				if(this.countMaxLeftList.get(index) == 1)
				{
					maxLengthLeftPriority *= 2;
				}
			}else{
				break;
			}
		}
		
		for(int index = 0; index < this.countMaxRightList.size();index++)
		{
			if(this.countMaxRightList.get(index) != 2){
				maxLengthRightPriority++;
				if(this.countMaxRightList.get(index) == 1)
				{
					maxLengthRightPriority *= 2;
				}
			}else{
				break;
			}
		}
		
		for(int index = 0; index < this.countMaxTopList.size();index++)
		{
			if(this.countMaxTopList.get(index) != 2){
				maxLengthTopPriority++;
				if(this.countMaxTopList.get(index) == 1)
				{
					maxLengthTopPriority *= 2;
				}
			}else{
				break;
			}
		}
		
		for(int index = 0; index < this.countMaxDownList.size();index++)
		{
			if(this.countMaxDownList.get(index) != 2){
				maxLengthDownPriority++;
				if(this.countMaxDownList.get(index) == 1)
				{
					maxLengthDownPriority *= 2;
				}
			}else{
				break;
			}
		}
		
		for(int index = 0; index < this.countMaxLeftTopList.size();index++)
		{
			if(this.countMaxLeftTopList.get(index) != 2){
				maxLengthLeftTopPriority++;
				if(this.countMaxLeftTopList.get(index) == 1)
				{
					maxLengthLeftTopPriority *= 2;
				}
			}else{
				break;
			}
		}
		
		for(int index = 0; index < this.countMaxRightDownList.size();index++)
		{
			if(this.countMaxRightDownList.get(index) != 2){
				maxLengthRightDownPriority++;
				if(this.countMaxRightDownList.get(index) == 1)
				{
					maxLengthRightDownPriority *= 2;
				}
			}else{
				break;
			}
		}
		
		for(int index = 0; index < this.countMaxLeftDownList.size();index++)
		{
			if(this.countMaxLeftDownList.get(index) != 2){
				maxLengthLeftDownPriority++;
				if(this.countMaxLeftDownList.get(index) == 1)
				{
					maxLengthLeftDownPriority *= 2;
				}
			}else{
				break;
			}
		}
		
		for(int index = 0; index < this.countMaxRightTopList.size();index++)
		{
			if(this.countMaxRightTopList.get(index) != 2){
				maxLengthRightTopPriority++;
				if(this.countMaxRightTopList.get(index) == 1)
				{
					maxLengthRightTopPriority *= 2;
				}
			}else{
				break;
			}
		}
		
		for(int index = 0;index<this.countMaxLeftList.size();index++)
		{
			if(this.countMaxLeftList.get(index) == 1)
			{
				this.countQiZiLeft++;
			}else{
				break;
			}
		}
		
		for(int index = 0;index<this.countMaxRightList.size();index++)
		{
			if(this.countMaxRightList.get(index) == 1)
			{
				this.countQiZiRight++;
			}else{
				break;
			}
		}
		
		for(int index = 0;index<this.countMaxTopList.size();index++)
		{
			if(this.countMaxTopList.get(index) == 1)
			{
				this.countQiZiTop++;
			}else{
				break;
			}
		}
		
		for(int index = 0;index<this.countMaxDownList.size();index++)
		{
			if(this.countMaxDownList.get(index) == 1)
			{
				this.countQiZiDown++;
			}else{
				break;
			}
		}
		
		for(int index = 0;index<this.countMaxLeftTopList.size();index++)
		{
			if(this.countMaxLeftTopList.get(index) == 1)
			{
				this.countQiZiLeftTop++;
			}else{
				break;
			}
		}
		
		for(int index = 0;index<this.countMaxRightDownList.size();index++)
		{
			if(this.countMaxRightDownList.get(index) == 1)
			{
				this.countQiZiRightDown++;
			}else{
				break;
			}
		}
		
		for(int index = 0;index<this.countMaxLeftDownList.size();index++)
		{
			if(this.countMaxLeftDownList.get(index) == 1)
			{
				this.countQiZiLeftDown++;
			}else{
				break;
			}
		}
		
		for(int index = 0;index<this.countMaxRightTopList.size();index++)
		{
			if(this.countMaxRightTopList.get(index) == 1)
			{
				this.countQiZiRightTop++;
			}else{
				break;
			}
		}
		
		this.maxLengthLeft = this.countMaxLeftList.size();
		for(int index = this.countMaxLeftList.size() - 1;index>0;index--)
		{
			if(this.countMaxLeftList.get(index) == 0)
			{
				this.maxLengthLeft--;
			}else{
				break;
			}
		}
		
		this.maxLengthRight = this.countMaxRightList.size();
		for(int index = this.countMaxRightList.size() - 1;index>0;index--)
		{
			if(this.countMaxRightList.get(index) == 0)
			{
				this.maxLengthRight--;
			}else{
				break;
			}
		}
		
		this.maxLengthTop = this.countMaxTopList.size();
		for(int index = this.countMaxTopList.size() - 1;index>0;index--)
		{
			if(this.countMaxTopList.get(index) == 0)
			{
				this.maxLengthTop--;
			}else{
				break;
			}
		}
		
		this.maxLengthDown = this.countMaxDownList.size();
		for(int index = this.countMaxDownList.size() - 1;index>0;index--)
		{
			if(this.countMaxDownList.get(index) == 0)
			{
				this.maxLengthDown--;
			}else{
				break;
			}
		}
		
		this.maxLengthLeftTop = this.countMaxLeftTopList.size();
		for(int index = this.countMaxLeftTopList.size() - 1;index>0;index--)
		{
			if(this.countMaxLeftTopList.get(index) == 0)
			{
				this.maxLengthLeftTop--;
			}else{
				break;
			}
		}
		
		this.maxLengthRightDown = this.countMaxRightDownList.size();
		for(int index = this.countMaxRightDownList.size() - 1;index>0;index--)
		{
			if(this.countMaxRightDownList.get(index) == 0)
			{
				this.maxLengthRightDown--;
			}else{
				break;
			}
		}
		
		this.maxLengthLeftDown = this.countMaxLeftDownList.size();
		for(int index = this.countMaxLeftDownList.size() - 1;index>0;index--)
		{
			if(this.countMaxLeftDownList.get(index) == 0)
			{
				this.maxLengthLeftDown--;
			}else{
				break;
			}
		}
		
		this.maxLengthRightTop = this.countMaxRightTopList.size();
		for(int index = this.countMaxRightTopList.size() - 1;index>0;index--)
		{
			if(this.countMaxRightTopList.get(index) == 0)
			{
				this.maxLengthRightTop--;
			}else{
				break;
			}
		}
		
		String MaxLeft = "countQiZiLeft" + "/" + this.maxLengthLeft + "/" + this.maxLengthLeftPriority;
		String MaxRight = "countQiZiRight" + "/" + this.maxLengthRight + "/" + this.maxLengthRightPriority;
		String MaxTop = "countQiZiTop" + "/" + this.maxLengthTop + "/" + this.maxLengthTopPriority;
		String MaxDown = "countQiZiDown" + "/" + this.maxLengthDown + "/" + this.maxLengthDownPriority;
		String MaxLeftTop = "countQiZiLeftTop" + "/" + this.maxLengthLeftTop + "/" + this.maxLengthLeftTopPriority;
		String MaxRightDown = "countQiZiRightDown" + "/" + this.maxLengthRightDown + "/" + this.maxLengthRightDownPriority;
		String MaxLeftDown = "countQiZiLeftDown" + "/" + this.maxLengthLeftDown + "/" + this.maxLengthLeftDownPriority;
		String MaxRightTop = "countQiZiRightTop" + "/" + this.maxLengthRightTop + "/" + this.maxLengthRightTopPriority;	
		
		dataList1 = new ArrayList<String>();
		dataList1.add(MaxLeft);
		dataList1.add(MaxRight);
		dataList1.add(MaxTop);
		dataList1.add(MaxDown);
		dataList1.add(MaxLeftTop);
		dataList1.add(MaxRightDown);
		dataList1.add(MaxLeftDown);
		dataList1.add(MaxRightTop);
	}
	
	public String computerLocation(int row,int column,int computerNum,boolean clashMode)
	{
		ArrayList<String> data1 = this.sortEntities(dataList1);
		String[] maxLengthEntity = null;
		
		System.out.println("得到元素：" + (String)data1.get(computerNum));
		maxLengthEntity = ((String)data1.get(computerNum)).split("/");
		System.out.println("得到元素maxLengthEntity[0] = " + maxLengthEntity[0]);
		
		this.maxLengthName = maxLengthEntity[0];
		this.maxLength = Integer.parseInt(maxLengthEntity[1]); 
		int maxSpaceLength = 0; 
		
		if(maxLengthName.equalsIgnoreCase("countQiZiLeft"))
		{
			System.out.println("-----------------1方案countQiZiLeft----------------");
			for(int index = 0; index < this.countMaxLeftList.size();index++)
			{
				if(this.countMaxLeftList.get(index) != 0){
					maxSpaceLength++;
				}else{
					break;
				}
			}
			
			if(countQiZiLeft == 4 && clashMode){
				this.setAIRow(row);
				this.setAIColumn(column + 1);
			}else{
				if(maxSpaceLength >= maxLength || maxSpaceLength ==0){
					this.setAIRow(row);
					this.setAIColumn(column - maxLength);
				}else{
					this.setAIRow(row);
					this.setAIColumn(column - maxSpaceLength);
				}
			}
		}else if(maxLengthName.equalsIgnoreCase("countQiZiRight")){
			System.out.println("-----------------2方案countQiZiRight----------------");
			for(int index = 0; index < this.countMaxRightList.size();index++)
			{
				if(this.countMaxRightList.get(index) != 0){
					maxSpaceLength++;
				}else{
					break;
				}
			}
			
			if(countQiZiRight == 4 && clashMode){
				this.setAIRow(row);
				this.setAIColumn(column - 1);
			}else{
				if(maxSpaceLength >= maxLength || maxSpaceLength ==0){
					this.setAIRow(row);
					this.setAIColumn(column + maxLength);
				}else{
					this.setAIRow(row);
					this.setAIColumn(column + maxSpaceLength);
				}
			}
		}else if(maxLengthName.equalsIgnoreCase("countQiZiTop")){
			System.out.println("-----------------3方案countQiZiTop----------------");
			for(int index = 0; index < this.countMaxTopList.size();index++)
			{
				if(this.countMaxTopList.get(index) != 0){
					maxSpaceLength++;
				}else{
					break;
				}
			}
			
			if(countQiZiTop == 4 && clashMode){
				this.setAIRow(row + 1);
				this.setAIColumn(column);
			}else{
				if(maxSpaceLength >= maxLength || maxSpaceLength ==0){
					this.setAIRow(row - maxLength);
					this.setAIColumn(column);
				}else{
					this.setAIRow(row - maxSpaceLength);
					this.setAIColumn(column);
				}
			}
		}else if(maxLengthName.equalsIgnoreCase("countQiZiDown")){
			System.out.println("-----------------4方案countQiZiDown----------------");
			for(int index = 0; index < this.countMaxDownList.size();index++)
			{
				if(this.countMaxDownList.get(index) != 0){
					maxSpaceLength++;
				}else{
					break;
				}
			}
			
			if(countQiZiDown == 4 && clashMode){
				this.setAIRow(row - 1);
				this.setAIColumn(column);
			}else{
				if(maxSpaceLength >= maxLength || maxSpaceLength ==0){
					this.setAIRow(row + maxLength);
					this.setAIColumn(column);	
				}else{
					this.setAIRow(row + maxSpaceLength);
					this.setAIColumn(column);
				}
				
			}
		}else if(maxLengthName.equalsIgnoreCase("countQiZiLeftTop")){
			System.out.println("-----------------5方案countQiZiLeftTop----------------");
			for(int index = 0; index < this.countMaxLeftTopList.size();index++)
			{
				if(this.countMaxLeftTopList.get(index) != 0){
					maxSpaceLength++;
				}else{
					break;
				}
			}
			
			if(countQiZiLeftTop == 4 && clashMode){
				this.setAIRow(row + 1);
				this.setAIColumn(column + 1);
			}else{
				if(maxSpaceLength >= maxLength || maxSpaceLength ==0){
					this.setAIRow(row - maxLength);
					this.setAIColumn(column - maxLength);
				}else{
					this.setAIRow(row - maxSpaceLength);
					this.setAIColumn(column - maxSpaceLength);
				}
			}
		}else if(maxLengthName.equalsIgnoreCase("countQiZiRightDown")){
			System.out.println("-----------------6方案countQiZiRightDown----------------");
			for(int index = 0; index < this.countMaxRightDownList.size();index++)
			{
				if(this.countMaxRightDownList.get(index) != 0){
					maxSpaceLength++;
				}else{
					break;
				}
			}
			
			if(countQiZiRightDown == 4 && clashMode){
				this.setAIRow(row - 1);
				this.setAIColumn(column - 1);
			}else{
				if(maxSpaceLength >= maxLength || maxSpaceLength ==0){
					this.setAIRow(row + maxLength);
					this.setAIColumn(column + maxLength);
				}else{
					this.setAIRow(row + maxSpaceLength);
					this.setAIColumn(column + maxSpaceLength);
				}
			}
		}else if(maxLengthName.equalsIgnoreCase("countQiZiLeftDown")){
			System.out.println("-----------------7方案countQiZiLeftDown----------------");
			for(int index = 0; index < this.countMaxLeftDownList.size();index++)
			{
				if(this.countMaxLeftDownList.get(index) != 0){
					maxSpaceLength++;
				}else{
					break;
				}
			}
			
			if(countQiZiLeftDown == 4 && clashMode){
				this.setAIRow(row - 1);
				this.setAIColumn(column + 1);
			}else{
				if(maxSpaceLength >= maxLength || maxSpaceLength ==0){
					this.setAIRow(row + maxLength);
					this.setAIColumn(column - maxLength);
				}else{
					this.setAIRow(row + maxSpaceLength);
					this.setAIColumn(column - maxSpaceLength);
				}
			}
		}else if(maxLengthName.equalsIgnoreCase("countQiZiRightTop")){
			System.out.println("-----------------8方案countQiZiRightTop----------------");
			for(int index = 0; index < this.countMaxRightTopList.size();index++)
			{
				if(this.countMaxRightTopList.get(index) != 0){
					maxSpaceLength++;
				}else{
					break;
				}
			}
			
			if(countQiZiRightTop == 4 && clashMode){
				this.setAIRow(row + 1);
				this.setAIColumn(column -1);
			}else{
				if(maxSpaceLength >= maxLength || maxSpaceLength ==0){
					this.setAIRow(row - maxLength);
					this.setAIColumn(column + maxLength);
				}else{
					this.setAIRow(row - maxSpaceLength);
					this.setAIColumn(column + maxSpaceLength);
				}
			}
		}
		
		System.out.println("--------------------AI计算的坐标--------------------");
		System.out.println("AIRow = " + AIRow + " ; AIColumn = " + AIColumn);
		String location = this.getAIRow() + "/" + this.getAIColumn();
		return location;
	}
	
	public ArrayList<String> sortEntities(ArrayList<String> dataList)
	{
		int size = dataList.size();
		for(int i=0;i<size;++i)
		{
			for(int j = 0;j<size - i -1;++j)
			{
				String temp1 = dataList.get(j);
				String temp2 = dataList.get(j+1);
				String[] data1 = temp1.split("/");
				String[] data2 = temp2.split("/");
				
				if(Integer.parseInt(data1[2]) > Integer.parseInt(data2[2])) 
				{  
					dataList.remove(j);
					dataList.remove(j);
					dataList.add(j,temp1);
					dataList.add(j,temp2);
				}  
			}
		}
		
		System.out.println("---------------------得到新数列---------------------");
		for(int index=0;index<size;index++)
		{
			System.out.println(dataList.get(index));
		}
		
		return dataList;
	}
	
	public void leftTopSearch(int row,int column,String[][] data,String player) 
	{
		if(row<0 || row==maxRow || column < 0 || column==maxColumn)
		{
			return;
		}else{
			if(data[row][column] == null){
				this.countMaxLeftTopList.add(0);     //"0"表示空格
			}else if(data[row][column] == player){
				this.countMaxLeftTopList.add(1);     //"1"表示己方棋子数
			}else{
				this.countMaxLeftTopList.add(2);     //"2"表示对方棋子数
			}
		}
		this.leftTopSearch(row-1, column-1,data,player);
	}
	
	public void rightDownSearch(int row,int column,String[][] data,String player)
	{
		if(row<0 || row==maxRow || column < 0 || column==maxColumn)
		{
			return;
		}else{
			if(data[row][column] == null){
				this.countMaxRightDownList.add(0);
			}else if(data[row][column] == player){
				this.countMaxRightDownList.add(1);
			}else{
				this.countMaxRightDownList.add(2);
			}
		}
		this.rightDownSearch(row+1, column+1,data,player);
	}
	
	public void leftDownSearch(int row,int column,String[][] data,String player)
	{
		if(row<0 || row==maxRow || column < 0 || column==maxColumn)
		{
			return;
		}else{
			if(data[row][column] == null){
				this.countMaxLeftDownList.add(0);
			}else if(data[row][column] == player){
				this.countMaxLeftDownList.add(1);
			}else{
				this.countMaxLeftDownList.add(2);
			}
		}
		this.leftDownSearch(row+1, column-1,data, player);		
	}
	
	public void rightTopSearch(int row,int column,String[][] data,String player)
	{
		if(row<0 || row==maxRow || column < 0 || column==maxColumn)
		{
			return;
		}else{
			if(data[row][column] == null){
				this.countMaxRightTopList.add(0);
			}else if(data[row][column] == player){
				this.countMaxRightTopList.add(1);
			}else{
				this.countMaxRightTopList.add(2);
			}
		}
		this.rightTopSearch(row-1, column+1,data, player);
	}
	
	public void leftSearch(int row,int column,String[][] data,String player)
	{
		if(row<0 || row==maxRow || column < 0 || column==maxColumn)
		{
			return;
		}else{
			if(data[row][column] == null){
				this.countMaxLeftList.add(0);
			}else if(data[row][column] == player){
				this.countMaxLeftList.add(1);
			}else{
				this.countMaxLeftList.add(2);
			}
		}
		this.leftSearch(row, column-1,data, player);
	}
	
	public void rightSearch(int row,int column,String[][] data,String player)
	{
		if(row<0 || row==maxRow || column < 0 || column==maxColumn)
		{
			return;
		}else{
			if(data[row][column] == null){
				this.countMaxRightList.add(0);
			}else if(data[row][column] == player){
				this.countMaxRightList.add(1);
			}else{
				this.countMaxRightList.add(2);
			}
		}
		this.rightSearch(row, column+1,data, player);		
	}
	
	public void topSearch(int row,int column,String[][] data,String player)
	{
		if(row<0 || row==maxRow || column < 0 || column==maxColumn)
		{
			return;
		}else{
			if(data[row][column] == null){
				this.countMaxTopList.add(0);
			}else if(data[row][column] == player){
				this.countMaxTopList.add(1);
			}else{
				this.countMaxTopList.add(2);
			}
		}
		this.topSearch(row-1, column,data, player);	
	}
	
	public void downSearch(int row,int column,String[][] data,String player)
	{
		if(row<0 || row==maxRow || column < 0 || column==maxColumn)
		{
			return;
		}else{
			if(data[row][column] == null){
				this.countMaxDownList.add(0);
			}else if(data[row][column] == player){
				this.countMaxDownList.add(1);
			}else{
				this.countMaxDownList.add(2);
			}
		}
		this.downSearch(row+1, column,data, player);
	}
	
	public int getAIRow() 
	{
		return AIRow;
	}

	public void setAIRow(int row) 
	{
		this.AIRow = row;
	}

	public int getAIColumn() 
	{
		return AIColumn;
	}

	public void setAIColumn(int column)
	{
		this.AIColumn = column;
	}
	
	private ArrayList<String> dataList1; //储存当前位置八个方向的参数字符串值
	
	//记录从当前位置向各方向棋子偏移最大值
	private int countQiZiLeft = 0;
	private int countQiZiRight = 0;
	private int countQiZiTop = 0;
	private int countQiZiDown = 0;
	private int countQiZiLeftTop = 0;
	private int countQiZiRightDown = 0;
	private int countQiZiLeftDown = 0;
	private int countQiZiRightTop = 0;
	
	//记录各方向偏移最大长度，不管空格、己方棋子还是对方棋子，直至边界
	private int maxLengthLeft = 0;
	private int maxLengthRight = 0;
	private int maxLengthTop = 0;
	private int maxLengthDown = 0;
	private int maxLengthLeftTop = 0;
	private int maxLengthRightDown = 0;
	private int maxLengthLeftDown = 0;
	private int maxLengthRightTop = 0;
	
	//记录各方向偏移加权值，规则是遇到空格+1,遇到己方棋子数值翻倍，直至遇到对方棋子
	private int maxLengthLeftPriority = 0;
	private int maxLengthRightPriority = 0;
	private int maxLengthTopPriority = 0;
	private int maxLengthDownPriority = 0;
	private int maxLengthLeftTopPriority = 0;
	private int maxLengthRightDownPriority = 0;
	private int maxLengthLeftDownPriority = 0;
	private int maxLengthRightTopPriority = 0;

	//用于储存各方向偏移各空格的状态，0表示空格，1表示己方棋子，2表示对方棋子
	private ArrayList<Integer> countMaxLeftList;
	private ArrayList<Integer> countMaxRightList;
	private ArrayList<Integer> countMaxTopList;
	private ArrayList<Integer> countMaxDownList;
	private ArrayList<Integer> countMaxLeftTopList;
	private ArrayList<Integer> countMaxRightDownList;
	private ArrayList<Integer> countMaxLeftDownList;
	private ArrayList<Integer> countMaxRightTopList;
	
	private int maxLength;           //记录经筛选后的位置偏移值，供AI参考计算
	private int AIRow;               //记录AI计算的行位置
	private int AIColumn;            //记录AI计算的列位置
	private String maxLengthName;    //记录AI计算的偏移方向名称，供AI参考计算
	private int maxRow = 10;
	private int maxColumn = 8;
}

