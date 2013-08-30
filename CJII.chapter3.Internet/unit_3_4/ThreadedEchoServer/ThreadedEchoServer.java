package unit_3_4.ThreadedEchoServer;
/*This program implements a multithread server that listens to port 8189 and echoes back.*/
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ThreadedEchoServer 
{
	public static void main(String[] args) 
	{
		try {
			int i = 1;
			ServerSocket s = new ServerSocket(8189);
			
			while(true)
			{
				Socket incoming = s.accept();
				System.out.println("Spawing " + i);
				Runnable r = new ThreadedEchoHandler(incoming);
				Thread t = new Thread(r);
				System.out.println(t.getName() + " start!");
				t.start();
				i++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IOException:" + e.getMessage());
			e.printStackTrace();
		}
	}
}
