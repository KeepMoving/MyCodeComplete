package unit_2_10.XMLWriteTest;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JComponent;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

//a component that shows a set of colored rectangles
public class RectangleComponent extends JComponent 
{
	public RectangleComponent()
	{
		rects = new ArrayList<Rectangle2D>();
		colors = new ArrayList<Color>();
		generator = new Random();
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//create a new random drawing
	public void newDrawing()
	{
		int n = 10 + generator.nextInt(20);
		rects.clear();
		colors.clear();
		for(int i=1;i<n;i++)
		{
			int x = generator.nextInt(getWidth());
			int y = generator.nextInt(getHeight());
			int width = generator.nextInt(getWidth() - x);
			int height = generator.nextInt(getHeight() - y);
			rects.add(new Rectangle(x,y,width,height));
			int r = generator.nextInt(256);
			int g = generator.nextInt(256);
			int b = generator.nextInt(256);
			colors.add(new Color(r,g,b));
		}
		repaint();
	}
	
	public void paintComponent(Graphics g)
	{
		if(rects.size() == 0)
			newDrawing();
		Graphics2D g2 = (Graphics2D) g;
		//draw all rectangles
		for(int i=0;i<rects.size();i++)
		{
			g2.setPaint(colors.get(i));
			g2.fill(rects.get(i));
		}
	}
	
	/*	
	 * Creates an SVG document of the current drawing
	 * return the DOM tree of the SVG document
	 * */
	public Document builderDocument()
	{
		Document doc = builder.newDocument();
		Element svgElement = doc.createElement("svg");
		doc.appendChild(svgElement);
		svgElement.setAttribute("width", ""+getWidth());
		svgElement.setAttribute("height", ""+getHeight());
		for(int i=0;i<rects.size();i++)
		{
			Color c = colors.get(i);
			Rectangle2D r = rects.get(i);
			Element rectElement = doc.createElement("rect");
			rectElement.setAttribute("x", "" + r.getX());
			rectElement.setAttribute("y", "" + r.getY());
			rectElement.setAttribute("width", "" + r.getWidth());
			rectElement.setAttribute("height", "" + r.getHeight());
			rectElement.setAttribute("fill", "" + colorToString(c));
			svgElement.appendChild(rectElement);
		}
		return doc;
	}
	
	/*
	 * Writes an SVG document of the current drawing.
	 * @param write the document destination
	 * */
	public void writeDocument(XMLStreamWriter writer) throws XMLStreamException
	{
		writer.writeStartDocument();
		writer.writeDTD("<!DOCTYPE svg PUBLLIC \"-//W3C/DTD SVG 20000802//EN\" " +
				        "\"http://www.w3.org/TR/2000/CR-SVG-20000802/DTD/svg-20000802.dtd\">");
		writer.writeStartDocument("svg");
		writer.writeAttribute("width", ""+getWidth());
		writer.writeAttribute("height", ""+getHeight());
		for(int i=0;i<rects.size();i++)
		{
			Color c = colors.get(i);
			Rectangle2D r = rects.get(i);
			writer.writeEmptyElement("rect");
			writer.writeAttribute("x", "" + r.getX());
			writer.writeAttribute("y", "" + r.getY());
			writer.writeAttribute("width", "" + r.getWidth());
			writer.writeAttribute("height", "" + r.getHeight());
			writer.writeAttribute("fill", "" + colorToString(c));
		}
		writer.writeEndDocument();
	}
	
	/*	
	 * Converts a color toa hex value
	 * @param c a color
	 * @return s string of the form #rrggbb
	 * */
	private static String colorToString(Color c)
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append(Integer.toHexString(c.getRGB() & 0xFFFFFF));
		while(buffer.length()<6)
			buffer.insert(0, '0');
		buffer.insert(0, '#');
		return buffer.toString();
	}
	
	private ArrayList<Rectangle2D> rects;
	private ArrayList<Color> colors;
	private Random generator;
	private DocumentBuilder builder;
}
