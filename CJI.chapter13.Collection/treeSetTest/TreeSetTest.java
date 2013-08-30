package treeSetTest;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetTest {

	public static void main(String[] args) {
		//构造排序集
		SortedSet<Item> parts = new TreeSet<Item>();
		//添加条目项
		parts.add(new Item("Toaster",1234));
		parts.add(new Item("Widget",4562));
		parts.add(new Item("Modem",9912));
		//打印条目项
		System.out.println(parts);
		
		//构造一个树集，用一个Comparator对象初始化
		SortedSet<Item> sortByDescription = new TreeSet<Item>(
				new Comparator<Item>()
				{
					//定义compare方法。比较a对象和b对象
					public int compare(Item a,Item b)
					{
						String descrA = a.getDescription();
						String descrB = b.getDescription();
						return descrA.compareTo(descrB);
					}
				});
	}
}

class Item implements Comparable<Item> //注意此处实现了Comparable<Item>接口
{
	//定义Item类初始化方法
	public Item(String aDescription, int aPartNumber)
	{
		description = aDescription;
		partNumber = aPartNumber;
	}
	
	//获取description值
	public String getDescription()
	{
		return description;
	}
	
	//打印description值和partNumber值
	public String toString()
	{
		return "[description=" + description + " ,partNumber=" + partNumber + "]";
	}
	
	//定义equals方法，判断对象是否相等
	public boolean equals(Object otherObject)
	{
		if(this == otherObject)
			return true;
		if(otherObject == null)
			return false;
		if(getClass() != otherObject.getClass())
			return false;
		Item other = (Item)otherObject;
		return description.equals(other.description)&&partNumber == other.partNumber;
	}
	
	//定义hash函数
	public int hashCode()
	{
		return 13*description.hashCode() + 17*partNumber;
	}
	
	//定义compareTo函数，比较两个值的大小
	public int compareTo(Item other)
	{
		return partNumber - other.partNumber;
	}
	
	private String description;
	private int partNumber;
}