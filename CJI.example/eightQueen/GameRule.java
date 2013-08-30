package eightQueen;

import java.util.Stack;

public class GameRule 
{
	public boolean isLined(Stack<String> locationStack,String locationStr)
	{
		Stack<String> locationStackTemp = (Stack<String>)locationStack.clone();
		String locationData[] = locationStr.split("/");
		int locationRow = Integer.parseInt(locationData[0]);
		int locationColumn = Integer.parseInt(locationData[1]);
		int locationExistRow;
		int locationExistColumn;
		while(!locationStackTemp.isEmpty())
		{
			String[] locationExist = locationStackTemp.pop().split("/");
			locationExistRow = Integer.parseInt(locationExist[0]);
			locationExistColumn = Integer.parseInt(locationExist[1]);
			if(locationExistRow == locationRow || locationExistColumn == locationColumn || (locationExistRow-locationRow)==(locationExistColumn-locationColumn))
			{
				return true;
			}
		}
		
		return false;
	}
}
