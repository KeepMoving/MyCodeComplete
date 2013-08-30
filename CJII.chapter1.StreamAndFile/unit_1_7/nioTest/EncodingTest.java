package unit_1_7.nioTest;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;

public class EncodingTest 
{
	public static void main(String[] args) 
	{
		String input = "你123好";
		Charset charset = Charset.forName("ISO-8859-1");
		CharsetEncoder encoder = charset.newEncoder();
		encoder.onUnmappableCharacter(CodingErrorAction.IGNORE);
		CharsetDecoder decoder = charset.newDecoder();
		CharBuffer buffer = CharBuffer.allocate(32);
		buffer.put(input);
		buffer.flip();
		try {
		    ByteBuffer byteBuffer = encoder.encode(buffer);
		    CharBuffer cbuf = decoder.decode(byteBuffer);
		    System.out.println(cbuf);  //输出123
		} catch (CharacterCodingException e) {
		    e.printStackTrace();
		}  
	}
}
