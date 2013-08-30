package unit_1_8.regexTest;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest 
{
	public static void main(String[] args) 
	{
		System.out.println("Enter pattern:");
		Scanner in = new Scanner(System.in);
		String patternString = in.nextLine();
		
		Pattern pattern = null;
		try {
			pattern = Pattern.compile(patternString);
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			System.out.println("RuntimeException:" + e.getMessage());
			System.exit(1);
		}
		
		while(true)
		{
			System.out.println("Enter string to match:");
			String input = in.nextLine();
			if(input == null || input.equals(""))
				return;
			Matcher matcher = pattern.matcher(input);
			if(matcher.matches())
			{
				System.out.println("Match");
				int g = matcher.groupCount();
				if(g>0)
				{
					for(int i = 0; i< input.length(); i++)
					{
						for(int j = 1;j<=g;j++)
							if(i == matcher.start(j))
								System.out.println('(');
						System.out.println(input.charAt(i));
						for(int j=1;j<=9;j++)
							if(i + 1 == matcher.end(j))
								System.out.println(')');
					}
					System.out.println();
				}
			}else{
				System.out.println("No match");
			}
		}
	}
}
