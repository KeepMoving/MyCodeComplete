package unit_2_7.XPathTest;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XPathFrame extends JFrame 
{
	public XPathFrame()
	{	
		//设置标题
		setTitle("XPathTest");
		
		//新建菜单栏和按钮		
		JMenu fileMenu = new JMenu("File");
		JMenuItem openItem = new JMenuItem("Open");
		//		添加响应函数
		openItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				openFile();
			}
		});
		//		添加按钮
		fileMenu.add(openItem);
		
		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(0);
			}
		});
		fileMenu.add(exitItem);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(fileMenu);
		setJMenuBar(menuBar);
		
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				evaluate();
			}
		};
		
		expression = new JTextField(20);
		expression.addActionListener(listener);
		JButton evaluateButton = new JButton("Evaluate");
		evaluateButton.addActionListener(listener);
		
		typeCombo = new JComboBox(new Object[]{"STRING","NODE","NODESET","NUMBER","BOOLEAN"});
		typeCombo.setSelectedItem("STRING");
		
		JPanel panel = new JPanel();
		panel.add(expression);
		panel.add(typeCombo);
		panel.add(evaluateButton);
		docText = new JTextArea(10,40);
		result = new JTextField();
		result.setBorder(new TitledBorder("Result"));
		
		add(panel,BorderLayout.NORTH);
		add(new JScrollPane(docText),BorderLayout.CENTER);
		add(result,BorderLayout.SOUTH);
		
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		XPathFactory xpfactory = XPathFactory.newInstance();
		path = xpfactory.newXPath();
		pack();
	}
	
	//open a file and load the document
	public void openFile()
	{
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File("."));
		
		//过滤文件类型
		chooser.setFileFilter(new javax.swing.filechooser.FileFilter() 
		{
			@Override
			public boolean accept(File f) 
			{
				return f.isDirectory()||f.getName().toLowerCase().endsWith(".xml");
			}

			@Override
			public String getDescription() 
			{
				return "XML files";
			}
		});
		
		int r = chooser.showOpenDialog(this);
		if(r != JFileChooser.APPROVE_OPTION)
			return;
		File f = chooser.getSelectedFile();
		
		try {
			byte[] bytes = new byte[(int)f.length()];
			new FileInputStream(f).read(bytes);
			docText.setText(new String(bytes));
			doc = builder.parse(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void evaluate()
	{
		try {
			String typeName = (String)typeCombo.getSelectedItem();
			QName returnType = (QName) XPathConstants.class.getField(typeName).get(null);
			Object evalResult = path.evaluate(expression.getText(), doc, returnType);
			if(typeName.equals("NODESET"))
			{
				NodeList list = (NodeList)evalResult;
				StringBuilder builder = new StringBuilder();
				builder.append("{");
				for(int i=0;i<list.getLength();i++)
				{
					if(i>0)
						builder.append(", ");
					builder.append("" + list.item(i));
				}
				builder.append("}");
				result.setText("" + builder);
			}else{
				result.setText("" + evalResult);
			}
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private DocumentBuilder builder;
	private Document doc;
	private XPath path;
	private JTextField expression;
	private JTextField result;
	private JTextArea docText;
	private JComboBox typeCombo;
}
