package unit_11_4.eventTracer;

import java.awt.Component;
import java.awt.Container;
import java.beans.BeanInfo;
import java.beans.EventSetDescriptor;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class EventTracer 
{
	public static void main(String[] args) 
	{
		handler = new InvocationHandler()
		{
			public Object invoke(Object proxy,Method method,Object[] args)
			{
				System.out.println(method + ":" + args[0]);
				return null;
			}
		};
	}
	

	public void add(Component c)
	{
		try {
			BeanInfo info = Introspector.getBeanInfo(c.getClass());
			
			EventSetDescriptor[] eventSets = info.getEventSetDescriptors();
			for(EventSetDescriptor eventSet:eventSets)
				addListener(c,eventSet);
		} catch (IntrospectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(c instanceof Container)
		{
			for(Component comp:((Container)c).getComponents())
				add(comp);
		}
	}
	
	public void addListener(Component c,EventSetDescriptor eventSet)
	{
		Object proxy = Proxy.newProxyInstance(null,new Class[]{eventSet.getListenerType()},handler);
		
		Method addListenerMethod = eventSet.getAddListenerMethod();
		try {
			addListenerMethod.invoke(c, proxy);
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
	
	private static InvocationHandler handler;
}

