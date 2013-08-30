package lianliankan;

import java.awt.*; 
import java.awt.event.*; 
public class Lianliankan implements ActionListener 
{ 
	static String s="no"; //用来纪录点击按钮的信息 
	int x0=0,y0=0,x=0,y=0,n1=0,n2=0; //用来纪录按钮的位置信息 
	Frame f,f1; 
	Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10; //用比较笨的方法添加了 
	Button b11,b12,b13,b14,b15,b16,b17,b18; //30个按钮来实现游戏界面 
	Button b19,b20,b21,b22,b23,b24,b25; //可以用数组实现，这是本人 
	Button b26,b27,b28,b29,b30,bc; //学java时，入门的联系，所以 
	Button b,ba,br,bt1,bt2; //有些东西很业余！！嘻嘻 
	Panel p1,p2,p3; 
	TextField t; //用来显示一些随机信息，方法是下面的guli(). 
	Label l; 
	int d[][]={ //用来和界面的按钮建立映射关系 
	{0,0,0,0,0,0,0}, 
	{0,0,0,0,0,0,0}, 
	{0,0,0,0,0,0,0}, 
	{0,0,0,0,0,0,0}, 
	{0,0,0,0,0,0,0}, 
	{0,0,0,0,0,0,0}, 
	{0,0,0,0,0,0,0}, 
	{0,0,0,0,0,0,0}}; 
	
