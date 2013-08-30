package unit_1_4.objectStreamTest;

public class Manager extends Employee 
{
	public Manager(String n,double s,int year,int month,int day)
	{
		super(n,s,year,month,day);
		secretary = null;
	}
	
	public void setSecretary(Employee secretary) 
	{
		this.secretary = secretary;
	}
	
	public String toString()
	{
		return super.toString() + "[secretary=" + secretary + "]";
	}
	
	private Employee secretary;
}
