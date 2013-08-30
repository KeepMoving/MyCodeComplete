package unit_2_13.transformTest;
/*
 * This program demonstrates XSL transformations. It applies a transformation to a set
 * of employee records.The records are stored in the file employee.dat and turned into XML
 * format.Specify the stylesheet on the command line,e.g. java TransformTest makeprop.xsl
 * */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.xml.sax.InputSource;

public class TransformTest 
{
	public static void main(String[] args) 
	{
		String filename;
		if(args.length>0)
			filename = args[0];
		else
			filename = "makehtml.xsl";
		File styleSheet = new File(filename);
		StreamSource styleSource = new StreamSource(styleSheet);
		
		try {
			Transformer t = TransformerFactory.newInstance().newTransformer(styleSource);
			t.setOutputProperty(OutputKeys.INDENT, "yes");
			t.setOutputProperty(OutputKeys.METHOD, "xml");
			t.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			t.transform(new SAXSource(new EmployeeReader(),new InputSource(new FileInputStream("employee.dat"))), new StreamResult(System.out));
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
