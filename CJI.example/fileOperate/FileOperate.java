package fileOperate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

public class FileOperate 
{
	public FileOperate()
	{
	}
	
	public void newFolder(String folderPath)
	{
		try {
			String filePath = folderPath;
			filePath = filePath.toString();
			File myFilePath = new File(filePath);
			if(!myFilePath.exists())
			{
				myFilePath.mkdir();
			}
		} catch (RuntimeException re) {
			// TODO Auto-generated catch block
			System.out.println("RuntimeException:" + re.getMessage());
			System.out.println("新建目录操作出错");
		}
	}
	
	public void newFile(String filePathAndName,String fileContent)
	{
		try {
			String filePath = filePathAndName;
			filePath = filePath.toString();
			File myFilePath = new File(filePath);
			if(!myFilePath.exists())
			{
				myFilePath.createNewFile();
			}
			FileWriter resultFile = new FileWriter(myFilePath);
			PrintWriter myFile = new PrintWriter(resultFile);
			String strContent = fileContent;
			myFile.println(strContent);
			resultFile.close();
		} catch (IOException ioe) {
			// TODO Auto-generated catch block
			System.out.println("IOException:" + ioe.getMessage());
		}
	}
	
	public void delFile(String filePathAndName)
	{
		try {
			String filePath = filePathAndName;
			filePath = filePath.toString();
			File myDelFile = new File(filePath);
			myDelFile.delete();
		} catch (RuntimeException re) {
			// TODO Auto-generated catch block
			System.out.println("RuntimeException:" + re.getMessage());
		}
	}
	
	public void delFolder(String folderPath)
	{
		delAllFile(folderPath);
		String filePath = folderPath;
		filePath = filePath.toString();
		File myFilePath = new File(filePath);
		myFilePath.delete();
	}
	
	public void delAllFile(String path)
	{
		File file = new File(path);
		if(!file.exists())
			return;
		if(!file.isDirectory())
			return;
		
		String[] tempList = file.list();
		File temp = null;
		for(int i=0;i<tempList.length;i++)
		{
			if(path.endsWith(File.separator))
			{
				temp = new File(path + tempList[i]);
			}
			else
			{
				temp = new File(path + File.separator + tempList[i]);
			}
			
			if(temp.isFile())
			{
				temp.delete();
			}
			if(temp.isDirectory())
			{
				delAllFile(path+"/"+tempList[i]);
				delFolder(path+"/"+tempList[i]);
			}
		}
	}
	
	public void copyFile(String oldPath,String newPath)
	{
		try {
			int bytesum =0;
			int byteread = 0;
			File oldfile = new File(oldPath);
			if(oldfile.exists())
			{
				InputStream inStream = new FileInputStream(oldPath);
				FileOutputStream fs = new FileOutputStream(newPath);
				byte[] buffer = new byte[1444];
				int length;
				while((byteread = inStream.read(buffer)) != -1)
				{
					bytesum += byteread;
					System.out.println(bytesum);
					fs.write(buffer,0,byteread);
				}
				inStream.close();
			}
		} catch (FileNotFoundException fnfe) {
			// TODO Auto-generated catch block
			System.out.println("FileNotFoundException:" + fnfe.getMessage());
		} catch (IOException ioe) {
			// TODO Auto-generated catch block
			System.out.println("IOException:" + ioe.getMessage());
		}
	}
	
	public void copyFolder(String oldPath,String newPath)
	{
		try {
			(new File(newPath)).mkdir();
			File a = new File(oldPath);
			String[] file = a.list();
			File temp = null;
			for(int i=0;i<file.length;i++)
			{
				if(oldPath.endsWith(File.separator))
				{
					temp = new File(oldPath + file[i]);
				}
				else
				{
					temp = new File(oldPath + File.separator + file[i]);
				}
				
				if(temp.isFile())
				{
					FileInputStream input = new FileInputStream(temp);
					FileOutputStream output = new FileOutputStream(newPath + "/" +(temp.getName()).toString());
					byte[] b = new byte[1024*5];
					int len;
					while((len = input.read(b))!= -1)
					{
						output.write(b,0,len);
					}
					output.flush();
					output.close();
					input.close();
				}
				if(temp.isDirectory())
				{
					copyFolder(oldPath + "/" + file[i],newPath + "/" + file[i]);
				}
			}
		} catch (FileNotFoundException fnfe) {
			// TODO Auto-generated catch block
			System.out.println("FileNotFoundException:" + fnfe.getMessage());
		} catch (IOException ioe) {
			// TODO Auto-generated catch block
			System.out.println("IOException:" + ioe.getMessage());
		}
	}
	
	public void moveFile(String oldPath,String newPath)
	{
		copyFile(oldPath,newPath);
		delFile(oldPath);
	}
	
	public void moveFolder(String oldPath,String newPath)
	{
		copyFolder(oldPath,newPath);
		delFolder(oldPath);
	}
}
