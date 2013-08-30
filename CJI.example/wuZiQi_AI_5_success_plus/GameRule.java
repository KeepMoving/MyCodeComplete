package wuZiQi_AI_5_success_plus;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class GameRule 
{
	public GameRule()
	{
		try {
			Properties props = new Properties();
			FileInputStream in = new FileInputStream("D:\\MyProject\\MyCodeComplete\\CJI.example\\wuZiQi_AI_5_success_plus\\model.properties");
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
	}
	
	public boolean isTheWinnerA(int row,int column,String[][] data)
	{
		System.out.println("------------------------isTheWinnerA------------------------");
		this.leftSearch(row, column, data, "A");
		this.rightSearch(row, column, data, "A");
		this.topSearch(row, column, data, "A");
		this.downSearch(row, column, data, "A");
		this.leftTopSearch(row, column, data, "A");
		this.rightDownSearch(row, column, data, "A");
		this.leftDownSearch(row, column, data, "A");
		this.rightTopSearch(row, column, data, "A");
		
		System.out.println("countQiZiLeft = " + countQiZiLeft);
		System.out.println("countQiZiRight = " + countQiZiRight);
		System.out.println("countQiZiTop = " + countQiZiTop);
		System.out.println("countQiZiDown = " + countQiZiDown);
		System.out.println("countQiZiLeftTop = " + countQiZiLeftTop);
		System.out.println("countQiZiRightDown = " + countQiZiRightDown);
		System.out.println("countQiZiLeftDown = " + countQiZiLeftDown);
		System.out.println("countQiZiRightTop = " + countQiZiRightTop);
		
		if(countQiZiTop + countQiZiDown >= 4)
		{
			return true;
		}
		if(countQiZiLeft + countQiZiRight >= 4)
		{
			return true;
		}
		if(countQiZiLeftTop + countQiZiRightDown >= 4)
		{
			return true;
		}
		if(countQiZiLeftDown + countQiZiRightTop >= 4)
		{
			return true;
		}
		return false;
	}
	
	public boolean isTheWinnerB(int row,int column,String[][] data)
	{
		System.out.println("------------------------isTheWinnerB------------------------");
		this.leftSearch(row, column, data, "B");
		this.rightSearch(row, column, data, "B");
		this.topSearch(row, column, data, "B");
		this.downSearch(row, column, data, "B");
		this.leftTopSearch(row, column, data, "B");
		this.rightDownSearch(row, column, data, "B");
		this.leftDownSearch(row, column, data, "B");
		this.rightTopSearch(row, column, data, "B");
		
		System.out.println("countQiZiLeft = " + countQiZiLeft);
		System.out.println("countQiZiRight = " + countQiZiRight);
		System.out.println("countQiZiTop = " + countQiZiTop);
		System.out.println("countQiZiDown = " + countQiZiDown);
		System.out.println("countQiZiLeftTop = " + countQiZiLeftTop);
		System.out.println("countQiZiRightDown = " + countQiZiRightDown);
		System.out.println("countQiZiLeftDown = " + countQiZiLeftDown);
		System.out.println("countQiZiRightTop = " + countQiZiRightTop);
		
		if(countQiZiTop + countQiZiDown > 4)
		{
			return true;
		}
		if(countQiZiLeft + countQiZiRight > 4)
		{
			return true;
		}
		if(countQiZiLeftTop + countQiZiRightDown > 4)
		{
			return true;
		}
		if(countQiZiLeftDown + countQiZiRightTop > 4)
		{
			return true;
		}
		return false;
	}
	
	public void leftTopSearch(int row,int column,String[][] data,String player) //player == "A";
	{
//		System.out.println("leftTopSearch : data[" + row + "][" + column + "] = " + data[row][column]);
		if(row<0 || row==maxRow || column < 0 || column==maxColumn || data[row][column] != player)
		{
			return;
		}else{
			countQiZiLeftTop++;
		}
		this.leftTopSearch(row-1, column-1,data,player);
	}
	
	public void rightDownSearch(int row,int column,String[][] data,String player)
	{
//		System.out.println("rightDownSearch : data[" + row + "][" + column + "] = " + data[row][column]);
		if(row<0 || row==maxRow || column < 0 || column==maxColumn || data[row][column] != player)
		{
			return;
		}else{
			countQiZiRightDown++;
		}
		this.rightDownSearch(row+1, column+1,data,player);
	}
	
	public void leftDownSearch(int row,int column,String[][] data,String player)
	{
//		System.out.println("leftDownSearch : data[" + row + "][" + column + "] = " + data[row][column]);
		if(row<0 || row==maxRow || column < 0 || column==maxColumn || data[row][column] != player)
		{
			return;
		}else{
			countQiZiLeftDown++;
		}
		this.leftDownSearch(row+1, column-1,data, player);		
	}
	
	public void rightTopSearch(int row,int column,String[][] data,String player)
	{
//		System.out.println("rightTopSearch : data[" + row + "][" + column + "] = " + data[row][column]);
		if(row<0 || row==maxRow || column < 0 || column==maxColumn || data[row][column] != player)
		{
			return;
		}else{
			countQiZiRightTop++;
		}
		this.rightTopSearch(row-1, column+1,data, player);
	}
	
	public void leftSearch(int row,int column,String[][] data,String player)
	{
//		System.out.println("leftSearch : data[" + row + "][" + column + "] = " + data[row][column]);
		if(row<0 || row==maxRow || column < 0 || column==maxColumn || data[row][column] != player)
		{
			return;
		}else{
			countQiZiLeft++;
		}
		this.leftSearch(row, column-1,data, player);
	}
	
	public void rightSearch(int row,int column,String[][] data,String player)
	{
//		System.out.println("rightSearch : data[" + row + "][" + column + "] = " + data[row][column]);
		if(row<0 || row==maxRow || column < 0 || column==maxColumn || data[row][column] != player)
		{
			return;
		}else{
			countQiZiRight++;
		}
		this.rightSearch(row, column+1,data, player);		
	}
	
	public void topSearch(int row,int column,String[][] data,String player)
	{
//		System.out.println("topSearch : data[" + row + "][" + column + "] = " + data[row][column]);
		if(row<0 || row==maxRow || column < 0 || column==maxColumn || data[row][column] != player)
		{
			return;
		}else{
			countQiZiTop++;
		}
		this.topSearch(row-1, column,data, player);	
	}
	
	public void downSearch(int row,int column,String[][] data,String player)
	{
//		System.out.println("downSearch : data[" + row + "][" + column + "] = " + data[row][column]);
		if(row<0 || row==maxRow || column < 0 || column==maxColumn || data[row][column] != player)
		{
			return;
		}else{
			countQiZiDown++;
		}
		this.downSearch(row+1, column,data, player);
	}
	
	private int maxRow = 10;
	private int maxColumn = 8;
	
	private int countQiZiLeft = -1;
	private int countQiZiRight = -1;
	private int countQiZiTop = -1;
	private int countQiZiDown = -1;
	private int countQiZiLeftTop = -1;
	private int countQiZiRightDown = -1;
	private int countQiZiLeftDown = -1;
	private int countQiZiRightTop = -1;
}
