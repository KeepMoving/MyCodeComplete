package unit_1_4.objectStreamTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectStreamTest 
{
	public static void main(String[] args) 
	{
		try {
			Employee harry = new Employee("Harry hacker",50000,1989,10,1); 
			Manager carl = new Manager("Carl Cracker",80000,1987,12,15);
			carl.setSecretary(harry);
			Manager tony = new Manager("Tony Tester",40000,1990,3,15);
			tony.setSecretary(harry);
			
			Employee[] staff = new Employee[3];
			
			staff[0] = carl;
			staff[1] = harry;
			staff[2] = tony;
			
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("employee.dat"));
			out.writeObject(staff);//注意此处调用的是Employee即对象类数组
			out.close();
			
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("employee.dat"));
			Employee[] newStaff = (Employee[])in.readObject();
			in.close();
			
			newStaff[1].raiseSalary(10);
			
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
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("ClassNotFoundException:" + e.getMessage());
			e.printStackTrace();
		}
	}
}
