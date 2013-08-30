package unit_2_0.XMLReadTest;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
/*第三种 JDOM实现方法*/

public class MyXMLReader2JDOM 
{
	public static void main(String[] args) 
	{
		long lasting = System.currentTimeMillis();
		
		try {
			SAXBuilder builder = new SAXBuilder();
			Document doc = builder.build(new File("CJII.chapter2.XML\\unit_2_0\\XMLReadTest\\data_10k.xml"));
			Element foo = doc.getRootElement();
			List allChildren = foo.getChildren();
			for (int i = 0; i < allChildren.size(); i++) 
			{
				System.out.print("车牌号码:"+ ((Element) allChildren.get(i)).getChild("NO").getText());
				System.out.println("车主地址:"+ ((Element) allChildren.get(i)).getChild("ADDR").getText());
			}
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
