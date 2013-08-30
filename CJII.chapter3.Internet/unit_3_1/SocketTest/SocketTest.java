package unit_3_1.SocketTest;
/*
 * This program make a socket connection to the local host,and 
 * prints the LocalAddress and the LocalPort.
 * */
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SocketTest 
{
	public static void main(String[] args) 
	{
		try {
			Socket s = new Socket("192.168.81.1",80);
			try {
				System.out.println("LocalAddress = " + s.getLocalAddress());
				System.out.println("LocalPort = " + s.getLocalPort());
				InputStream inStream = s.getInputStream();
				Scanner in = new Scanner(inStream);
				
				while(in.hasNextLine())
				{
					String line = in.nextLine();
					System.out.println(line);
				}
			}finally{
				s.close();
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			System.out.println("UnknownHostException:" + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IOException:" + e.getMessage());
			e.printStackTrace();
		}
	}
}
