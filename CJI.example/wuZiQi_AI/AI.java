package wuZiQi_AI;

import java.util.ArrayList;

public class AI 
{
	public AI(int row,int column,String[][] data,String player)
	{
		this.AIRow = row;
		this.AIColumn = column;
		this.leftSearch(row, column, data, player);
		this.rightSearch(row, column, data, player);
		this.topSearch(row, column, data, player);
		this.downSearch(row, column, data, player);
		this.leftTopSearch(row, column, data, player);
		this.rightDownSearch(row, column, data, player);
		this.leftDownSearch(row, column, data, player);
		this.rightTopSearch(row, column, data, player);
		
		String QiZiLeft = "countQiZiLeft" + "/" + this.countQiZiLeft;
		String QiZiRight = "countQiZiRight" + "/" + this.countQiZiRight;
		String QiZiTop = "countQiZiTop" + "/" + this.countQiZiTop;
		String QiZiDown = "countQiZiDown" + "/" + this.countQiZiDown;
		String QiZiLeftTop = "countQiZiLeftTop" + "/" + this.countQiZiLeftTop;
		String QiZiRightDown = "countQiZiRightDown" + "/" + this.countQiZiRightDown;
		String QiZiLeftDown = "countQiZiLeftDown" + "/" + this.countQiZiLeftDown;
		String QiZiRightTop = "countQiZiRightTop" + "/" + this.countQiZiRightTop;
		
		dataList = new ArrayList<String>();
		dataList.add(QiZiLeft);
		dataList.add(QiZiRight);
		dataList.add(QiZiTop);
		dataList.add(QiZiDown);
		dataList.add(QiZiLeftTop);
		dataList.add(QiZiRightDown);
		dataList.add(QiZiLeftDown);
		dataList.add(QiZiRightTop);
	}
	
	public String computerLocation(int row,int column)
	{
		ArrayList<String> data = this.sortEntities(dataList);
		System.out.println("得到元素：" + (String)data.get(7));
		String[] maxLengthEntity = ((String)data.get(7)).split("/");
		System.out.println("得到元素maxLengthEntity[0] = " + maxLengthEntity[0]);
		
		if(maxLengthEntity[0].equalsIgnoreCase("countQiZiLeft")){
			System.out.println("-----------------1方案countQiZiLeft----------------");
			this.setAIRow(row);
			this.setAIColumn(column - countQiZiLeft);
		}else if(maxLengthEntity[0].equalsIgnoreCase("countQiZiRight")){
			System.out.println("-----------------2方案countQiZiRight----------------");
			this.setAIRow(row);
			this.setAIColumn(column + countQiZiRight);
		}else if(maxLengthEntity[0].equalsIgnoreCase("countQiZiTop")){
			System.out.println("-----------------3方案countQiZiTop----------------");
			this.setAIRow(row - countQiZiTop);
			this.setAIColumn(column);
		}else if(maxLengthEntity[0].equalsIgnoreCase("countQiZiDown")){
			System.out.println("-----------------4方案countQiZiDown----------------");
			this.setAIRow(row + countQiZiDown);
			this.setAIColumn(column);
		}else if(maxLengthEntity[0].equalsIgnoreCase("countQiZiLeftTop")){
			System.out.println("-----------------5方案countQiZiLeftTop----------------");
			this.setAIRow(row - countQiZiLeftTop);
			this.setAIColumn(column - countQiZiLeftTop);
		}else if(maxLengthEntity[0].equalsIgnoreCase("countQiZiRightDown")){
			System.out.println("-----------------6方案countQiZiRightDown----------------");
			this.setAIRow(row + countQiZiRightDown);
			this.setAIColumn(column + countQiZiRightDown);
		}else if(maxLengthEntity[0].equalsIgnoreCase("countQiZiLeftDown")){
			System.out.println("-----------------7方案countQiZiLeftDown----------------");
			this.setAIRow(row + countQiZiLeftDown);
			this.setAIColumn(column - countQiZiLeftDown);
		}else if(maxLengthEntity[0].equalsIgnoreCase("countQiZiRightTop")){
			System.out.println("-----------------8方案countQiZiRightTop----------------");
			this.setAIRow(row - countQiZiRightTop);
			this.setAIColumn(column + countQiZiRightTop);
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
				
				if(Integer.parseInt(data1[1]) > Integer.parseInt(data2[1])) 
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
		if(row<0 || row==10 || column < 0 || column==8 || data[row][column] != player)
		{
			return;
		}else{
			countQiZiLeftTop++;
		}
		this.leftTopSearch(row-1, column-1,data,player);
	}
	
	public void rightDownSearch(int row,int column,String[][] data,String player)
	{
		if(row<0 || row==10 || column < 0 || column==8 || data[row][column] != player)
		{
			return;
		}else{
			countQiZiRightDown++;
		}
		this.rightDownSearch(row+1, column+1,data,player);
	}
	
	public void leftDownSearch(int row,int column,String[][] data,String player)
	{
		if(row<0 || row==10 || column < 0 || column==8 || data[row][column] != player)
		{
			return;
		}else{
			countQiZiLeftDown++;
		}
		this.leftDownSearch(row+1, column-1,data, player);		
	}
	
	public void rightTopSearch(int row,int column,String[][] data,String player)
	{
		if(row<0 || row==10 || column < 0 || column==8 || data[row][column] != player)
		{
			return;
		}else{
			countQiZiRightTop++;
		}
		this.rightTopSearch(row-1, column+1,data, player);
	}
	
	public void leftSearch(int row,int column,String[][] data,String player)
	{
		if(row<0 || row==10 || column < 0 || column==8 || data[row][column] != player)
		{
			return;
		}else{
			countQiZiLeft++;
		}
		this.leftSearch(row, column-1,data, player);
	}
	
	public void rightSearch(int row,int column,String[][] data,String player)
	{
		if(row<0 || row==10 || column < 0 || column==8 || data[row][column] != player)
		{
			return;
		}else{
			countQiZiRight++;
		}
		this.rightSearch(row, column+1,data, player);		
	}
	
	public void topSearch(int row,int column,String[][] data,String player)
	{
		if(row<0 || row==10 || column < 0 || column==8 || data[row][column] != player)
		{
			return;
		}else{
			countQiZiTop++;
		}
		this.topSearch(row-1, column,data, player);	
	}
	
	public void downSearch(int row,int column,String[][] data,String player)
	{
		if(row<0 || row==10 || column < 0 || column==8 || data[row][column] != player)
		{
			return;
		}else{
			countQiZiDown++;
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
	
	private ArrayList<String> dataList;
	private int countQiZiLeft = 0;
	private int countQiZiRight = 0;
	private int countQiZiTop = 0;
	private int countQiZiDown = 0;
	private int countQiZiLeftTop = 0;
	private int countQiZiRightDown = 0;
	private int countQiZiLeftDown = 0;
	private int countQiZiRightTop = 0;
	private int AIRow;
	private int AIColumn;
}

