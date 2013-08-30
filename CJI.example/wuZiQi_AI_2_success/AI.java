package wuZiQi_AI_2_success;

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
		
		this.leftSearch(row, column, data, null);
		this.rightSearch(row, column, data, null);
		this.topSearch(row, column, data, null);
		this.downSearch(row, column, data, null);
		this.leftTopSearch(row, column, data, null);
		this.rightDownSearch(row, column, data, null);
		this.leftDownSearch(row, column, data, null);
		this.rightTopSearch(row, column, data, null);
		
		String QiZiLeft = "countQiZiLeft" + "/" + this.countQiZiLeft + "/" + this.countSpaceLeft;
		String QiZiRight = "countQiZiRight" + "/" + this.countQiZiRight + "/" + this.countSpaceRight;
		String QiZiTop = "countQiZiTop" + "/" + this.countQiZiTop + "/" + this.countSpaceTop;
		String QiZiDown = "countQiZiDown" + "/" + this.countQiZiDown + "/" + this.countSpaceDown;
		String QiZiLeftTop = "countQiZiLeftTop" + "/" + this.countQiZiLeftTop + "/" + this.countSpaceLeftTop;
		String QiZiRightDown = "countQiZiRightDown" + "/" + this.countQiZiRightDown + "/" + this.countSpaceRightDown;
		String QiZiLeftDown = "countQiZiLeftDown" + "/" + this.countQiZiLeftDown + "/" + this.countSpaceLeftDown;
		String QiZiRightTop = "countQiZiRightTop" + "/" + this.countQiZiRightTop + "/" + this.countSpaceRightTop;
		
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
	
	public String computerLocation(int row,int column,int computerNum,boolean clashMode)
	{
		ArrayList<String> data = this.sortEntities(dataList);
		String[] maxLengthEntity = null;
		
		System.out.println("得到元素：" + (String)data.get(computerNum));
		maxLengthEntity = ((String)data.get(computerNum)).split("/");
		System.out.println("得到元素maxLengthEntity[0] = " + maxLengthEntity[0]);
		
		String maxLengthName = maxLengthEntity[0];
		int maxLength = Integer.parseInt(maxLengthEntity[1]); 
		int maxSpaceLength = Integer.parseInt(maxLengthEntity[2]); 
		
		if(maxLengthName.equalsIgnoreCase("countQiZiLeft")){
			System.out.println("-----------------1方案countQiZiLeft----------------");
			if(countQiZiLeft == 4 && clashMode){
				this.setAIRow(row);
				this.setAIColumn(column + 1);
			}else{
				if(maxSpaceLength >= maxLength || maxSpaceLength ==0){
					this.setAIRow(row);
					this.setAIColumn(column - countQiZiLeft);
				}else{
					this.setAIRow(row);
					this.setAIColumn(column - maxSpaceLength);
				}
			}
		}else if(maxLengthName.equalsIgnoreCase("countQiZiRight")){
			System.out.println("-----------------2方案countQiZiRight----------------");
			if(countQiZiRight == 4 && clashMode){
				this.setAIRow(row);
				this.setAIColumn(column - 1);
			}else{
				if(maxSpaceLength >= maxLength || maxSpaceLength ==0){
					this.setAIRow(row);
					this.setAIColumn(column + maxSpaceLength);
				}else{
					this.setAIRow(row);
					this.setAIColumn(column + countQiZiRight);
				}
			}
		}else if(maxLengthName.equalsIgnoreCase("countQiZiTop")){
			System.out.println("-----------------3方案countQiZiTop----------------");
			if(countQiZiTop == 4 && clashMode){
				this.setAIRow(row + 1);
				this.setAIColumn(column);
			}else{
				if(maxSpaceLength >= maxLength || maxSpaceLength ==0){
					this.setAIRow(row - countQiZiTop);
					this.setAIColumn(column);
				}else{
					this.setAIRow(row - maxSpaceLength);
					this.setAIColumn(column);
				}
			}
		}else if(maxLengthName.equalsIgnoreCase("countQiZiDown")){
			System.out.println("-----------------4方案countQiZiDown----------------");
			if(countQiZiDown == 4 && clashMode){
				this.setAIRow(row - 1);
				this.setAIColumn(column);
			}else{
				if(maxSpaceLength >= maxLength || maxSpaceLength ==0){
					this.setAIRow(row + countQiZiDown);
					this.setAIColumn(column);	
				}else{
					this.setAIRow(row + maxSpaceLength);
					this.setAIColumn(column);
				}
				
			}
		}else if(maxLengthName.equalsIgnoreCase("countQiZiLeftTop")){
			System.out.println("-----------------5方案countQiZiLeftTop----------------");
			if(countQiZiLeftTop == 4 && clashMode){
				this.setAIRow(row + 1);
				this.setAIColumn(column + 1);
			}else{
				if(maxSpaceLength >= maxLength || maxSpaceLength ==0){
					this.setAIRow(row - countQiZiLeftTop);
					this.setAIColumn(column - countQiZiLeftTop);
				}else{
					this.setAIRow(row - maxSpaceLength);
					this.setAIColumn(column - maxSpaceLength);
				}
			}
			
		}else if(maxLengthName.equalsIgnoreCase("countQiZiRightDown")){
			System.out.println("-----------------6方案countQiZiRightDown----------------");
			if(countQiZiRightDown == 4 && clashMode){
				this.setAIRow(row - 1);
				this.setAIColumn(column - 1);
			}else{
				if(maxSpaceLength >= maxLength || maxSpaceLength ==0){
					this.setAIRow(row + countQiZiRightDown);
					this.setAIColumn(column + countQiZiRightDown);
				}else{
					this.setAIRow(row + maxSpaceLength);
					this.setAIColumn(column + maxSpaceLength);
				}
			}
		}else if(maxLengthName.equalsIgnoreCase("countQiZiLeftDown")){
			System.out.println("-----------------7方案countQiZiLeftDown----------------");
			if(countQiZiLeftDown == 4 && clashMode){
				this.setAIRow(row - 1);
				this.setAIColumn(column + 1);
			}else{
				if(maxSpaceLength >= maxLength || maxSpaceLength ==0){
					this.setAIRow(row + countQiZiLeftDown);
					this.setAIColumn(column - countQiZiLeftDown);
				}else{
					this.setAIRow(row + maxSpaceLength);
					this.setAIColumn(column - maxSpaceLength);
				}
			}
		}else if(maxLengthName.equalsIgnoreCase("countQiZiRightTop")){
			System.out.println("-----------------8方案countQiZiRightTop----------------");
			if(countQiZiRightTop == 4 && clashMode){
				this.setAIRow(row + 1);
				this.setAIColumn(column -1);
			}else{
				if(maxSpaceLength >= maxLength || maxSpaceLength ==0){
					this.setAIRow(row - countQiZiRightTop);
					this.setAIColumn(column + countQiZiRightTop);
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
			if(player != null)
			{
				countQiZiLeftTop++;
			}else{
				countSpaceLeftTop++;
			}
		}
		this.leftTopSearch(row-1, column-1,data,player);
	}
	
	public void rightDownSearch(int row,int column,String[][] data,String player)
	{
		if(row<0 || row==10 || column < 0 || column==8 || data[row][column] != player)
		{
			return;
		}else{
			if(player != null)
			{
				countQiZiRightDown++;
			}else{
				countSpaceRightDown++;
			}
		}
		this.rightDownSearch(row+1, column+1,data,player);
	}
	
	public void leftDownSearch(int row,int column,String[][] data,String player)
	{
		if(row<0 || row==10 || column < 0 || column==8 || data[row][column] != player)
		{
			return;
		}else{
			if(player != null)
			{
				countQiZiLeftDown++;
			}else{
				countSpaceLeftDown++;
			}
		}
		this.leftDownSearch(row+1, column-1,data, player);		
	}
	
	public void rightTopSearch(int row,int column,String[][] data,String player)
	{
		if(row<0 || row==10 || column < 0 || column==8 || data[row][column] != player)
		{
			return;
		}else{
			if(player != null)
			{
				countQiZiRightTop++;
			}else{
				countSpaceRightTop++;
			}
		}
		this.rightTopSearch(row-1, column+1,data, player);
	}
	
	public void leftSearch(int row,int column,String[][] data,String player)
	{
		if(row<0 || row==10 || column < 0 || column==8 || data[row][column] != player)
		{
			return;
		}else{
			if(player != null)
			{
				countQiZiLeft++;
			}else{
				countSpaceLeft++;
			}
		}
		this.leftSearch(row, column-1,data, player);
	}
	
	public void rightSearch(int row,int column,String[][] data,String player)
	{
		if(row<0 || row==10 || column < 0 || column==8 || data[row][column] != player)
		{
			return;
		}else{
			if(player != null)
			{
				countQiZiRight++;
			}else{
				countSpaceRight++;
			}
		}
		this.rightSearch(row, column+1,data, player);		
	}
	
	public void topSearch(int row,int column,String[][] data,String player)
	{
		if(row<0 || row==10 || column < 0 || column==8 || data[row][column] != player)
		{
			return;
		}else{
			if(player != null)
			{
				countQiZiTop++;
			}else{
				countSpaceTop++;
			}
		}
		this.topSearch(row-1, column,data, player);	
	}
	
	public void downSearch(int row,int column,String[][] data,String player)
	{
		if(row<0 || row==10 || column < 0 || column==8 || data[row][column] != player)
		{
			return;
		}else{
			if(player != null)
			{
				countQiZiDown++;
			}else{
				countSpaceDown++;
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
	
	private ArrayList<String> dataList;
	private int countQiZiLeft = 0;
	private int countQiZiRight = 0;
	private int countQiZiTop = 0;
	private int countQiZiDown = 0;
	private int countQiZiLeftTop = 0;
	private int countQiZiRightDown = 0;
	private int countQiZiLeftDown = 0;
	private int countQiZiRightTop = 0;

	private int countSpaceLeft = 0;
	private int countSpaceRight = 0;
	private int countSpaceTop = 0;
	private int countSpaceDown = 0;
	private int countSpaceLeftTop = 0;
	private int countSpaceRightDown = 0;
	private int countSpaceLeftDown = 0;
	private int countSpaceRightTop = 0;
	private int AIRow;
	private int AIColumn;
}

