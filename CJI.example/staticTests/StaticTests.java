package staticTests;
/*
 * class loader加载StaticTests 时，发现其有父类，就先加载父类，
 * 加载时，会执行父类的static 块，所以最先输入"super static block"
 */
public class StaticTests extends StaticSuper 
{
	static int rand;
	static
	{
		rand = (int)(Math.random()*6);
		System.out.println("static block" + rand);
	}
	
	StaticTests()
	{
		System.out.println("constructor");
	}
	public static void main(String[] args) 
	{
		System.out.println("in main");
		StaticTests st= new StaticTests();
	}
}