	public static void main(String[] args) 
	{ 
		Lianliankan t=new Lianliankan(); 
		t.suiji(); 
		t.go(); 
	} 
public void actionPerformed(ActionEvent e) //再来一次按钮的响应事件。 
{ 
	int d[][]={ 
	{0,0,0,0,0,0,0}, 
	{0,0,0,0,0,0,0}, 
	{0,0,0,0,0,0,0}, 
	{0,0,0,0,0,0,0}, 
	{0,0,0,0,0,0,0}, 
	{0,0,0,0,0,0,0}, 
	{0,0,0,0,0,0,0}, 
	{0,0,0,0,0,0,0}}; 
	
	this.d=d; 
	suiji(); 
	f.setVisible(false); 
	f1.setVisible(false); 
	s="no"; 
	go(); 
} 


public void go()//初始化界面 
{ 
	l=new Label("亲爱的玩家，"); 
	f=new Frame("连连看"); 
	t=new TextField(); 
	p2=new Panel(); 
	p1=new Panel(); 
	p3=new Panel(); 
	bc=new Button("退出"); 
	br=new Button("重列"); 
	b=new Button(); 
	b1=new Button(String.valueOf(d[1][1])); 
	b2=new Button(String.valueOf(d[1][2])); 
	b3=new Button(String.valueOf(d[1][3])); 
	b4=new Button(String.valueOf(d[1][4])); 
	b5=new Button(String.valueOf(d[1][5])); 
	b6=new Button(String.valueOf(d[2][1])); 
	b7=new Button(String.valueOf(d[2][2])); 
	b8=new Button(String.valueOf(d[2][3])); 
	b9=new Button(String.valueOf(d[2][4])); 
	b10=new Button(String.valueOf(d[2][5])); 
	b11=new Button(String.valueOf(d[3][1])); 
	b12=new Button(String.valueOf(d[3][2])); 
	b13=new Button(String.valueOf(d[3][3])); 
	b14=new Button(String.valueOf(d[3][4])); 
	b15=new Button(String.valueOf(d[3][5])); 
	b16=new Button(String.valueOf(d[4][1])); 
	b17=new Button(String.valueOf(d[4][2])); 
	b18=new Button(String.valueOf(d[4][3])); 
	b19=new Button(String.valueOf(d[4][4])); 
	b20=new Button(String.valueOf(d[4][5])); 
	b21=new Button(String.valueOf(d[5][1])); 
	b22=new Button(String.valueOf(d[5][2])); 
	b23=new Button(String.valueOf(d[5][3])); 
	b24=new Button(String.valueOf(d[5][4])); 
	b25=new Button(String.valueOf(d[5][5])); 
	b26=new Button(String.valueOf(d[6][1])); 
	b27=new Button(String.valueOf(d[6][2])); 
	b28=new Button(String.valueOf(d[6][3])); 
	b29=new Button(String.valueOf(d[6][4])); 
	b30=new Button(String.valueOf(d[6][5])); 
	p3.setLayout(null); 
	p1.setSize(250,300); 
	p2.setSize(100,40); 
	p3.setSize(300,30); 
	t.setSize(60,30); 
	l.setSize(70,30); 
	p1.setLayout(new GridLayout(6,5)); 
	p1.setBackground(Color.pink); 
	p1.setLocation(100,100); 
	p2.setLocation(0,400); 
	p3.setLocation(50,50); 
	t.setLocation(230,2); 
	l.setLocation(150,2); 
	bc.setLocation(0,40); 
	br.setLocation(0,100); 
	f.add(p1); 
	f.add(p2); 
	f.add(p3); 
	p3.add(l); 
	p3.add(t); 
	p2.add(bc); 
	p2.add(br); 
	p1.add(b1); 
	p1.add(b2); 
	p1.add(b3); 
	p1.add(b4); 
	p1.add(b5); 
	p1.add(b6); 
	p1.add(b7); 
	p1.add(b8); 
	p1.add(b9); 
	p1.add(b10); 
	p1.add(b11); 
	p1.add(b12); 
	p1.add(b13); 
	p1.add(b14); 
	p1.add(b15); 
	p1.add(b16); 
	p1.add(b17); 
	p1.add(b18); 
	p1.add(b19); 
	p1.add(b20); 
	p1.add(b21); 
	p1.add(b22); 
	p1.add(b23); 
	p1.add(b24); 
	p1.add(b25); 
	p1.add(b26); 
	p1.add(b27); 
	p1.add(b28); 
	p1.add(b29); 
	p1.add(b30); 
	f.pack(); 
	f.setBounds(280,100,500,450); 
	f.setResizable(false); 
	f.setVisible(true); 
	
	bc.addMouseListener(new MouseAdapter(){ 
	public void mouseClicked(MouseEvent e) 
	{ 
		ex(); 
	}}); 
	
	br.addMouseListener(new MouseAdapter(){ 
	public void mouseClicked(MouseEvent e) 
	{ 
		chonglie(); 
	}}); 
	
	b1.addMouseListener(new MouseAdapter(){ 
	public void mouseClicked(MouseEvent e) 
	{ 
		wei(1,1,b1); 
	}}); 
	
	b2.addMouseListener(new MouseAdapter(){ 
	public void mouseClicked(MouseEvent e) 
	{ 
		wei(1,2,b2); 
	}}); 
	
	b3.addMouseListener(new MouseAdapter(){ 
	public void mouseClicked(MouseEvent e) 
	{ 
		wei(1,3,b3); 
	}}); 
	
	b4.addMouseListener(new MouseAdapter(){ 
	public void mouseClicked(MouseEvent e) 
	{ 
		wei(1,4,b4); 
	}}); 
	
	b5.addMouseListener(new MouseAdapter(){ 
	public void mouseClicked(MouseEvent e) 
	{ 
		wei(1,5,b5); 
	}}); 
	
	b6.addMouseListener(new MouseAdapter(){ 
	public void mouseClicked(MouseEvent e) 
	{ 
		wei(2,1,b6); 
	}}); 
	
	b7.addMouseListener(new MouseAdapter(){ 
	public void mouseClicked(MouseEvent e) 
	{ 
		wei(2,2,b7); 
	} 
	}); 
	
	b8.addMouseListener(new MouseAdapter(){ 
	public void mouseClicked(MouseEvent e) 
	{ 
		wei(2,3,b8); 
	} 
	}); 
	
	b9.addMouseListener(new MouseAdapter(){ 
	public void mouseClicked(MouseEvent e) 
	{ 
		wei(2,4,b9); 
	} 
	}); 
	
	b10.addMouseListener(new MouseAdapter(){ 
	public void mouseClicked(MouseEvent e) 
	{ 
		wei(2,5,b10); 
	} 
	}); 
	
	b11.addMouseListener(new MouseAdapter(){ 
	public void mouseClicked(MouseEvent e) 
	{ 
		wei(3,1,b11); 
	} 
	}); 
	
	b12.addMouseListener(new MouseAdapter(){ 
	public void mouseClicked(MouseEvent e) 
	{ 
		wei(3,2,b12); 
	} 
	}); 
	
	b13.addMouseListener(new MouseAdapter(){ 
	public void mouseClicked(MouseEvent e) 
	{ 
		wei(3,3,b13); 
	} 
	}); 
	
	b14.addMouseListener(new MouseAdapter(){ 
	public void mouseClicked(MouseEvent e) 
	{ 
		wei(3,4,b14); 
	} 
	}); 
	
	b15.addMouseListener(new MouseAdapter(){ 
	public void mouseClicked(MouseEvent e) 
	{ 
		wei(3,5,b15); 
	} 
	}); 
	
	b16.addMouseListener(new MouseAdapter(){ 
	public void mouseClicked(MouseEvent e) 
	{ 
		wei(4,1,b16); 
	} 
	});
	
	b17.addMouseListener(new MouseAdapter(){ 
	public void mouseClicked(MouseEvent e) 
	{ 
		wei(4,2,b17); 
	} 
	}); 
	
	b18.addMouseListener(new MouseAdapter(){ 
	public void mouseClicked(MouseEvent e) 
	{ 
		wei(4,3,b18); 
	} 
	}); 
	
	b19.addMouseListener(new MouseAdapter(){ 
	public void mouseClicked(MouseEvent e) 
	{ 
		wei(4,4,b19); 
	} 
	}); 
	
	b20.addMouseListener(new MouseAdapter(){ 
	public void mouseClicked(MouseEvent e) 
	{ 
		wei(4,5,b20); 
	} 
	}); 
	
	b21.addMouseListener(new MouseAdapter(){ 
	public void mouseClicked(MouseEvent e) 
	{ 
		wei(5,1,b21); 
	} 
	}); 
	
	b22.addMouseListener(new MouseAdapter(){ 
	public void mouseClicked(MouseEvent e) 
	{ 
		wei(5,2,b22); 
	} 
	}); 
	
	b23.addMouseListener(new MouseAdapter(){ 
	public void mouseClicked(MouseEvent e) 
	{ 
		wei(5,3,b23); 
	} 
	}); 
	
	b24.addMouseListener(new MouseAdapter(){ 
	public void mouseClicked(MouseEvent e) 
	{ 
		wei(5,4,b24); 
	} 
	}); 
	
	b25.addMouseListener(new MouseAdapter(){ 
	public void mouseClicked(MouseEvent e) 
	{ 
		wei(5,5,b25); 
	} 
	}); 
	
	b26.addMouseListener(new MouseAdapter(){ 
	public void mouseClicked(MouseEvent e) 
	{ 
		wei(6,1,b26); 
	} 
	}); 
	
	b27.addMouseListener(new MouseAdapter(){ 
	public void mouseClicked(MouseEvent e) 
	{ 
		wei(6,2,b27); 
	} 
	}); 
	
	b28.addMouseListener(new MouseAdapter(){ 
	public void mouseClicked(MouseEvent e) 
	{ 
		wei(6,3,b28); 
	} 
	}); 
	
	b29.addMouseListener(new MouseAdapter(){ 
	public void mouseClicked(MouseEvent e) 
	{ 
		wei(6,4,b29); 
	} 
	}); 
	
	b30.addMouseListener(new MouseAdapter(){ 
	public void mouseClicked(MouseEvent e) 
	{ 
		wei(6,5,b30); 
	} 
	}); 
} 


public void ex() //退出界面，可用diolog来实现有模式的类型，更加符合 
{ 
	f1=new Frame("游戏作业"); 
	f1.setLayout(new GridLayout(1,1)); 
	bt1=new Button("确定退出"); 
	bt2=new Button("再来一局"); 
	f1.add(bt1); 
	f1.add(bt2); 
	f1.pack(); 
	f1.setBounds(400,250,90,60); 
	f1.setResizable(false); 
	f1.show(); 
	f1.setVisible(true); 
	bt1.addMouseListener(new MouseAdapter()
	{ 
		public void mouseClicked(MouseEvent e) 
		{ 
			System.exit(0); 
		} 
	}); 
	
	bt2.addActionListener(this); 
} 


public void suiji() //产生随机数，来填充游戏界面对应的数组的各个位置 
{ 
	int m,n,k=0,k1,k2,k3; 
	for(m=1;m<=15;m++) 
	{ 
		k1=(int)(Math.random()*25+1); 
		for(n=1;n<=2;n++) 
		{ 
			k2=(int)(Math.random()*6+1); 
			k3=(int)(Math.random()*5+1); 
			while(d[k2][k3]!=0 && k!=30) 
			{ 
				k2=(int)(Math.random()*6+1); 
				k3=(int)(Math.random()*5+1); 
			} 
			this.d[k2][k3]=k1; 
			k++; 
		} 
	} 
} 


public void guli() //随机信息 
{ 
	int l=0; 
	t.setText(""); 
	l=(int)(Math.random()*10); 
	System.out.println(l); 
	switch(l) 
	{ 
		case 1: 
		t.setText("好！加油！"); 
		break; 
		
		case 3: 
		t.setText("你真棒！"); 
		break; 
		
		case 5: 
		t.setText("加快速度！"); 
		break; 
		
		case 6: 
		t.setText("不错啊！"); 
		break; 
		
		case 8: 
		t.setText("加油吧！"); 
		break; 
		
		case 9: 
		t.setText("够聪明!"); 
		break; 
		
		default: 
		break; 
	} 
} 
public void chonglie() //重列方法 
{ 
	int save[],i,j,n=0,k2,k3,k; 
	int d[][]={ 
	{0,0,0,0,0,0,0}, 
	{0,0,0,0,0,0,0}, 
	{0,0,0,0,0,0,0}, 
	{0,0,0,0,0,0,0}, 
	{0,0,0,0,0,0,0}, 
	{0,0,0,0,0,0,0}, 
	{0,0,0,0,0,0,0}, 
	{0,0,0,0,0,0,0}}; 
	save=new int[30]; 
	for(n=0;n<30;n++) 
	save[n]=0; //定义一个数组来保存当前的每个按钮位置上的信息 
	n=0; 
	for(i=0;i<=6;i++) 
		for(j=0;j<=5;j++) 
		{ 
			if(this.d[i][j]!=0) 
			{ 
				save[n]=this.d[i][j]; 
				n++; 
			} 
		} 
	n=n-1; 
	this.d=d; 
	while(n>=0) //产生随机位置，放置按钮 
	{ 
		k2=(int)(Math.random()*6+1); 
		k3=(int)(Math.random()*5+1); 
		while(d[k2][k3]!=0) 
		{ 
			k2=(int)(Math.random()*6+1); 
			k3=(int)(Math.random()*5+1); 
		} 
		this.d[k2][k3]=save[n]; 
		n--; 
	} 
	f.setVisible(false); 
	s="no"; //这里一定要将按钮点击信息归为初始 
	go(); 
	ling(); 
} 
public void ling() //将数组中为零的成员对应的按钮消去 
{ //用按钮类型的数组实现会简化得多， 
	if(d[1][1]==0) 
	b1.setVisible(false); 
	if(d[1][2]==0) 
	b2.setVisible(false); 
	if(d[1][3]==0) 
	b3.setVisible(false); 
	if(d[1][4]==0) 
	b4.setVisible(false); 
	if(d[1][5]==0) 
	b5.setVisible(false); 
	if(d[2][1]==0) 
	b6.setVisible(false); 
	if(d[2][2]==0) 
	b7.setVisible(false); 
	if(d[2][3]==0) 
	b8.setVisible(false); 
	if(d[2][4]==0) 
	b9.setVisible(false); 
	if(d[2][5]==0) 
	b10.setVisible(false); 
	if(d[3][1]==0) 
	b11.setVisible(false); 
	if(d[3][2]==0) 
	b12.setVisible(false); 
	if(d[3][3]==0) 
	b13.setVisible(false); 
	if(d[3][4]==0) 
	b14.setVisible(false); 
	if(d[3][5]==0) 
	b15.setVisible(false); 
	if(d[4][1]==0) 
	b16.setVisible(false); 
	if(d[4][2]==0) 
	b17.setVisible(false); 
	if(d[4][3]==0) 
	b18.setVisible(false); 
	if(d[4][4]==0) 
	b19.setVisible(false); 
	if(d[4][5]==0) 
	b20.setVisible(false); 
	if(d[5][1]==0) 
	b21.setVisible(false); 
	if(d[5][2]==0) 
	b22.setVisible(false); 
	if(d[5][3]==0) 
	b23.setVisible(false); 
	if(d[5][4]==0) 
	b24.setVisible(false); 
	if(d[5][5]==0) 
	b25.setVisible(false); 
	if(d[6][1]==0) 
	b26.setVisible(false); 
	if(d[6][2]==0) 
	b27.setVisible(false); 
	if(d[6][3]==0) 
	b28.setVisible(false); 
	if(d[6][4]==0) 
	b29.setVisible(false); 
	if(d[6][5]==0) 
	b30.setVisible(false); 
} 


public void wei(int w1,int w2,Button bz) //判断并纪录每次点击按钮的信息 
{ //当两次的按钮相同才能消去 
	if((s.trim()).equals("no")) 
	{ 
		s=b1.getLabel(); 
		x0=w1; 
		y0=w2; 
		n1=d[x0][y0]; 
		b=bz; 
		x=w1; 
		y=w2; 
		n2=d[x][y]; 
		ba=bz; 
	} 
	else 
	{ 
		x0=x; 
		y0=y; 
		n1=d[x0][y0]; 
		b=ba; 
		x=w1; 
		y=w2; 
		n2=d[x][y]; 
		ba=bz; 
		if(n1==n2 && ba!=b) 
		{ 
			xiao(); 
		} 
	} 
} 


public void xiao() //这里是整个游戏最重要的部分，就是判断两个按钮在信息 
{ //相同的情况下能不能消去。仔细分析，不一条条注释 
	int i=0, j=0,n=0,k=0; 
	if((x0==x &&(y0==y+1||y0==y-1)) || ((x0==x+1||x0==x-1)&&(y0==y))) //相邻的情况 
	{ 
	ba.setVisible(false); 
	b.setVisible(false); 
	guli(); 
	s="no"; 
	d[x0][y0]=0; 
	d[x][y]=0; 
	} 
	else 
	{ 
	for (j=0;j<7;j++ ) //两个按钮按行分析，看能否消去 
	{ 
	if (d[x0][j]==0) 
	{ 
	if (y>j) 
	{ 
	
	for (i=y-1;i>=j;i-- ) 
	{ 
	if (d[x][i]!=0) 
	{ 
	k=0; 
	break; 
	} 
	else 
	{ 
	k=1; 
	} 
	} 
	if (k==1) 
	{ 
	if (y0>j) 
	{ 
	for (i=y0-1;i>=j ;i-- ) 
	{ 
	if (d[x0][i]!=0) 
	{ 
	k=0; 
	break; 
	} 
	else 
	{ 
	k=2; 
	} 
	} 
	} 
	if (y0<j) 
	{ 
	for (i=y0+1;i<=j ;i++) 
	{ 
	if (d[x0][i]!=0) 
	{ 
	k=0; 
	break; 
	} 
	else 
	{ 
	k=2; 
	} 
	} 
	} 
	} 
	} 
	if (y<j) 
	{ 
	
	
	for (i=y+1;i<=j ;i++ ) 
	{ 
	
	if (d[x][i]!=0) 
	{ 
	k=0; 
	break; 
	} 
	else 
	{ 
	k=1; 
	} 
	} 
	if (k==1) 
	{ 
	if (y0>j) 
	{ 
	for (i=y0-1;i>=j ;i-- ) 
	{ 
	if (d[x0][i]!=0) 
	{ 
	k=0; 
	break; 
	} 
	else 
	{ 
	k=2; 
	} 
	} 
	} 
	if (y0<j) 
	{ 
	for (i=y0+1;i<=j ;i++) 
	{ 
	if (d[x0][i]!=0) 
	{ 
	k=0; 
	break; 
	} 
	else 
	{ 
	k=2; 
	} 
	} 
	} 
	} 
	} 
	if (y==j ) 
	{ 
	if (y0>j) 
	{ 
	for (i=y0-1;i>=j ;i-- ) 
	{ 
	
	if (d[x0][i]!=0) 
	{ 
	k=0; 
	break; 
	} 
	else 
	{ 
	k=2; 
	} 
	} 
	} 
	if (y0<j) 
	{ 
	for (i=y0+1;i<=j ;i++) 
	{ 
	if (d[x0][i]!=0) 
	{ 
	k=0; 
	break; 
	} 
	else 
	{ 
	k=2; 
	} 
	} 
	} 
	} 
	} 
	if (k==2) 
	{ if (x0==x) 
	{ 
	b.setVisible(false); 
	ba.setVisible(false); 
	guli(); 
	s="no"; 
	k=0; 
	d[x0][y0]=0; 
	d[x][y]=0; 
	} 
	if (x0<x) 
	{ 
	for (n=x0;n<=x-1;n++ ) 
	{ 
	if (d[n][j]!=0) 
	{ 
	k=0; 
	break; 
	} 
	if(d[n][j]==0 && n==x-1) 
	{ 
	b.setVisible(false); 
	ba.setVisible(false); 
	guli(); 
	s="no"; 
	k=0; 
	d[x0][y0]=0; 
	d[x][y]=0; 
	} 
	} 
	} 
	if (x0>x) 
	{ 
	for (n=x0;n>=x+1 ;n-- ) 
	{ 
	if (d[n][j]!=0) 
	{ 
	k=0; 
	break; 
	} 
	if(d[n][j]==0 && n==x+1) 
	{ 
	b.setVisible(false); 
	ba.setVisible(false); 
	guli(); 
	s="no"; 
	k=0; 
	d[x0][y0]=0; 
	d[x][y]=0; 
	
	} 
	} 
	} 
	} 
} 

for (i=0;i<8;i++ ) //按列分析，看能不能消去 
{ 
if (d[i][y0]==0) 
{ 
if (x>i) 
{ 

for (j=x-1;j>=i ;j-- ) 
{ 
if (d[j][y]!=0) 
{ 
k=0; 
break; 
} 
else 
{ 
k=1; 
} 
} 


if (k==1) 
{ 
if (x0>i) 
{ 
for (j=x0-1;j>=i ;j-- ) 
{ 
if (d[j][y0]!=0) 
{ 
k=0; 
break; 
} 
else 
{ 
k=2; 
} 
} 
} 
if (x0<i) 
{ 
for (j=x0+1;j<=i;j++ ) 
{ 
if (d[j][y0]!=0) 
{ 
k=0; 
break; 
} 
else 
{ 
k=2; 
} 
} 
} 
} 
} 
if (x<i) 
{ 

for (j=x+1;j<=i;j++ ) 
{ 
if (d[j][y]!=0) 
{ 
k=0; 
break; 
} 
else 
{ 
k=1; 
} 
} 
if (k==1) 
{ 
if (x0>i) 
{ 
for (j=x0-1;j>=i ;j-- ) 
{ 
if (d[j][y0]!=0) 
{ 
k=0; 
break; 
} 
else 
{ 
k=2; 
} 
} 
} 
if (x0<i) 
{ 
for (j=x0+1;j<=i ;j++ ) 
{ 
if (d[j][y0]!=0) 
{ 
k=0; 
break; 
} 
else 
{ 
k=2; 
} 
} 
} 
} 
} 
if (x==i) 
{ 


if (x0>i) 
{ 
for (j=x0-1;j>=i ;j-- ) 
{ 
if (d[j][y0]!=0) 
{ 
k=0; 
break; 
} 
else 
{ 
k=2; 
} 
} 
} 
if (x0<i) 
{ 
for (j=x0+1;j<=i ;j++ ) 
{ 
if (d[j][y0]!=0) 
{ 
k=0; 
break; 
} 
else 
{ 
k=2; 
} 
} 
} 

} 
} 
if (k==2) 
{ 
if (y0==y) 
{ 
b.setVisible(false); 
ba.setVisible(false); 
guli(); 
s="no"; 
k=0; 
d[x0][y0]=0; 
d[x][y]=0; 

} 
if (y0<y) 
{ 
for (n=y0;n<=y-1 ;n++ ) 
{ 
if (d[i][n]!=0) 
{ 
k=0; 
break; 
} 
if(d[i][n]==0 && n==y-1) 
{ 
b.setVisible(false); 
ba.setVisible(false); 
guli(); 
s="no"; 
k=0; 
d[x0][y0]=0; 
d[x][y]=0; 

} 
} 
} 
if (y0>y) 
{ 
for (n=y0;n>=y+1 ;n--) 
{ 
if (d[i][n]!=0) 
{ 
k=0; 
break; 
} 
if(d[i][n]==0 && n==y+1) 
{ 
b.setVisible(false); 
ba.setVisible(false); 
guli(); 
s="no"; 
k=0; 
d[x0][y0]=0; 
d[x][y]=0; 

} 
} 
} 
} 
} 

} 
} 
} 

