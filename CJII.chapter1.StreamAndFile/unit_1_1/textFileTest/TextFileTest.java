package unit_1_1.textFileTest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TextFileTest 
{
	public static void main(String[] args) 
	{
		try {
			Employee[] staff = new Employee[3];
			staff[0] = new Employee("Carl Cracker",75000,1987,12,15);
			staff[1] = new Employee("Harry Hacker",50000,1989,10,1);
			staff[2] = new Employee("Tony Tester",40000,1990,3,15);
			
			PrintWriter out = new PrintWriter("employee.dat"); //默认在工程的顶层文件夹下创建employee.dat
			writeData(staff,out);
			out.close();
			
			Scanner in = new Scanner(new FileReader("employee.dat"));
			Employee[] newStaff = readData(in);
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
	
	private static void writeData(Employee[] employees,PrintWriter out) throws IOException
	{
		out.println(employees.length);//向文件中写入数组对象个数
		
		for(Employee e:employees)//依次写入对象数据，注意此处的写入操作调用的是Employee类的动作函数writeData()
			e.writeData(out);
	}
	
	private static Employee[] readData(Scanner in)
	{
		int n = in.nextInt(); //首先从数据文件中读取对象个数
		in.nextLine();
		
		Employee[] employees = new Employee[n];
		for(int i = 0; i<n ; i++)
		{
			employees[i] = new Employee();
			employees[i].readData(in); //注意此处调用Employee类的readData()动作函数
		}
		return employees;
	}
}