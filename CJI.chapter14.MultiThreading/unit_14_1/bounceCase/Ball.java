package unit_14_1.bounceCase;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Ball 
{
	public void move(Rectangle2D bounds)
	{
		x += dx;
		y += dy;
		if(x<bounds.getMinX())
		{
			x = bounds.getMinX();
			dx = -dx;
		}
		
		if(x + XSIZE >= bounds.getMaxX())
		{
			x = bounds.getMaxX() - XSIZE;
			dx = -dx;
		}
		
		if(y<bounds.getMinY())
		{
			y = bounds.getMinY();
			dy = -dy;
		}
		
		if(y + YSIZE >= bounds.getMaxY())
		{
			y = bounds.getMaxY() - YSIZE;
			dy = -dy;
		}
	}
	
	public Ellipse2D getShape()
	{
		return new Ellipse2D.Double(x,y,XSIZE,YSIZE);
	}
	
	private static final int XSIZE = 15;
	private static final int YSIZE = 15;
	private static double x = 0;
	private static double y = 0;
	private static double dx = 1;
	private static double dy = 1;
}
