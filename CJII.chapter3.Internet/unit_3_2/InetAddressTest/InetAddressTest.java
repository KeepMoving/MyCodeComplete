package unit_3_2.InetAddressTest;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest 
{
	public static void main(String[] args) 
	{
		try {
			if(args.length > 0)
			{
				String host = args[0];
				InetAddress[] addresses = InetAddress.getAllByName(host);
				for(InetAddress a : addresses)
					System.out.println(a);
			}else{
				InetAddress localHostAddress = InetAddress.getLocalHost();
				String[] tokens = localHostAddress.toString().split("/");
				System.out.println(localHostAddress);
				System.out.println("主机名： " + tokens[0]);
				System.out.println("主机地址名： " + tokens[1]);
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			System.out.println("UnknownHostException:" + e.getMessage());
			e.printStackTrace();
		}
	}
}
