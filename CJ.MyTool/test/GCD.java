package test;

public class GCD {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GCD gcd = new GCD();
		int res = gcd.bcd(98,43);
		System.out.println("测试结果是: "+res);
	}

	public int bcd(int a,int b)
	{
		if(0 == a)
			return b;
		
		if(a >b){
			return bcd(a%b, b);
		}else {
			return bcd(b%a, a);
		}
	}
}
