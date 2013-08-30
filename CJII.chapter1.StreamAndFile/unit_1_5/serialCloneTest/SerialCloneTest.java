package unit_1_5.serialCloneTest;
//使用对象序列化技术拷贝对象
public class SerialCloneTest 
{
	public static void main(String[] args) 
	{
		Employee harry = new Employee("Harry Hacker",35000,1989,10,1);
		//克隆对象harry，得到一个新对象harry2,需要重载Cloneable接口的Clone()方法
		Employee harry2 = (Employee)harry.clone();
		
		//拷贝的对象不与原对象共享属性空间
		harry.raiseSalary(10);
		
		System.out.println(harry.getSalary());
		System.out.println(harry2.getSalary());
	}
}
