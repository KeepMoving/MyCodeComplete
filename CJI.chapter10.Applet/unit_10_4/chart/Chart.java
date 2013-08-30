package unit_10_4.chart;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;
import java.awt.geom.Rectangle2D;

import javax.swing.JApplet;
import javax.swing.JComponent;

public class Chart extends JApplet 
{
	public void init()
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				String v = getParameter("values");
				if(v == null)return;
				int n = Integer.parseInt(v); //获取v数组长度，这里value数组和name数组拥有相同的长度
				double[] values = new double[n];
				String[] names = new String[n];
				for(int i=0;i<n;i++)
				{
					values[i] = Double.parseDouble(getParameter("value."+(i+1))); //对参数进行赋值
					names[i] = getParameter("name." + (i + 1));
				}
				add(new ChartComponent(values,names,getParameter("title")));
			}
		});
	}
}

class ChartComponent extends JComponent
{
	public ChartComponent(double[] v,String[] n,String t)
	{
		values = v;
		names = n;
		title = t;
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		
		if(values == null)
			return;
		
		double minValue = 0;
		double maxValue = 0;
		for(double v:values) //注意这种求最大值和最小值的算法
		{
			if(minValue>v) minValue = v;//如果v的取值都大于0，那么minValue就一直为0
			
			if(maxValue<v) maxValue = v;
		}
		if(maxValue == minValue)return;
		System.out.println("minValue = " + minValue);
		System.out.println("maxValue = " + maxValue);
		
		int panelWidth = getWidth();
		int panelHeight = getHeight();
		System.out.println("panelWidth = " + panelWidth);
		System.out.println("panelHeight = " + panelHeight);
		
		Font titleFont = new Font("SansSerif",Font.BOLD,20);
		Font labelFont = new Font("SansSerif",Font.PLAIN,10);
		
		FontRenderContext context = g2.getFontRenderContext();
		Rectangle2D titleBounds = titleFont.getStringBounds(title, context);
		double titleWidth = titleBounds.getWidth();
		double top = titleBounds.getHeight();
		System.out.println("titleWidth = " + titleWidth);
		System.out.println("top = " + top);
		
		double y = -titleBounds.getY();
		double x = (panelWidth - titleWidth)/2;
		g2.setFont(titleFont);
		g2.drawString(title, (float)x, (float)y);
		System.out.println("y = " + y);
		System.out.println("x = " + x);
		
		LineMetrics labelMetrics = labelFont.getLineMetrics("", context);
		double bottom = labelMetrics.getHeight();
		System.out.println("bottom = " + bottom);
		
		y = panelHeight - labelMetrics.getDescent();
		System.out.println("y = " + y);
		g2.setFont(labelFont);
		
		double scale = (panelHeight - top - bottom)/(maxValue - minValue);
		System.out.println("scale = " + scale);
		int barWidth = panelWidth / values.length;
		System.out.println("barWidth = " + barWidth);
		
		for(int i=0;i<values.length;i++)
		{
			double x1 = i*barWidth + 1;
			double y1 = top;
			double height = values[i] * scale;
			if(values[i]>=0)
				y1+=(maxValue - values[i])*scale;
			else
			{
				y1 += maxValue*scale;
				height = -height;
			}
			
			Rectangle2D rect = new Rectangle2D.Double(x1,y1,barWidth-2,height);
			System.out.println("Round " + i + ": x1=" + x1);
			System.out.println("Round " + i + ": y1=" + y1);
			System.out.println("Round " + i + ": barWidth-2=" + (barWidth-2));
			System.out.println("Round " + i + ": height=" + height);
			g2.setPaint(Color.RED);
			g2.fill(rect);
			g2.setPaint(Color.BLACK);
			g2.draw(rect);
			
			Rectangle2D labelBounds = labelFont.getStringBounds(names[i], context);
			double labelWidth = labelBounds.getWidth();
			x = x1 + (barWidth - labelWidth)/2;
			g2.drawString(names[i], (float)x, (float)y);
			System.out.println("Round " + i + ": x=" + x);
			System.out.println("Round " + i + ": y=" + y);
			System.out.println("Round " + i + ": labelWidth=" + labelWidth);
		}
	}
	
	private double[] values;
	private String[] names;
	private String title;
}
