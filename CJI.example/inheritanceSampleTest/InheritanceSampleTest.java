package inheritanceSampleTest;

public class InheritanceSampleTest 
{
	public static void main(String[] args) 
	{
		InheritanceTestExample ex = new InheritanceTestExample();
		ex.test();
	}
}

class InheritanceTest 
{
	public int transfer()
	{
		test1 = 3;
		return test1;
	}
	public int test = 1;
	private int test1 = 1;
}

class InheritanceTestExample extends InheritanceTest
{
	public void test() 
	{
		int ret = 0;
		int ret1 = 0;
		ret = super.test;
		InheritanceTest change = new InheritanceTest();
		ret1 = change.transfer();
		System.out.println("ret = " +ret);
		System.out.println("ret1 = " +ret1);	
	}
}
