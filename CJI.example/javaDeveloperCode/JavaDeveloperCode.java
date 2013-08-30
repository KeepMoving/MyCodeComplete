package javaDeveloperCode;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class JavaDeveloperCode {
	public static void main(String[] args){
		try {
			fileCopy(new File("C:\\Users\\KeepMoving\\Desktop\\test1.cpp"),new File("C:\\Users\\KeepMoving\\Desktop\\testCopyFile.cpp"));
		} catch (IOException ioe) {
			// TODO Auto-generated catch block
			System.out.println("IOException:" + ioe.getMessage());
		}
	}
	
	/*
	 * 把Strings转换成int和把int转换成String
	 * */		
	public int stringToInt()
	{
		String a = String.valueOf(2); 
		//integer to numeric string  
		int i = Integer.parseInt(a); //numeric string to an int 
		return i;
	}
	
	/*
	 * 向java文件中添加文本
	 * */
	public void writeToJavaFile()
	{
		//Updated: Thanks Simone for pointing to exception. I have changed the code. 
		BufferedWriter out = null; 
		try {
			out = new BufferedWriter(new FileWriter("filename", true));  
			out.write("aString");
			if(out != null)
				out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * 获取java现在正调用的方法名
	 * */
	public String getCurrentMethodName()
	{
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName(); 
		return methodName;
	}
	
	/*
	 * 拷贝文件
	 * */
	public static void fileCopy(File in,File out) throws IOException  
	{  
		FileChannel inChannel = new FileInputStream(in).getChannel();  
		FileChannel outChannel = new FileOutputStream(out).getChannel();  
		try 
		{  
			//inChannel.transferTo(0, inChannel.size(), outChannel);      
			// original-- apparently has trouble copying large files on Windows  
			// magic number for Windows, 64Mb - 32Kb)  
			int maxCount = (64 * 1024 * 1024) - (32 * 1024);  
			long size = inChannel.size();  
			long position = 0;  
			
			while(position < size )  
			{  
				position += inChannel.transferTo( position, maxCount, outChannel ); 
			}
		}finally{  
			if(inChannel != null )  
			{  
				inChannel.close();  
			}

			if ( outChannel != null )  
			{  
				outChannel.close();  
			}
		}  
	} 
}


