package unit_11_1.ScriptTest;

import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.beans.EventSetDescriptor;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.JFrame;

public class ScriptTest 
{
	public static void main(final String[] args) 
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				String language;
				if(args.length == 0)
					language = "js";
				else
					language = args[0];
				
				ScriptEngineManager manager = new ScriptEngineManager();
				System.out.println("Available factories: ");
				for(ScriptEngineFactory factory:manager.getEngineFactories())
					System.out.println(factory.getEngineName());
				final ScriptEngine engine = manager.getEngineByName(language);
				
				if(engine == null)
				{
					System.err.println("No engine forr " + language);
					System.exit(1);
				}
				
				ButtonFrame frame = new ButtonFrame();
				
				try {
					File initFile = new File("init." + language);
					if(initFile.exists())
					{
						engine.eval(new FileReader(initFile));
					}
					
					getComponentBindings(frame,engine);
					
					final Properties events = new Properties();
					events.load(new FileReader(language + ".properties"));
					for(final Object e:events.keySet())
					{
						String[] s = ((String)e).split("\\.");
						addListener(s[0],s[1],(String)events.get(e),engine);
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ScriptException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IntrospectionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setTitle("ScriptTest");
				frame.setVisible(true);
				
			}
		});
	}

	private static void getComponentBindings(Component c,ScriptEngine engine)
	{
		String name = c.getName();
		if(name != null)
			engine.put(name, c);
		if(c instanceof Container)
		{
			for(Component child :((Container)c).getComponents())
				getComponentBindings(child,engine);
		}
	}
	
	private static void addListener(String beanName,String eventName,final String scriptCode,final ScriptEngine engine) throws IllegalArgumentException,IntrospectionException,IllegalAccessException,InvocationTargetException
	{
		Object bean = engine.get(beanName);
		EventSetDescriptor descriptor = getEventSetDescriptor(bean,eventName);
	}
	
	private static EventSetDescriptor getEventSetDescriptor(Object bean,String eventName)throws IntrospectionException
	{
		for(EventSetDescriptor descriptor:Introspector.getBeanInfo(bean.getClass()).getEventSetDescriptors())
			if(descriptor.getName().equals(eventName))
				return descriptor;
		return null;
	}
}
