package unit_2_0.XMLReadTest;
/*第四种SAX实现方法*/

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyXMLReader2SAX extends DefaultHandler 
{
	java.util.Stack tags = new java.util.Stack();
	
	public MyXMLReader2SAX()
	{
		super();
	}
	
	public static void main(String[] args) throws Exception
	{
		long lasting = System.currentTimeMillis();
		try {
			SAXParserFactory sf = SAXParserFactory.newInstance();
			SAXParser sp = sf.newSAXParser();
			MyXMLReader2SAX reader = new MyXMLReader2SAX();
			sp.parse(new InputSource("CJII.chapter2.XML\\unit_2_0\\XMLReadTest\\data_10k.xml"), reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("运行时间：" + (System.currentTimeMillis() - lasting) + "毫秒");
	}

	public void characters(char ch[], int start, int length) throws SAXException 
	{
		String tag = (String) tags.peek();
		if (tag.equals("NO")) 
		{
			System.out.print("车牌号码：" + new String(ch, start, length));
		}
		if (tag.equals("ADDR"))
		{
			System.out.println("地址:" + new String(ch, start, length));
		}
	}

	public void startElement(String uri, String localName, String qName,Attributes attrs)
	{
		tags.push(qName);
	}
}
