package unit_2_0.XMLReadTest;
/*第二种，DOM4J实现方法*/

import java.io.File;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class MyXMLReader2DOM4J 
{
	public static void main(String[] args) 
	{
		try {
			long lasting = System.currentTimeMillis();
			
			File f = new File("CJII.chapter2.XML\\unit_2_0\\XMLReadTest\\data_10k.xml");
			SAXReader reader = new SAXReader();
			Document doc = reader.read(f);
			Element root = doc.getRootElement();
			Element foo;
			for (Iterator i = root.elementIterator("VALUE"); i.hasNext();)
			{
				foo = (Element) i.next();
				System.out.print("车牌号码:" + foo.elementText("NO"));
				System.out.println("车主地址:" + foo.elementText("ADDR"));
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			System.out.println("DocumentException:" + e.getMessage());
			e.printStackTrace();
		}
	}
}
