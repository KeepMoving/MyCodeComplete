package unit_1_5.serialCloneTest;

import java.util.Date;
import java.util.GregorianCalendar;

public class Employee extends SerialCloneable 
{
	public Employee(String n,double s,int year,int month,int day)
	{
		name = n;
		salary = s;
		GregorianCalendar calendar = new GregorianCalendar(year,month-1,day);
		hireDay = calendar.getTime();
	}
	
	public String getName()
	{
		return name;
	}
	
	public double getSalary()
	{
		return salary;
	}
	
	public Date getHireDay()
	{
		return hireDay;
	}
	
	public void raiseSalary(double byPercent)
	{
		double raise = salary*byPercent/100;
		salary += raise;
	}
	
	private static final long serialVersionUID = -1370593217757405865L;
	private String name;
	private double salary;
	private Date hireDay;
}
