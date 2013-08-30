package unit_1_3.zipTest;

import javax.swing.JFrame;

//不能读取rar类型的文件
public class ZipTest 
{
	public static void main(String[] args) 
	{
		ZipTestFrame frame = new ZipTestFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
