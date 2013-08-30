package unit_5_2.personTest;

import java.util.Date;
import java.util.GregorianCalendar;

public class PersonTest 
{
	public static void main(String[] args) 
	{		
		Person[] people = new Person[2];
		
		people[0] = new Employee1("Harry hacker",50000,1989,10,1);
		people[1] = new Student("Maria Morris","computer science");
		
		/*		
		 * 由于不能构造抽象类Person的对象，
		 * 所以变量p永远不会引用Person对象，
		 * 而是引用诸如Employee1或Student这样的具体子类对象，
		 * 而在这些对象中都定义了getDescription方法
		 */
		for(Person p:people)
			System.out.println(p.getName() + "," + p.getDescription());
	}
}

abstract class Person
{
	public Person(String n)
	{
		name = n;
	}
	
	public abstract String getDescription();
	
	public String getName()
	{
		return name;
	}
	
	private String name;
}

class Employee1 extends Person
{
	public Employee1(String n,double s,int year,int month,int day)
	{
		super(n);
		salary = s;
		GregorianCalendar calendar = new GregorianCalendar(year,month-1,day);
		hireDay = calendar.getTime();
	}
	
	public double getSalary()
	{
		return salary;
	}
	
	public Date getHireDay()
	{
		return hireDay;
	}
	
	public String getDescription()
	{
		return String.format("an employee with a salary of $%.2f", salary);
	}
	
	public void raiseSalary(double byPercent)
	{
		double raise = salary * byPercent /100;
		salary += raise;
	}
	
	private double salary;
	private Date hireDay;
}

class Student extends Person
{
	public Student(String n,String m)
	{
		super(n);
		major = m;
	}
	
	public String getDescription()
	{
		return "a student majoring in " + major;
	}
	
	private String major;
}