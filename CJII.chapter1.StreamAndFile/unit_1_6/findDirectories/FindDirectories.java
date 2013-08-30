package unit_1_6.findDirectories;

import java.io.File;
import java.io.IOException;

//打印出在命令行中输入的任何路径的目录子结构
public class FindDirectories 
{
	public static void main(String[] args) 
	{
		if(args.length == 0)
			args = new String[]{".."};
		
		try {
			File pathName = new File(args[0]);
			//如果一个文件对象表示的是目录，使用list()方法可以获得有一个目录下的文件名构成的数组
			String[] fileNames = pathName.list();
			
			for(int i = 0;i<fileNames.length;i++)
			{
				File f = new File(pathName.getPath(),fileNames[i]);
				
				if(f.isDirectory())
				{
					System.out.println(f.getCanonicalPath());
					main(new String[]{f.getPath()});
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IOException:" + e.getMessage());
		}
	}
}
