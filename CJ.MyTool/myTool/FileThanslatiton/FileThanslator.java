package myTool.FileThanslatiton;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
/*
 * 去除Javaeye代码段前的行数及小数点
 * */
public class FileThanslator {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JChooserFrame jChooserFrame = new JChooserFrame();
		jChooserFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jChooserFrame.setVisible(true);
		
		try {
			BufferedReader in = new BufferedReader(new FileReader(jChooserFrame.getFilePath()));
			int index = 0;
			int row = 0;
			String line = "";
			String result = "";
			while((line = in.readLine()) != null)
			{
				index = line.indexOf('.');
				result += (line.substring(++index) + "\n");
				row++;
			}
			
			FileWriter out = new FileWriter("C:\\Users\\KeepMoving\\Desktop\\result.txt");
			out.write(result);
			out.flush();
			out.close();
			System.out.println("得到行数Row = " + row);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("FileNotFoundException:" + e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IOException:" + e.getMessage());
		}
	}
}
