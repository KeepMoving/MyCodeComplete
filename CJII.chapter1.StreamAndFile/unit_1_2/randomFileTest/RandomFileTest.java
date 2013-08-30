package unit_1_2.randomFileTest;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomFileTest 
{
	public static void main(String[] args) 
	{
		try {
			Employee[] staff = new Employee[3];
			
			staff[0] = new Employee("Carl Cracker",75000,1987,12,15);
			staff[1] = new Employee("Harry Hacker",50000,1989,10,1);
			staff[2] = new Employee("Tony Tester",40000,1990,3,15);
			
			DataOutputStream out = new DataOutputStream(new FileOutputStream("employee.dat"));
			for(Employee e:staff) //注意此处调用的是Employee类的对象e，则对象的各项属性在初始化时就已经确定
				e.writeData(out);
			out.close();
			
			RandomAccessFile in = new RandomAccessFile("employee.dat","r");
			int n = (int)(in.length()/Employee.RECORD_SIZE); //n记录了记录条目数
			Employee[] newStaff = new Employee[n];
			
			for(int i=n-1;i>=0;i--)
			{
				newStaff[i] = new Employee();
				in.seek(i * Employee.RECORD_SIZE);
				newStaff[i].readData(in);
			}
			
			in.close();
			for(Employee e:newStaff)
				System.out.println(e);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("FileNotFoundException:" + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IOException:" + e.getMessage());
			e.printStackTrace();
		}
	}
}
