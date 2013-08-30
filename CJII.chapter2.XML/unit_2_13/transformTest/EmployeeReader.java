package unit_2_13.transformTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import org.xml.sax.ContentHandler;
import org.xml.sax.DTDHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.AttributesImpl;

public class EmployeeReader implements XMLReader 
{	
	public ContentHandler getContentHandler() {
		// TODO Auto-generated method stub
		return handler;
	}

	public DTDHandler getDTDHandler() {
		// TODO Auto-generated method stub
		return null;
	}

	public EntityResolver getEntityResolver() {
		// TODO Auto-generated method stub
		return null;
	}

	public ErrorHandler getErrorHandler() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean getFeature(String arg0) throws SAXNotRecognizedException,
			SAXNotSupportedException {
		// TODO Auto-generated method stub
		return false;
	}

	public Object getProperty(String arg0) throws SAXNotRecognizedException,
			SAXNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	public void parse(InputSource source) throws IOException, SAXException 
	{
		InputStream stream = source.getByteStream();
		BufferedReader in = new BufferedReader(new InputStreamReader(stream));
		String rootElement = "staff";
		AttributesImpl atts = new AttributesImpl();
		
		if(handler == null)
			throw new SAXException("No content handler");
		
		handler.startDocument();
		handler.startElement("", rootElement, rootElement, atts);
		String line;
		while((line = in.readLine()) != null)
		{
			handler.startElement("", "employee", "employee", atts);
			StringTokenizer t = new StringTokenizer(line,"|");
			
			handler.startElement("", "name", "name", atts);
			String s = t.nextToken();
			handler.characters(s.toCharArray(), 0, s.length());
			handler.endElement("", "name", "name");
			
			handler.startElement("", "salary", "salary", atts);
			s = t.nextToken();
			handler.characters(s.toCharArray(), 0, s.length());
			handler.endElement("", "salary", "salary");
			
			atts.addAttribute("", "year", "year", "CDATA", t.nextToken());
			atts.addAttribute("", "month", "month", "CDATA", t.nextToken());
			atts.addAttribute("", "day", "day", "CDATA", t.nextToken());
			handler.startElement("", "hiredate", "hiredate", atts);
			handler.endElement("", "hiredate", "hiredate");
			atts.clear();
			
			handler.endElement("", "employee", "employee");
		}
		
		handler.endElement("", rootElement, rootElement);
		handler.endDocument();
	}

	public void parse(String arg0) throws IOException, SAXException {
		// TODO Auto-generated method stub

	}

	public void setContentHandler(ContentHandler newValue) {
		// TODO Auto-generated method stub
		handler = newValue;
	}

	public void setDTDHandler(DTDHandler arg0) {
		// TODO Auto-generated method stub

	}

	public void setEntityResolver(EntityResolver arg0) {
		// TODO Auto-generated method stub

	}

	public void setErrorHandler(ErrorHandler arg0) {
		// TODO Auto-generated method stub

	}

	public void setFeature(String arg0, boolean arg1)
			throws SAXNotRecognizedException, SAXNotSupportedException {
		// TODO Auto-generated method stub

	}

	public void setProperty(String arg0, Object arg1)
			throws SAXNotRecognizedException, SAXNotSupportedException {
		// TODO Auto-generated method stub

	}

	private ContentHandler handler;
}
