package referenceTest;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.LinkedList;

public class ReferenceTest 
{
	private static ReferenceQueue<VeryBig> rq = new ReferenceQueue<VeryBig>();
	
	public static void checkQueue()
	{
		Reference<? extends VeryBig> ref = rq.poll();
		if(ref != null)
		{
			System.out.println("In queue: " + ref.get());
		}
	}
	
	public static void main(String[] args) 
	{
		int size = 1;
		LinkedList<WeakReference<VeryBig>> weakList = new LinkedList<WeakReference<VeryBig>>();
		for(int i=0;i<size;i++)
		{
			weakList.add(new WeakReference<VeryBig>(new VeryBig("Weak " + i),rq));
			System.out.println("Just created weak: " + weakList.getLast());
			checkQueue();
		}
		
		System.gc();
		
		LinkedList<PhantomReference<VeryBig>> phantomList = new LinkedList<PhantomReference<VeryBig>>();
		for(int i=0;i<size;i++)
		{
			phantomList.add(new PhantomReference<VeryBig>(new VeryBig("Weak " + i),rq));
			System.out.println("Just created weak: " + phantomList.getLast());
			checkQueue();
		}
	}
}
