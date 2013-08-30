package gridLayoutTest;
/*
 * 每个由 GridBagLayout 管理的组件都与 GridBagConstraints 的实例相关联。
 * Constraints 对象指定组件在网格中的显示区域以及组件在其显示区域中的放置方式。”
 * 
 *（1）GridBagConstraints.gridwidthGridBagConstraints.
 *    gridheight指定组件的显示区域行（针对 gridwidth）或列（针对 gridheight）中的单元数。默认值为 1。
 *（2）GridBagConstraints.fill 当组件的显示区域大于组件的所需大小时，用于确定是否（以及如何）调整组件。
 *    可能的值为 GridBagConstraints.NONE（默认值）、
 *    GridBagConstraints.HORIZONTAL（加宽组件直到它足以在水平方向上填满其显示区域，但不更改其高度）、
 *    GridBagConstraints.VERTICAL（加高组件直到它足以在垂直方向上填满其显示区域，但不更改其宽度）和
 *    GridBagConstraints.BOTH（使组件完全填满其显示区域）。
 *（3）GridBagConstraints.anchor 当组件小于其显示区域时，用于确定将组件置于何处（在显示区域中）。
 *    可能的值有两种：相对和绝对。相对值的解释是相对于容器的ComponentOrientation 属性，而绝对值则不然。
 *（4）GridBagConstraints.weightx、GridBagConstraints.weighty 用于确定分布空间的方式，这对于指定调整行为至关重要。
 *    例如：在一个很大的窗口（如300*300）中添加两个按钮（也可以是面板）（原始大小40*30），默认的，你会发现两个按钮分别处于上下两个等大小的区域中，
 *    且只占用了一小部分，没有被按钮占用的区域就被称为额外区域。该额外区域会随着参数weightx、weighty而被分配。
 *    
 *    在下述代码中添加按钮2时c.weighty=0.8，而在添加按钮3时c.weighty=0.2，
 *    这就会导致按钮2所占区域的高大约是按钮3所占区域的高的0.8/0.2=4倍。
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
        //添加按钮1
        c.fill = GridBagConstraints.BOTH;
        c.gridheight=2;
        c.gridwidth=1;
        c.weightx=0.0;//默认值为0.0
        c.weighty=0.0;//默认值为0.0
        c.anchor=GridBagConstraints.SOUTHWEST;
        JButton jButton1 = new JButton("按钮1");
        gridbag.setConstraints(jButton1, c);
        f.add(jButton1);
        //添加按钮2        
        c.fill = GridBagConstraints.NONE;
        c.gridwidth=GridBagConstraints.REMAINDER;
        c.gridheight=1;
        c.weightx=1.0;//默认值为0.0
        c.weighty=0.8;
        JButton jButton2 = new JButton("按钮2");
        gridbag.setConstraints(jButton2, c);
        f.add(jButton2);
        //添加按钮3
        c.fill = GridBagConstraints.BOTH;
        c.gridwidth=1;
        c.gridheight=1;
        c.weighty=0.2;
        JButton jButton3 = new JButton("按钮3");
        gridbag.setConstraints(jButton3, c);
        f.add(jButton3);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(500,500);
        f.setVisible(true);
	}
}
