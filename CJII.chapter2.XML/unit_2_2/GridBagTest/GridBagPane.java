package unit_2_2.GridBagTest;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JPanel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class GridBagPane extends JPanel 
{
	public GridBagPane(String filename)
	{
		try {
			setLayout(new GridBagLayout());
			constraints = new GridBagConstraints();
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setValidating(true);
			
			if(filename.contains("-schema"))
			{
				factory.setNamespaceAware(true);
				final String JAXP_SCHEMA_LANGUAGE = "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
				final String W3C_XML_SCHEMA = "http://www.w3.org/2001/XMLSchema";
				factory.setAttribute(JAXP_SCHEMA_LANGUAGE, W3C_XML_SCHEMA);
			}
			
			factory.setIgnoringElementContentWhitespace(true);
			
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(new File(filename));
			
			if(filename.contains("-schema"))
			{
				int count = removeElementContentWhitespace(doc.getDocumentElement());
				System.out.println(count + " whitespace nodes removed.");
			}
			
			parseGridbag(doc.getDocumentElement());
		} catch (IllegalArgumentException e) {
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
	
	private int removeElementContentWhitespace(Element e)
	{
		NodeList children = e.getChildNodes();
		int count = 0;
		boolean allTextChildrenAreWhiteSpace = true;
		int elements = 0;
		for(int i=0;i<children.getLength()&&allTextChildrenAreWhiteSpace;i++)
		{
			Node child = children.item(i);
			if(child instanceof Text && ((Text)child).getData().trim().length()>0)
				allTextChildrenAreWhiteSpace = false;
			else if(child instanceof Element){
				elements++;
				count += removeElementContentWhitespace((Element)child);
			}
		}
		if(elements >0 && allTextChildrenAreWhiteSpace)
		{
			for(int i=children.getLength() - 1;i >= 0;i--)
			{
				Node child = children.item(i);
				if(child instanceof Text)
				{
					e.removeChild(child);
					count++;
				}
			}
		}
		return count;
	}	
	
	public Component get(String name)
	{
		Component[] components = getComponents();
		for(int i=0;i<components.length;i++)
		{
			if(components[i].getName().equals(name))
				return components[i];
		}
		return null;
	}
	
	private void parseGridbag(Element e)
	{
		NodeList rows = e.getChildNodes();
		for(int i=0;i<rows.getLength();i++)
		{
			Element row = (Element)rows.item(i);
			NodeList cells = row.getChildNodes();
			for(int j=0;j<cells.getLength();j++)
			{
				Element cell = (Element) cells.item(j);
				parseCell(cell,i,j);
			}
		}
	}
	
	private void parseCell(Element e,int r,int c)
	{
		String value = e.getAttribute("gridx");
		if(value.length() == 0)
		{
			if(c == 0)
				constraints.gridx = 0;
			else
				constraints.gridx += constraints.gridwidth;
		}
		else
			constraints.gridx = Integer.parseInt(value);
		
		value = e.getAttribute("gridy");
		if(value.length() == 0)
			constraints.gridy = r;
		else
			constraints.gridy = Integer.parseInt(value);
		
		constraints.gridwidth = Integer.parseInt(e.getAttribute("gridwidth"));
		constraints.gridheight = Integer.parseInt(e.getAttribute("gridheight"));
		constraints.weightx = Integer.parseInt(e.getAttribute("weightx"));
		constraints.weighty = Integer.parseInt(e.getAttribute("weighty"));
		constraints.ipadx = Integer.parseInt(e.getAttribute("ipadx"));
		constraints.ipady = Integer.parseInt(e.getAttribute("ipady"));
		
		Class<GridBagConstraints> cl = GridBagConstraints.class;
		
		try {
			String name = e.getAttribute("fill");
			Field f = cl.getField(name);
			constraints.fill = f.getInt(cl);
			
			name = e.getAttribute("anchor");
			f = cl.getField(name);
			constraints.anchor = f.getInt(cl);
		} catch (SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalArgumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NoSuchFieldException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Component comp = (Component)parseBean((Element)e.getFirstChild());
		add(comp,constraints);
	}
	
	private Object parseBean(Element e)
	{
		try {
			NodeList children = e.getChildNodes();
			Element classElement = (Element)children.item(0);
			String className = ((Text)classElement.getFirstChild()).getData();
			
			Class<?> cl = Class.forName(className);
			
			Object obj = cl.newInstance();
			
			if(obj instanceof Component)
				((Component)obj).setName(e.getAttribute("id"));
			
			for(int i = 1;i<children.getLength();i++)
			{
				Node propertyElement = children.item(i);
				Element nameElement = (Element)propertyElement.getLastChild();
				String propertyName = ((Text)nameElement.getFirstChild()).getData();
				
				Element valueElement = (Element)propertyElement.getLastChild();
				Object value = parseValue(valueElement);
				BeanInfo beanInfo = Introspector.getBeanInfo(cl);
				PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
				boolean done = false;
				for(int j=0;!done&&j<descriptors.length;j++)
				{
					if(descriptors[j].getName().equals(propertyName))
					{
						descriptors[j].getWriteMethod().invoke(obj, value);
						done = true;
					}
				}
			}
			return obj;
		} catch (DOMException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		} catch (IllegalArgumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		} catch (IntrospectionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		} catch (InvocationTargetException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		}
	}
	
	private Object parseValue(Element e)
	{
		Element child = (Element)e.getFirstChild();
		if(child.getTagName().equals("bean"))
			return parseBean(child);
		String text = ((Text)child.getFirstChild()).getData();
		if(child.getTagName().equals("int")){
			return new Integer(text);
		}else if(child.getTagName().equals("boolean")){
			return new Boolean(text);
		}else if(child.getTagName().equals("string")){
			return text;
		}else{
			return null;
		}
	}
	
	private GridBagConstraints constraints;
}
