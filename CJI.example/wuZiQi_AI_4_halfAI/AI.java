package wuZiQi_AI_4_halfAI;

import java.util.ArrayList;

public class AI 
{
	public AI(int row,int column,String[][] data,String player)
	{
		this.AIRow = row;
		this.AIColumn = column;
		this.tableData = data;
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
		
//		this.leftSearchMax(row, column, tableData);
//		this.rightSearchMax(row, column, tableData);
//		this.topSearchMax(row, column, tableData);
//		this.downSearchMax(row, column, tableData);
//		this.leftTopSearchMax(row, column, tableData);
//		this.rightDownSearchMax(row, column, tableData);
//		this.leftDownSearchMax(row, column, tableData);
//		this.rightTopSearchMax(row, column, tableData);
		
		maxLengthLeft = this.countMaxLeftList.size();
		for(int index = this.countMaxLeftList.size() - 1; index >= 0;index--)
		{
			if(this.countMaxLeftList.get(index) == 0){
				maxLengthLeft--;
			}else{
				break;
			}
		}
		
		maxLengthRight = this.countMaxRightList.size();
		for(int index = this.countMaxRightList.size() - 1; index >= 0;index--)
		{
			if(this.countMaxRightList.get(index) == 0){
				maxLengthRight--;
			}else{
				break;
			}
		}
		
		maxLengthTop = this.countMaxTopList.size();
		for(int index = this.countMaxTopList.size() - 1; index >= 0;index--)
		{
			if(this.countMaxTopList.get(index) == 0){
				maxLengthTop--;
			}else{
				break;
			}
		}
		
		maxLengthDown = this.countMaxDownList.size();
		for(int index = this.countMaxDownList.size() - 1; index >= 0;index--)
		{
			if(this.countMaxDownList.get(index) == 0){
				maxLengthDown--;
			}else{
				break;
			}
		}
		
		maxLengthLeftTop = this.countMaxLeftTopList.size();
		for(int index = this.countMaxLeftTopList.size() - 1; index >= 0;index--)
		{
			if(this.countMaxLeftTopList.get(index) == 0){
				maxLengthLeftTop--;
			}else{
				break;
			}
		}
		
		maxLengthRightDown = this.countMaxRightDownList.size();
		for(int index = this.countMaxRightDownList.size() - 1; index >= 0;index--)
		{
			if(this.countMaxRightDownList.get(index) == 0){
				maxLengthRightDown--;
			}else{
				break;
			}
		}
		
		maxLengthLeftDown = this.countMaxLeftDownList.size();
		for(int index = this.countMaxLeftDownList.size() - 1; index >= 0;index--)
		{
			if(this.countMaxLeftDownList.get(index) == 0){
				maxLengthLeftDown--;
			}else{
				break;
			}
		}
		
		maxLengthRightTop = this.countMaxRightTopList.size();
		for(int index = this.countMaxRightTopList.size() - 1; index >= 0;index--)
		{
			if(this.countMaxRightTopList.get(index) == 0){
				maxLengthRightTop--;
			}else{
				break;
			}
		}
		
//		String QiZiLeft = "countQiZiLeft" + "/" + this.countQiZiLeft;
//		String QiZiRight = "countQiZiRight" + "/" + this.countQiZiRight;
//		String QiZiTop = "countQiZiTop" + "/" + this.countQiZiTop;
//		String QiZiDown = "countQiZiDown" + "/" + this.countQiZiDown;
//		String QiZiLeftTop = "countQiZiLeftTop" + "/" + this.countQiZiLeftTop;
//		String QiZiRightDown = "countQiZiRightDown" + "/" + this.countQiZiRightDown;
//		String QiZiLeftDown = "countQiZiLeftDown" + "/" + this.countQiZiLeftDown;
//		String QiZiRightTop = "countQiZiRightTop" + "/" + this.countQiZiRightTop;
		
		String MaxLeft = "countQiZiLeft" + "/" + this.maxLengthLeft;
		String MaxRight = "countQiZiRight" + "/" + this.maxLengthRight;
		String MaxTop = "countQiZiTop" + "/" + this.maxLengthTop;
		String MaxDown = "countQiZiDown" + "/" + this.maxLengthDown;
		String MaxLeftTop = "countQiZiLeftTop" + "/" + this.maxLengthLeftTop;
		String MaxRightDown = "countQiZiRightDown" + "/" + this.maxLengthRightDown;
		String MaxLeftDown = "countQiZiLeftDown" + "/" + this.maxLengthLeftDown;
		String MaxRightTop = "countQiZiRightTop" + "/" + this.maxLengthRightTop;	
		
//		dataList = new ArrayList<String>();
//		dataList.add(QiZiLeft);
//		dataList.add(QiZiRight);
//		dataList.add(QiZiTop);
//		dataList.add(QiZiDown);
//		dataList.add(QiZiLeftTop);
//		dataList.add(QiZiRightDown);
//		dataList.add(QiZiLeftDown);
//		dataList.add(QiZiRightTop);
		
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
	
//	public int getComputerNum()
//	{
//		ArrayList<String> data = this.sortEntities(dataList1);
//		String[] maxLengthEntity = null;
//		
//		System.out.println("得到元素：" + (String)data.get(7));
//		maxLengthEntity = ((String)data.get(7)).split("/");
//		System.out.println("得到元素maxLengthEntity[0] = " + maxLengthEntity[0]);
//		
//		return Integer.parseInt(maxLengthEntity[1]);
//	}
	
	public String computerLocation(int row,int column,int computerNum,boolean clashMode)
	{
//		ArrayList<String> data = this.sortEntities(dataList);
		ArrayList<String> data1 = this.sortEntities(dataList1);
		String[] maxLengthEntity = null;
		
		System.out.println("得到元素：" + (String)data1.get(computerNum));
		maxLengthEntity = ((String)data1.get(computerNum)).split("/");
		System.out.println("得到元素maxLengthEntity[0] = " + maxLengthEntity[0]);
		
		this.maxLengthName = maxLengthEntity[0];
		this.maxLength = Integer.parseInt(maxLengthEntity[1]); 
		int maxSpaceLength = 0; 
		
		//////////////////////////////////////////////////////////////////////////////////////
		if(maxLengthName.equalsIgnoreCase("countQiZiLeft")){
			System.out.println("-----------------1方案countQiZiLeft----------------");
			for(int index = 1; index < this.countMaxLeftList.size();index++)
			{
				if(this.countMaxLeftList.get(index) == 0){
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
			for(int index = 1; index < this.countMaxRightList.size();index++)
			{
				if(this.countMaxRightList.get(index) == 0){
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
			for(int index = 1; index < this.countMaxTopList.size();index++)
			{
				if(this.countMaxTopList.get(index) == 0){
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
			for(int index = 1; index < this.countMaxDownList.size();index++)
			{
				if(this.countMaxDownList.get(index) == 0){
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
			for(int index = 1; index < this.countMaxLeftTopList.size();index++)
			{
				if(this.countMaxLeftTopList.get(index) == 0){
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
			for(int index = 1; index < this.countMaxRightDownList.size();index++)
			{
				if(this.countMaxRightDownList.get(index) == 0){
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
			for(int index = 1; index < this.countMaxLeftDownList.size();index++)
			{
				if(this.countMaxLeftDownList.get(index) == 0){
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
			for(int index = 1; index < this.countMaxRightTopList.size();index++)
			{
				if(this.countMaxRightTopList.get(index) == 0){
					maxSpaceLength++;
				}else{
					break;
				}
			}
			
			System.out.println("////////////////////////////////////////////////////////////");
			System.out.println("maxSpaceLength = " + maxSpaceLength);
			System.out.println("maxLength = " + maxLength);
			System.out.println("countQiZiRightTop = " + countQiZiRightTop);
			System.out.println("////////////////////////////////////////////////////////////");
			
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
		if(row<0 || row==10 || column < 0 || column==8)
		{
			return;
		}else{
//			countQiZiLeftTop++;
			if(data[row][column] == null){
				this.countMaxLeftTopList.add(0);
			}else if(data[row][column] == player){
				this.countMaxLeftTopList.add(1);
			}else{
				this.countMaxLeftTopList.add(2);
			}
		}
		this.leftTopSearch(row-1, column-1,data,player);
	}
	
	public void rightDownSearch(int row,int column,String[][] data,String player)
	{
		if(row<0 || row==10 || column < 0 || column==8)
		{
			return;
		}else{
//			countQiZiRightDown++;
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
		if(row<0 || row==10 || column < 0 || column==8)
		{
			return;
		}else{
//			countQiZiLeftDown++;
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
		if(row<0 || row==10 || column < 0 || column==8)
		{
			return;
		}else{
//			countQiZiRightTop++;
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
		if(row<0 || row==10 || column < 0 || column==8)
		{
			return;
		}else{
//			countQiZiLeft++;
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
		if(row<0 || row==10 || column < 0 || column==8)
		{
			return;
		}else{
//			countQiZiRight++;
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
		if(row<0 || row==10 || column < 0 || column==8)
		{
			return;
		}else{
//			countQiZiTop++;
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
		if(row<0 || row==10 || column < 0 || column==8)
		{
			return;
		}else{
//			countQiZiDown++;
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
	
//	public void leftTopSearchMax(int row,int column,String[][] data) 
//	{
//		if(row<0 || row==10 || column < 0 || column==8)
//		{
//			return;
//		}else if(data[row][column] != null){
//			this.countMaxLeftTopList.add(1);
//		}else if(data[row][column] == null){
//			this.countMaxLeftTopList.add(0);
//		}
//		this.leftTopSearchMax(row-1, column-1,data);
//	}
//	
//	public void rightDownSearchMax(int row,int column,String[][] data)
//	{
//		if(row<0 || row==10 || column < 0 || column==8)
//		{
//			return;
//		}else if(data[row][column] != null){
//			this.countMaxRightDownList.add(1);
//		}else if(data[row][column] == null){
//			this.countMaxRightDownList.add(0);
//		}else{
//			this.countMaxRightDownList.add(2);
//		}
//		this.rightDownSearchMax(row+1, column+1,data);
//	}
//	
//	public void leftDownSearchMax(int row,int column,String[][] data)
//	{
//		if(row<0 || row==10 || column < 0 || column==8)
//		{
//			return;
//		}else if(data[row][column] != null){
//			this.countMaxLeftDownList.add(1);
//		}else if(data[row][column] == null){
//			this.countMaxLeftDownList.add(0);
//		}
//		this.leftDownSearchMax(row+1, column-1,data);		
//	}
//	
//	public void rightTopSearchMax(int row,int column,String[][] data)
//	{
//		if(row<0 || row==10 || column < 0 || column==8)
//		{
//			return;
//		}else if(data[row][column] != null){
//			this.countMaxRightTopList.add(1);
//		}else if(data[row][column] == null){
//			this.countMaxRightTopList.add(0);
//		}
//		this.rightTopSearchMax(row-1, column+1,data);
//	}
//	
//	public void leftSearchMax(int row,int column,String[][] data)
//	{
//		if(row<0 || row==10 || column < 0 || column==8)
//		{
//			return;
//		}else if(data[row][column] != null){
//			this.countMaxLeftList.add(1);
//		}else if(data[row][column] == null){
//			this.countMaxLeftList.add(0);
//		}
//		this.leftSearchMax(row, column-1,data);
//	}
//	
//	public void rightSearchMax(int row,int column,String[][] data)
//	{
//		if(row<0 || row==10 || column < 0 || column==8)
//		{
//			return;
//		}else if(data[row][column] != null){
//			this.countMaxRightList.add(1);
//		}else if(data[row][column] == null){
//			this.countMaxRightList.add(0);
//		}
//		this.rightSearchMax(row, column+1,data);		
//	}
//	
//	public void topSearchMax(int row,int column,String[][] data)
//	{
//		if(row<0 || row==10 || column < 0 || column==8)
//		{
//			return;
//		}else if(data[row][column] != null){
//			this.countMaxTopList.add(1);
//		}else if(data[row][column] == null){
//			this.countMaxTopList.add(0);
//		}
//		this.topSearchMax(row-1, column,data);	
//	}
//	
//	public void downSearchMax(int row,int column,String[][] data)
//	{
//		if(row<0 || row==10 || column < 0 || column==8)
//		{
//			return;
//		}else if(data[row][column] != null){
//			this.countMaxDownList.add(1);
//		}else if(data[row][column] == null){
//			this.countMaxDownList.add(0);
//		}
//		this.downSearchMax(row+1, column,data);
//	}
	
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
	
//	private ArrayList<String> dataList;
	private ArrayList<String> dataList1;
	private int countQiZiLeft = 0;
	private int countQiZiRight = 0;
	private int countQiZiTop = 0;
	private int countQiZiDown = 0;
	private int countQiZiLeftTop = 0;
	private int countQiZiRightDown = 0;
	private int countQiZiLeftDown = 0;
	private int countQiZiRightTop = 0;
	
	private int maxLengthLeft = 0;
	private int maxLengthRight = 0;
	private int maxLengthTop = 0;
	private int maxLengthDown = 0;
	private int maxLengthLeftTop = 0;
	private int maxLengthRightDown = 0;
	private int maxLengthLeftDown = 0;
	private int maxLengthRightTop = 0;

	private ArrayList<Integer> countMaxLeftList;
	private ArrayList<Integer> countMaxRightList;
	private ArrayList<Integer> countMaxTopList;
	private ArrayList<Integer> countMaxDownList;
	private ArrayList<Integer> countMaxLeftTopList;
	private ArrayList<Integer> countMaxRightDownList;
	private ArrayList<Integer> countMaxLeftDownList;
	private ArrayList<Integer> countMaxRightTopList;
	
	private int maxLength;
	private int AIRow;
	private int AIColumn;
	private String[][] tableData;
	private String maxLengthName;
}

