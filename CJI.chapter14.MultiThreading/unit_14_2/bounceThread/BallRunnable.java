package unit_14_2.bounceThread;

import java.awt.Component;

import unit_14_1.bounceCase.Ball;


public class BallRunnable implements Runnable 
{
	public BallRunnable(Ball aBall,Component aComponent)
	{
		ball = aBall;
		component = aComponent;
	}
	
	public void run() 
	{
		try {
//			for(int i = 1; i<= STEPS; i++)
//			{
			while(true)
			{
				ball.move(component.getBounds());//绘制图形移动轨迹
				component.repaint();//重绘组件
				Thread.sleep(DELAY);//当前线程延迟DELAY秒
			}
//			}
		} catch (InterruptedException ie) {
			System.out.println("InterruptedException:" + ie.getMessage());
		}
	}
	
	private Ball ball;
	private Component component;
	public static final int STEPS = 1000;
	public static final int DELAY = 2;
}
