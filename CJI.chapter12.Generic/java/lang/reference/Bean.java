package java.lang.reference;

public class Bean {
	private String name;
	private int num;
	
	public Bean(String name,int num)
	{
		this.name = name;
		this.num = num;
	}
	public void print()
	{
		System.out.println("name= " + name + " num= " + num);
	}
}
