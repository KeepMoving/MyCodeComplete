package referenceTest1;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.LinkedList;

public class ReferenceTest1 
{
	private static ReferenceQueue<VeryBig> rq = new ReferenceQueue<VeryBig>();
	
	public static void checkQueue()
	{
		Reference<? extends VeryBig> ref = null;
		while((ref = rq.poll())!=null)
		{
			if(ref != null)
			{
				System.out.println("In queue: " + ((VeryBigWeakReference)(ref)).id);
			}
		}
	}
	
	public static void main(String[] args) 
	{
		int size = 3;
		LinkedList<WeakReference<VeryBig>> weakList = new LinkedList<WeakReference<VeryBig>>();
		for(int i=0;i<size;i++)
		{
			weakList.add(new VeryBigWeakReference(new VeryBig("Weak " + i), rq));
			System.out.println("Just created weak: " + weakList.getLast());
		}
		
		System.gc();
		checkQueue();
	}
}

class VeryBig
{
	public String id;
	byte[] b = new byte[2*1024];
	
	public VeryBig(String id){
		this.id = id;
	}
	
	protected void finalize(){
		System.out.println("Finalizing VeryBig " + id);
	}
}

class VeryBigWeakReference extends WeakReference<VeryBig>
{
	public String id;
	
	public VeryBigWeakReference(VeryBig big,ReferenceQueue<VeryBig> rq)
	{
		super(big,rq);
		this.id = big.id;
	}
	
	protected void finalize()
	{
		System.out.println("Finalizing VeryBigWeakReference " + id);
	}
}
