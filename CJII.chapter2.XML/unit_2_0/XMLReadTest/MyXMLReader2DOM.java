package unit_2_0.XMLReadTest;
/*第一种 DOM 实现方法*/

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class MyXMLReader2DOM 
{
	public static void main(String[] args) 
	{
		long lasting = System.currentTimeMillis();
		 
	    try {
			File f = new File("CJII.chapter2.XML\\unit_2_0\\XMLReadTest\\data_10k.xml");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(f);
			NodeList nl = doc.getElementsByTagName("VALUE");
			for (int i = 0; i < nl.getLength(); i++) 
			{
			    System.out.print("车牌号码:"+ doc.getElementsByTagName("NO").item(i).getFirstChild().getNodeValue());
				System.out.println("车主地址:"+ doc.getElementsByTagName("ADDR").item(i).getFirstChild().getNodeValue());
			}
		} catch (DOMException e) {
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
