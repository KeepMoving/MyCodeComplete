package eightQueen;

import static org.junit.Assert.*;

import java.util.Stack;

import org.junit.Test;

public class TestGameRule {

	@Test
	public void testIsLined() {
		Stack<String> locationStack = new Stack<String>();
		locationStack.push("0/0");
		locationStack.push("1/2");
		
		String locationStr = "3/1";
		GameRule gameRule = new GameRule();
		
		assertEquals(false,gameRule.isLined(locationStack, locationStr));
	}
}
