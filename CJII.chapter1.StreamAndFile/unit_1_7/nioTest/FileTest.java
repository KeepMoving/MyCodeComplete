package unit_1_7.nioTest;
/*
 * 对文件操作方面，文件通道FileChannel提供了与其它通道之间高效传输数据的能力，
 * 比传统的基于流和字节数组作为缓冲区的做法，要来得简单和快速。
 * 比如下面的把一个网页的内容保存到本地文件的实现。
 * */
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

public class FileTest 
{
	public static void main(String[] args) 
	{
		try {
			FileOutputStream output = new FileOutputStream("D:\\MyProject\\MyCodeComplete\\CJII.chapter1.StreamAndFile\\unit_1_7\\nioTest\\baidu.txt");
			FileChannel channel = output.getChannel();
			URL url = new URL("http://www.baidu.com");
			InputStream input = url.openStream();
			ReadableByteChannel readChannel = Channels.newChannel(input);
			channel.transferFrom(readChannel, 0, Integer.MAX_VALUE);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("FileNotFoundException:" + e.getMessage());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			System.out.println("MalformedURLException:" + e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IOException:" + e.getMessage());
		}  
	}
}
