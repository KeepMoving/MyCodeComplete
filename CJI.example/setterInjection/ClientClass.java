package setterInjection;

public class ClientClass 
{
	private IServiceClass _serviceImpl;

	public void set_serviceImpl(IServiceClass impl) 
	{
		_serviceImpl = impl;
	}
	
	public void ShowInfo()
	{
		System.out.println(_serviceImpl.ServiceInfo());
	}
}
