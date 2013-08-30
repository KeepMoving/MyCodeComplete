package unit_3_3.EchoServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer 
{
	public static void main(String[] args) 
	{
		try {
			ServerSocket s = new ServerSocket(8189);
			Socket incoming = s.accept();//注意服务器的读写都由同一个Socket标示
			
			try {
				InputStream inStream = incoming.getInputStream();
				OutputStream outStream = incoming.getOutputStream();
				
				Scanner in = new Scanner(inStream);//读客户机传送过来的字符串流
				PrintWriter out = new PrintWriter(outStream,true /*autoFlush*/);
				//由服务器向客户机写"Hello!Enter BYE to exit."字符串
				out.println("Hello!Enter BYE to exit.");
				
				boolean done = false;
				while(!done && in.hasNextLine())
				{
					String line = in.nextLine();
					out.println("Echo: " + line);//向客户机流中返回读入的字符串
					if(line.trim().equals("BYE"))
						done = true;
				}
			}finally{
				incoming.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
