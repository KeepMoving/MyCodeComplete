package unit_2_8.SAXTest;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXTest 
{
	public static void main(String[] args) 
	{
		String url;
		if(args.length == 0)
		{
			url = "http://www.w3c.org";
			System.out.println("Using " + url);
		}else{
			url = args[0];
		}
		
		DefaultHandler handler = new DefaultHandler()
		{
			public void startElement(String namespaceURI,String lname,String qname,Attributes attrs)
			{
				if(lname.equals("a")&&attrs != null)
				{
					for(int i=0;i<attrs.getLength();i++)
					{
						String aname = attrs.getLocalName(i);
						if(aname.equals("href"))
							System.out.println(attrs.getValue(i));
					}
				}
			}
		};
		
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			factory.setNamespaceAware(true);
			SAXParser saxParser = factory.newSAXParser();
			InputStream in = new URL(url).openStream();
			saxParser.parse(in, handler);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
