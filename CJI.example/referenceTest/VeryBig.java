package referenceTest;

public class VeryBig {
	private String id;
	
	public VeryBig(String id)
	{
		this.id = id;
	}

	@Override
	protected void finalize() throws Throwable 
	{
		System.out.println("Finalizing " + id);
	}
}
