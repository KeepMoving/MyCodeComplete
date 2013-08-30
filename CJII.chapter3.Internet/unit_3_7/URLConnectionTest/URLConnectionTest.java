package unit_3_7.URLConnectionTest;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class URLConnectionTest 
{
	public static void main(String[] args) 
	{
		try {
			String urlName;
			if(args.length > 0)
				urlName = args[0];
			else
				urlName = "http://java.sun.com";
			
			URL url = new URL(urlName);
			URLConnection connection = url.openConnection();
			
			//set username,password if specified on command line
			
			if(args.length > 2)
			{
				String username = args[1];
				String password = args[2];
				String input = username + ":" + password;
				String encoding = base64Encode(input);
				connection.setRequestProperty("Authorization", "Basic " + encoding);
			}
			
			connection.connect();
			
			//print header fields
			
			Map<String,List<String>> headers = connection.getHeaderFields();
			for(Map.Entry<String, List<String>>entry:headers.entrySet())
			{
				String key = entry.getKey();
				for(String value:entry.getValue())
					System.out.println(key + ": " + value);
			}
			
			//print convenience functions
			System.out.println("----------------");
			System.out.println("getContentType:" + connection.getContentType());
			System.out.println("getContentLength:" + connection.getContentLength());
			System.out.println("getContentEncoding:" + connection.getContentEncoding());
			System.out.println("getDate:" + connection.getDate());
			System.out.println("getExpiration: " + connection.getExpiration());
			System.out.println("getLastModified" + connection.getLastModified());
			System.out.println("----------------");
			
			Scanner in = new Scanner(connection.getInputStream());
			
			//print first ten lines of contents
			for(int n = 1 ; in.hasNextLine() && n<=10 ; n++)
			{
				System.out.println(in.nextLine());
			}
			if(in.hasNextLine())
				System.out.println(". . .");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * Computes the Base64 encoding of s string
	 * @param s a string
	 * @return the Base 64 encoding
	 * */
	public static String base64Encode(String s)
	{
		ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		Base64OutputStream out = new Base64OutputStream(bOut);
		try {
			out.write(s.getBytes());
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bOut.toString();
	}
}

	

