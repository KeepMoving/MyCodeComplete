package unit_10_5.appletFrame;

import java.applet.Applet;
import java.applet.AppletContext;
import java.applet.AppletStub;
import java.applet.AudioClip;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.Iterator;

import javax.swing.JFrame;

public class AppletFrame extends JFrame implements AppletStub, AppletContext 
{
	public AppletFrame(Applet anApplet)
	{
		applet = anApplet;
		add(applet);
		applet.setStub(this);
	}
	
	public void setVisible(boolean b)
	{
		if(b)
		{
			applet.init();
			applet.setVisible(true);
			applet.start();
		}
		else
		{
			applet.stop();
			super.setVisible(false);
			applet.destroy();
		}
	}
	
	public boolean isActive()
	{
		return true;
	}
	
	public URL getDocumentBase()
	{
		return null;
	}
	
	public URL getCodeBase()
	{
		return null;
	}
	
	public String getParameter(String name)
	{
		return "";
	}

	public AppletContext getAppletContext() 
	{
		return this;
	}

	public void appletResize(int arg0, int arg1) 
	{
	}
	
	public AudioClip getAudioClip(URL url)
	{
		return null;
	}
	
	public Image getImage(URL url)
	{
		return Toolkit.getDefaultToolkit().getImage(url);
	}
	
	public Applet getApplet(String name)
	{
		return null;
	}

	public Enumeration<Applet> getApplets() 
	{
		return null;
	}

	public void showDocument(URL url) 
	{
	}
	
	public void showDocument(URL rul, String target) 
	{
	}
	
	public void showStatus(String arg0) 
	{
	}
	
	public void setStream(String key, InputStream stream)
	{
	}
	
	public InputStream getStream(String key) 
	{
		return null;
	}

	public Iterator<String> getStreamKeys() 
	{
		return null;
	}

	private Applet applet; 
}
