package setterInjection;

public class Test 
{
	public static void main(String[] args) 
	{
		IServiceClass serviceA = new ServiceClassA();
		IServiceClass serviceB = new ServiceClassB();
		ClientClass client = new ClientClass();
		
		client.set_serviceImpl(serviceA);
		client.ShowInfo();
		client.set_serviceImpl(serviceB);
		client.ShowInfo();
	}
}
