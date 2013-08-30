package paramTest;

public class ParamTest 
{
	public static void main(String[] args) 
	{
		//test1:Methods can't modify numberic parameters
		System.out.println("Testing tripleValue:");
		double percent = 10;
		System.out.println("Before:percent=" + percent);
		tripleValue(percent);
		System.out.println("After:percent=" + percent);
		
		//test2:Methods can change the state sof pbject parameters
		System.out.println("\nTesting tripleSalary:");
		Employee3 harry = new Employee3("Harry",50000);
		System.out.println("Before:salary=" + harry.getSalary());
		tripleSalary(harry);
		System.out.println("After:salary=" + harry.getSalary());
		
		//test3:Methods can't attach new objects to object parameters
		System.out.println("\nTesting swap:");
		Employee3 a = new Employee3("Alice",70000);
		Employee3 b = new Employee3("Bob",60000);
		System.out.println("Before:a=" + a.getName());
		System.out.println("Before:b=" + b.getName());
		swap(a,b);
		System.out.println("After:a=" + a.getName());
		System.out.println("After:b=" + b.getName());
	}

	

	public static void tripleValue(double x) //值调用不改变参数值
	{
		x = 3*x;
		System.out.println("End of method: x=" + x);
	}
	
	public static void tripleSalary(Employee3 x) //引用调用引用相同内存地址，改变类变量值
	{
		x.raiseSalary(200);
	}
	
	public static void swap(Employee3 x,Employee3 y) //一个方法不能实现让对象参数引用一个新的对象
	{
		Employee3 temp = x;
		x = y;
		y = temp;
		System.out.println("End of method:x=" + x.getName());
		System.out.println("End of method:y=" + y.getName());
	}
}
class Employee3
{
	public Employee3(String n,double s)
	{
		name = n;
		salary = s;
	}
	
	public String getName()
	{
		return name;
	}
	
	public double getSalary()
	{
		return salary;
	}
	
	public void raiseSalary(double byPercent)
	{
		double raise = salary * byPercent /100;
		salary += raise;
	}
	
	private String name;
	private double salary;
}