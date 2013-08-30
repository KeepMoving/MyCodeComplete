package gridLayoutTest;
/*
 * ÿ���� GridBagLayout ������������ GridBagConstraints ��ʵ���������
 * Constraints ����ָ������������е���ʾ�����Լ����������ʾ�����еķ��÷�ʽ����
 * 
 *��1��GridBagConstraints.gridwidthGridBagConstraints.
 *    gridheightָ���������ʾ�����У���� gridwidth�����У���� gridheight���еĵ�Ԫ����Ĭ��ֵΪ 1��
 *��2��GridBagConstraints.fill ���������ʾ�����������������Сʱ������ȷ���Ƿ��Լ���Σ����������
 *    ���ܵ�ֵΪ GridBagConstraints.NONE��Ĭ��ֵ����
 *    GridBagConstraints.HORIZONTAL���ӿ����ֱ����������ˮƽ��������������ʾ���򣬵���������߶ȣ���
 *    GridBagConstraints.VERTICAL���Ӹ����ֱ���������ڴ�ֱ��������������ʾ���򣬵����������ȣ���
 *    GridBagConstraints.BOTH��ʹ�����ȫ��������ʾ���򣩡�
 *��3��GridBagConstraints.anchor �����С������ʾ����ʱ������ȷ����������ںδ�������ʾ�����У���
 *    ���ܵ�ֵ�����֣���Ժ;��ԡ����ֵ�Ľ����������������ComponentOrientation ���ԣ�������ֵ��Ȼ��
 *��4��GridBagConstraints.weightx��GridBagConstraints.weighty ����ȷ���ֲ��ռ�ķ�ʽ�������ָ��������Ϊ������Ҫ��
 *    ���磺��һ���ܴ�Ĵ��ڣ���300*300�������������ť��Ҳ��������壩��ԭʼ��С40*30����Ĭ�ϵģ���ᷢ��������ť�ֱ������������ȴ�С�������У�
 *    ��ֻռ����һС���֣�û�б���ťռ�õ�����ͱ���Ϊ�������򡣸ö�����������Ų���weightx��weighty�������䡣
 *    
 *    ��������������Ӱ�ť2ʱc.weighty=0.8��������Ӱ�ť3ʱc.weighty=0.2��
 *    ��ͻᵼ�°�ť2��ռ����ĸߴ�Լ�ǰ�ť3��ռ����ĸߵ�0.8/0.2=4����
 **/
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GridLayoutExample 
{
	public static void main(String[] args) 
	{
	    JFrame f = new JFrame("GridBag Layout Example");

        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        f.setLayout(gridbag);
        //��Ӱ�ť1
        c.fill = GridBagConstraints.BOTH;
        c.gridheight=2;
        c.gridwidth=1;
        c.weightx=0.0;//Ĭ��ֵΪ0.0
        c.weighty=0.0;//Ĭ��ֵΪ0.0
        c.anchor=GridBagConstraints.SOUTHWEST;
        JButton jButton1 = new JButton("��ť1");
        gridbag.setConstraints(jButton1, c);
        f.add(jButton1);
        //��Ӱ�ť2        
        c.fill = GridBagConstraints.NONE;
        c.gridwidth=GridBagConstraints.REMAINDER;
        c.gridheight=1;
        c.weightx=1.0;//Ĭ��ֵΪ0.0
        c.weighty=0.8;
        JButton jButton2 = new JButton("��ť2");
        gridbag.setConstraints(jButton2, c);
        f.add(jButton2);
        //��Ӱ�ť3
        c.fill = GridBagConstraints.BOTH;
        c.gridwidth=1;
        c.gridheight=1;
        c.weighty=0.2;
        JButton jButton3 = new JButton("��ť3");
        gridbag.setConstraints(jButton3, c);
        f.add(jButton3);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(500,500);
        f.setVisible(true);
	}
}
