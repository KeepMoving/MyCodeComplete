package unit_3_4.ThreadedEchoServer;
/*This class handles the client input for one server socket connection.*/
/*说白了，就是多线程服务器*/
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ThreadedEchoHandler implements Runnable 
{
	public ThreadedEchoHandler(Socket i)
	{
		incoming = i;
	}
	
	public void run() 
	{
		try {
			try 
			{
				//注意此处的input或者output是相对于服务器而言的
				InputStream inStream = incoming.getInputStream();
				OutputStream outStream = incoming.getOutputStream();
				
				Scanner in = new Scanner(inStream);
				PrintWriter out = new PrintWriter(outStream,true /*autoFlush*/);
				
				out.println("Hello Enter BYE to exit.");
				
				//echo client input
				boolean done = false;
				while(!done && in.hasNextLine())
				{
					String line = in.nextLine();
					out.println("Echo: " + line);
					if(line.trim().equals("BYE"))
						done = true;
				}
			}finally{
				incoming.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IOException:" + e.getMessage());
			e.printStackTrace();
		}
	}

	private Socket incoming;
}
