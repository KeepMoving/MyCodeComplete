package unit_1_9.hrefMatch;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HrefMatch 
{
	public static void main(String[] args) 
	{
		try {
			String urlString;
			if(args.length>0)
				urlString = args[0];
			else
				urlString = "http://java.sun.com";
			
			InputStreamReader in = new InputStreamReader(new URL(urlString).openStream());
			
			StringBuilder input = new StringBuilder();
			int ch;
			while((ch = in.read()) != -1)
				input.append((char) ch);
			
			String patternString = "<a\\s + href\\s*=\\s*(\"[^\"]*\"|[^\\s>]*)\\s*>";
			Pattern pattern = Pattern.compile(patternString,Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(input);
			
			while(matcher.find())
			{
				int start = matcher.start();
				int end = matcher.end();
				String match = input.substring(start,end);
				System.out.println(match);
			}
		} catch (MalformedURLException murle) {
			// TODO Auto-generated catch block
			System.out.println("MalformedURLException:" + murle.getMessage());
		} catch (IOException ioe) {
			// TODO Auto-generated catch block
			System.out.println("IOException:" + ioe.getMessage());
		}
	}
}
