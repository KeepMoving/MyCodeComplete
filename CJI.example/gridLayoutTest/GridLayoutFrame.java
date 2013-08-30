package gridLayoutTest;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GridLayoutFrame extends JFrame 
{
	public GridLayoutFrame()
	{
		setTitle("GridLayoutTest");
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        this.setLayout(gridbag);
        gridBagConstraints.gridheight=2;
        gridBagConstraints.gridwidth=1;
        JButton jButton = new JButton("°´Å¥1");
        gridbag.setConstraints(jButton, gridBagConstraints);
        this.add(jButton);
	}
	
	public static final int DEFAULT_WIDTH = 400;
	public static final int DEFAULT_HEIGHT = 400;
}
