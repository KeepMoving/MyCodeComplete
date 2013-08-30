package myTool.DeleteSpaceLine;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileFilter;

public class JChooserFrame extends JFrame 
{
	private static final long serialVersionUID = 1L; 
	private JFrame jFrame = null; 
	private JFileChooser jfChooser = null;
	
	public JChooserFrame() 
	{ 
		jFrame = this;
		jfChooser = new JFileChooser("C:\\Users\\KeepMoving\\Desktop\\..");
		jfChooser.setFileFilter(new FileFilter() 
		{ 
			@Override 
			public boolean accept(File f) { 
				if (f.getName().endsWith("txt") || f.isDirectory()) 
					return true; 
				return false; 
			} 
			
			@Override 
			public String getDescription() { 
				return "数值型数据(*.txt)"; 
			} 
		}); 
	}
	
	public String getFilePath()
	{
		int result = jfChooser.showOpenDialog(jFrame); 
		if (result == JFileChooser.APPROVE_OPTION) { 
			// 确认打开 
			File fileIn = jfChooser.getSelectedFile(); 
			if (fileIn.exists()) { 
				return fileIn.getAbsolutePath();
			}
		} else if (result == JFileChooser.CANCEL_OPTION) { 
			System.out.println("Cancel button is pushed."); 
		} else if(result == JFileChooser.ERROR_OPTION) { 
			System.err.println("Error when select file."); 
		} 
		
		return null;
	}
}
