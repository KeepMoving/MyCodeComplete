package unit_11_5.eventTracerTest;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JSlider;

import unit_11_4.eventTracer.EventTracer;

public class EventTracerTest 
{
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				JFrame frame = new EventTracerFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});	
	}
}

class EventTracerFrame extends JFrame
{
	public EventTracerFrame()
	{
		setTitle("EventTracerTest");
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		
		add(new JSlider(),BorderLayout.NORTH);
		add(new JButton("Test"),BorderLayout.SOUTH);
		
		EventTracer tracer = new EventTracer();
		tracer.add(this);
	}
	
	public static final int DEFAULT_WIDTH = 400;
	public static final int DEFAULT_HEIGHT = 400;
}