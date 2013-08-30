package fontTest;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class FontTest 
{
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				FontFrame frame = new FontFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

class FontFrame extends JFrame
{
	public FontFrame()
	{
		setTitle("FontTest");
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		
		//add Component to frame
		FontComponent component = new FontComponent();
		add(component);
	}
	
	public static final int DEFAULT_WIDTH = 800;
	public static final int DEFAULT_HEIGHT = 600;
}

class FontComponent extends JComponent
{
	public void paintComponent(Graphics g) //注意括号里的参数必须是Graphics类型的，而不是Graphics2D,否则将无法调用
	{
		Graphics2D g2 = (Graphics2D) g;
		String message = "Hello,World!";
		Font f = new Font("Serif",Font.BOLD,36);
		g2.setFont(f);
		
		FontRenderContext context = g2.getFontRenderContext();
		Rectangle2D bounds = f.getStringBounds(message, context);
		
		double x = (getWidth() - bounds.getWidth())/2;
		double y = (getHeight() - bounds.getHeight())/2;
		
//		System.out.println("double x = " + x);
//		System.out.println("double x = " + y);
		
		double ascent = -bounds.getY();
		double baseY = y + ascent;
		
//		System.out.println("double ascent = " + ascent);
//		System.out.println("double baseY = " + baseY);
		
		g2.drawString(message, (int) x, (int) baseY);
		g2.setPaint(Color.LIGHT_GRAY);
		
		g2.draw(new Line2D.Double(x,baseY,x + bounds.getWidth(),baseY));
		
		Rectangle2D rect = new Rectangle2D.Double(x,y,bounds.getWidth(),bounds.getHeight());
		g2.draw(rect);
	}
}
