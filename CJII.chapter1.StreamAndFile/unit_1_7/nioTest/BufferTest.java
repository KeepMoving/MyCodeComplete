package unit_1_7.nioTest;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

public class BufferTest 
{
	public static void main(String[] args) 
	{
		ByteBuffer buffer = ByteBuffer.allocate(32);
		CharBuffer charBuffer = buffer.asCharBuffer();
		String content = charBuffer.put("Hello ").put("World").flip().toString();
		System.out.println(content);
	}
}
