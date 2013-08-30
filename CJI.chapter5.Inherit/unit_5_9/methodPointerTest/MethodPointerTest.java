package unit_5_9.methodPointerTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodPointerTest 
{
	public static void main(String[] args) throws Exception
	{
		Method square = MethodPointerTest.class.getMethod("square", double.class); //注意此处为MethodPointerTest.class，获得类
		Method sqrt = Math.class.getMethod("sqrt", double.class);
		
		printTable(1,10,10,square);
		printTable(1,10,10,sqrt);
	}
	
	public static double square(double x)
	{
		return x*x;
	}
	
	public static void printTable(double from,double to,int n,Method f) //注意此处为Method类型
	{
		System.out.println(f);
		
		double dx = (to - from)/(n - 1);
		
		for(double x = from; x<=to; x += dx)
		{
			try {
				double y = (Double)f.invoke(null, x);
//				System.out.println("y = " + y);
				System.out.printf("%10.4f|%10.4f%n", x,y);
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

