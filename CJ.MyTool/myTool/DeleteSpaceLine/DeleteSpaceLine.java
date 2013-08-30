package myTool.DeleteSpaceLine;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import javax.swing.JFrame;
/*
 * 去除空行并计算行数
 * */
public class DeleteSpaceLine {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JChooserFrame jChooserFrame = new JChooserFrame();
		jChooserFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jChooserFrame.setVisible(true);
		
		try {
			FileInputStream fis = new FileInputStream(jChooserFrame.getFilePath());
			DataInputStream in = new DataInputStream(fis);
			InputStreamReader isr = new InputStreamReader(in,"gb2312");
			BufferedReader br = new BufferedReader(isr);
			
			FileOutputStream fos = new FileOutputStream("C:\\Users\\KeepMoving\\Desktop\\result.txt");
			DataOutputStream dos = new DataOutputStream(fos);
			OutputStreamWriter osw = new OutputStreamWriter(dos,"gb2312");
			BufferedWriter out = new BufferedWriter(osw);
			
			int row = 0;
			String line = "";
			String result = "";
			while((line = br.readLine()) != null)
			{
				if(!line.equalsIgnoreCase("^p^p"));
				{
					result += (line + "\r\n");
					row++;
					System.out.println("line " + row + "= " + line);
				}
			}
			
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
