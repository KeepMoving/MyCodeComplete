package welcome;


public class Welcome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] greeting = new String[3];
		greeting[0] = "Welcome to Core Java";
		greeting[1] = "by Cay Horstmann";
		greeting[2] = "and Gray Cornell";
		
		for(String g:greeting)
			System.out.println(g);
	}
}
