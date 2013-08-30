package unit_2_10.XMLWriteTest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

public class XMLWriteFrame extends JFrame 
{
	public XMLWriteFrame()
	{
		setTitle("XMLWriteTest");
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		
		chooser = new JFileChooser();
		
		//add component to frame
		comp = new RectangleComponent();
		add(comp);
		
		//set up menu bar
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("File");
		menuBar.add(menu);
		
		JMenuItem newItem = new JMenuItem("New");
		menu.add(newItem);
		newItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				comp.newDrawing();
			}
		});
		
		JMenuItem saveItem = new JMenuItem("Save with DOM/XSLT");
		menu.add(saveItem);
		saveItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				try {
					saveDocument();
				} catch (TransformerException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JMenuItem saveStAXItem = new JMenuItem("Save with StAX");
		menu.add(saveStAXItem);
		saveStAXItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				try {
					saveStAX();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (XMLStreamException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JMenuItem exitItem = new JMenuItem("Exit");
		menu.add(exitItem);
		exitItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(0);
			}
		});
	}
	
	//saves the drawing in SVG format,using DOM/XSLT
	public void saveDocument() throws TransformerException,IOException
	{
		if(chooser.showSaveDialog(this) != JFileChooser.APPROVE_OPTION)
			return;
		File f = chooser.getSelectedFile();
		Document doc = comp.builderDocument();
		Transformer t = TransformerFactory.newInstance().newTransformer();
		t.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "http://www.w3.org/TR/2000/CR-SVG-20000802/DTD/svg-20000802.dtd");
		t.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, "-//W3C//DTD SVG 20000802//EN");
		t.setOutputProperty(OutputKeys.INDENT, "yes");
		t.setOutputProperty(OutputKeys.METHOD, "XML");
		t.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
		t.transform(new DOMSource(doc), new StreamResult(new FileOutputStream(f)));
	}
	
	//saves the drawing in SVG format,using StAX
	public void saveStAX() throws FileNotFoundException,XMLStreamException
	{
		if(chooser.showSaveDialog(this) != JFileChooser.APPROVE_OPTION)
			return;
		File f = chooser.getSelectedFile();
		XMLOutputFactory factory = XMLOutputFactory.newInstance();
		XMLStreamWriter writer = factory.createXMLStreamWriter(new FileOutputStream(f));
		comp.writeDocument(writer);
		writer.close();
	}
	
	public static final int DEFAULT_WIDTH = 300;
	public static final int DEFAULT_HEIGHT = 200;
	
	private RectangleComponent comp;
	private JFileChooser chooser;
}
