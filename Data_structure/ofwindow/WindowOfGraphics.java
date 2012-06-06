package ofwindow;
import java.util.*;
import java.math.*; 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;
public class WindowOfGraphics extends JFrame implements ActionListener{
	public JButton b1 = new JButton("确定");
    public JButton b2 = new JButton("添加");
    public JButton b3 = new JButton("删除");
    public JButton b4 = new JButton("深度优先遍历");
    public JButton b5 = new JButton("广度优先遍历");
    public JButton b6 = new JButton("显示最小生成树");
    public JButton b7 = new JButton("全部清空");
    
	public JPanel p1 = new JPanel();
	public JPanel p2 = new JPanel();
	public JPanel p3 = new JPanel();
	public JPanel p4 = new JPanel();
	public JPanel p5 = new JPanel();
	public JPanel p6 = new JPanel();
	public JPanel p7 = new JPanel();
	public JPanel p8 = new JPanel();
	public JPanel p9 = new JPanel();
	
    public static double numofpoint;
	public String shape ="";
	public String shapeofdbfs="";
	public String drawsmalltree ="";
	//public String shapeofbfs="";
	public JTextField t1 = new JTextField("",8);
	public JTextField t2 = new JTextField("",2);
	public JTextField t3 = new JTextField("",2);
	public JTextField t4 = new JTextField("",2);
	public JTextField t5 = new JTextField("",4);
	public JTextField t6 = new JTextField("",4);
	public JTextField t7 = new JTextField("",30);
	public JTextField t8 = new JTextField("",30);
	
	public JLabel label1 = new JLabel("输入点数");
	public JLabel label2 = new JLabel("添加边");
	public JLabel label3 = new JLabel("权值");
	public JLabel label4 = new JLabel("删 除 边");
	public JLabel label5 = new JLabel("应 用");
	
	
	public Mycanvas drawl = new Mycanvas();
	Timer timer;
	public final int MAX1 = 50;
	public final int MAX2 = 50;
	private int a=1;
	private int b=1;
	public int count=1;
	public int[][] valueofedg = new int[MAX1][MAX2];  
	public Boolean[] visit = new Boolean[50]; 
	public int[] pointofdfs = new int[50];
	public Smalltree Stree = new  Smalltree();
	
	
	
	public WindowOfGraphics()
	{
	
		
		this.setLayout(new BorderLayout());
		this.add(p1,BorderLayout.CENTER);
		this.add(p2,BorderLayout.WEST);
		p2.setLayout(new GridLayout(7,1));
		p2.add(p3);
		p2.add(p4);
		p2.add(p5);
		p2.add(p6);
		p2.add(p7);
		p2.add(p8);
		p2.add(p9);
		p3.add(label1);
		p3.add(t1);
		p3.add(b1);
		p4.add(label2);
		p4.add(t2);
		p4.add(t3);
		p4.add(label3);
		p4.add(t4);
		p4.add(b2);
		p5.add(label4);
		p5.add(t5);
		p5.add(t6);
		p5.add(b3);
		p6.setLayout(new GridLayout(2,1));
		p6.add(b4);
		p6.add(t7);
		p7.setLayout(new GridLayout(2,1));
		p7.add(b5);
		p7.add(t8);
		p8.add(label5);
		p8.add(b6);
		p9.add(b7);
		p1.add(drawl);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		drawl.setPreferredSize(new Dimension(800,600));
		this.pack();
		this.setTitle("图");
		//this.setBounds(50, 50, 900, 600);    
    	this.setVisible(true);
    	Frame frame = new Frame();
     	frame.addWindowListener(new WindowAdapter() {
   	      public void windowClosing(WindowEvent evt) {
   	        Frame frame = (Frame) evt.getSource();
   	        frame.setVisible(false);
   	        // frame.dispose();
   	      }
   	    });
		
	}

	
	class Mycanvas extends Panel{
		public void paint(Graphics g)
		{
			g.setColor(new Color(80,100,200));
			if (shape=="drawpiont")
			{
				
				for (int i=0;i<numofpoint;i++)
				{
					g.fillOval((int)(400+250*Math.cos(i*(360/numofpoint)*Math.PI/180)),
					(int)(300+250*Math.sin(i*(360/numofpoint)*Math.PI/180)), 10, 10);
					g.drawString(String.valueOf(i+1),(int)(400+250*Math.cos(i*(360/numofpoint)*Math.PI/180)),
					(int)(300-250*Math.sin(i*(360/numofpoint)*Math.PI/180)));
				}
				//寻找数组中的值不为0的权值并画出
				for (int i =0;i<MAX1;i++)
				{
					
					for (int j=0;j<MAX2;j++)
					{
						if (valueofedg[i][j]!=0)
						{
							g.drawLine((int)(400+250*Math.cos((i-1)*(360/numofpoint)*Math.PI/180)+5),
									   (int)(300-250*Math.sin((i-1)*(360/numofpoint)*Math.PI/180)+5),
									   (int)(400+250*Math.cos((j-1)*(360/numofpoint)*Math.PI/180)+5),
									   (int)(300-250*Math.sin((j-1)*(360/numofpoint)*Math.PI/180))+5);
							g.drawString(String.valueOf(valueofedg[i][j]),
									(int)(((400+250*Math.cos((i-1)*(360/numofpoint)*Math.PI/180))
									+(400+250*Math.cos((j-1)*(360/numofpoint)*Math.PI/180)))/2)-5
									,(int)(((300-250*Math.sin((i-1)*(360/numofpoint)*Math.PI/180))
									+(300-250*Math.sin((j-1)*(360/numofpoint)*Math.PI/180)))/2)-5);
						}
					}
				}
				if (shapeofdbfs.equals("dbfs"))
				{
					g.setColor(new Color(255,255,0));
					g.fillOval((int)(400+250*Math.cos((pointofdfs[a]-1)*(360/numofpoint)*Math.PI/180)-5),
							(int)(300-250*Math.sin((pointofdfs[a]-1)*(360/numofpoint)*Math.PI/180)-5), 20, 20);
					a=a+1;
					if (a>numofpoint)
					{
					timer.stop();
					}
				}
				if (drawsmalltree.equals("drawtree"))
					{
					g.setColor(new Color(255,0,0));
					for (int m=1;m<50;m++)
					{
						for (int n=1;n<50;n++)
						{
							if (Stree.g[m][n]!=0 )
							{
								/*System.out.print(m);
			    				System.out.print(n);
			    				System.out.println(Stree.g[m][n]);*/
								g.fillOval((int)(400+250*Math.cos((n-1)*(360/numofpoint)*Math.PI/180)),
										   (int)(300-250*Math.sin((n-1)*(360/numofpoint)*Math.PI/180)), 10, 10);
								g.fillOval((int)(400+250*Math.cos((m-1)*(360/numofpoint)*Math.PI/180)),
										   (int)(300-250*Math.sin((m-1)*(360/numofpoint)*Math.PI/180)), 10, 10);
								g.drawLine((int)(400+250*Math.cos((m-1)*(360/numofpoint)*Math.PI/180)+5),
										   (int)(300-250*Math.sin((m-1)*(360/numofpoint)*Math.PI/180)+5),
										   (int)(400+250*Math.cos((n-1)*(360/numofpoint)*Math.PI/180)+5),
										   (int)(300-250*Math.sin((n-1)*(360/numofpoint)*Math.PI/180))+5);
							}
						}
					}
					}
						
				
			}
			
			
			
		
			/*g.setColor(new Color(80,100,200));
			g.drawLine(100, 100, 500, 100);
			g.drawLine(100, 150, 500, 150);
			g.drawString("1", 10, 10);
			g.drawString("2", 50, 50);
			g.fillOval(10, 10, 10, 10);
			g.fillOval(50, 50, 10, 10); 
			*/
		
		}
	}
	ActionListener taskPerformer = new ActionListener()
	{
		public void  actionPerformed(ActionEvent evt)
		{
			shape="drawpiont";
			shapeofdbfs="dbfs";
			drawl.repaint();
		}
	};
	 public void actionPerformed(ActionEvent e)
	    {
		
	    	if (e.getSource()==b1)
	    	{
	    		drawsmalltree ="";
	    		shapeofdbfs="";
	    		 //将二维数组值为0
	    		for (int i= 0;i<MAX1;i++)
	    		{
	    			for (int j=0;j<MAX2;j++)
	    			{
	    				valueofedg[i][j]=0;
	    			}
	    		}
	    		numofpoint = Double.parseDouble(t1.getText().trim());
	    		//设置判断条件
	    		shape="drawpiont";
	    		//画出顶点
	    		drawl.repaint();
	    		
	    	}
	    	if (e.getSource()==b2)
	    	{
	    		drawsmalltree ="";
	    		shapeofdbfs="";
	    		//判断要添加的边的顶点不是空值
	    		if ((t2.getText().equals(""))||(t3.getText().equals("")))
	    		{
	    			JOptionPane.showMessageDialog(null, "请检查您的输入是否正确","错误提示",JOptionPane.WARNING_MESSAGE);
	    		}else
	    		{
	    			//判断要添加的边的点是否不存在
	    		if((numofpoint<Double.parseDouble(t2.getText().trim()))||
	    				(numofpoint<Double.parseDouble(t3.getText().trim())))
	    		{
	    			JOptionPane.showMessageDialog(null, "请检查您的输入是否正确","错误提示",JOptionPane.WARNING_MESSAGE);
	    		}
	    		else 
	    		{
	    			if (t4.getText().equals(""))
	    			{
	    				JOptionPane.showMessageDialog(null, "权值不能为空","错误提示",JOptionPane.WARNING_MESSAGE);
	    			}
	    			else
	    			{
	    				
	    			//由于是无向图，因此添加边时对两个定点赋予相同的值
	    		valueofedg[(int)(Double.parseDouble(t2.getText().trim()))]
	    		           [(int)(Double.parseDouble(t3.getText().trim()))]
	    		            =(int)(Double.parseDouble(t4.getText().trim()));
	    		valueofedg[(int)(Double.parseDouble(t3.getText().trim()))]
	    		           [(int)(Double.parseDouble(t2.getText().trim()))]
	    		            =(int)(Double.parseDouble(t4.getText().trim()));
	    		shape="drawpiont";
	    		drawl.repaint();
	    			}
	    		}
	    		}
	    	}
	    	if (e.getSource()==b3)
	    	{
	    		drawsmalltree ="";
	    		shapeofdbfs="";
	    		//判断要删除的边的点不是空值
	    		if ((t5.getText().equals(""))||(t6.getText().equals("")))
	    		{
	    			JOptionPane.showMessageDialog(null, "请检查您的输入是否正确","错误提示",JOptionPane.WARNING_MESSAGE);
	    		}else
	    		{
	    		//判断要删除的边的点是否是不存在的点	
	    		if((numofpoint<Double.parseDouble(t5.getText().trim()))||
	    				(numofpoint<Double.parseDouble(t6.getText().trim())))
	    		{
	    			JOptionPane.showMessageDialog(null, "请检查您的输入是否正确","错误提示",JOptionPane.WARNING_MESSAGE);
	    		}
	    		else 
	    		{
	    			//删除边，由于是无向图要删除互相对应的边
	    		valueofedg[(int)(Double.parseDouble(t5.getText().trim()))]
	    		           [(int)(Double.parseDouble(t6.getText().trim()))]
	    		            =0;
	    		valueofedg[(int)(Double.parseDouble(t6.getText().trim()))]
	    		           [(int)(Double.parseDouble(t5.getText().trim()))]
	    		            =0;
	    		shape="drawpiont";
	    		drawl.repaint();
	    		}
	    		}
	    	}
	    if (e.getSource()==b4)
	    	{
	    	drawsmalltree ="";
	    		count=1;
	    		for (int i= 1;i<=numofpoint;i++)
	    		{
	    			visit[i]=false;
	    		}
	    		for(int i = 1;i<=numofpoint;i++)
	    		{
	    			if (!visit[i])
	    			{
	    				DFS(i);
	    			}
	    		}
	    		String st7="";
	    		for(int i=1;i<=numofpoint;i++)
	    		{
	    			st7=st7+String.valueOf(pointofdfs[i])+" ";
	    		}
	    		t7.setText(st7);
	    		a=1;
	    		timer= new Timer(1000,taskPerformer);
	    		timer.start();
	    		}
	    if (e.getSource()==b5)
	    {
	    	drawsmalltree ="";
	    	count=1;
	    	for (int i= 1;i<=numofpoint;i++)
    		{
    			visit[i]=false;
    		}
	    	for (int i =1;i<=numofpoint;i++)
	    	{
	    		if (!visit[i])
	    		{
	    			BFS(i);
	    		}
	    	}
	    	String st8="";
    		for(int i=1;i<=numofpoint;i++)
    		{
    			st8=st8+String.valueOf(pointofdfs[i])+" ";
    		}
    		t8.setText(st8);
    		a=1;
    		timer= new Timer(1000,taskPerformer);
    		timer.start();
	    }
	    if (e.getSource()==b6)
	    {
	    	shapeofdbfs="";
	    	drawsmalltree ="drawtree";
	    
	    	Stree.getddb(valueofedg, numofpoint);
	    /*	for (int m =0;m<50;m++)
	    	{
	    		for (int n=0;n<50;n++)
	    		{
	    			if (Stree.g[m][n]!=0)
	    			{
	    				
	    				System.out.print(m);
	    				System.out.print(n);
	    				System.out.println(Stree.g[m][n]);
	    			}
	    			if (valueofedg[m][n]!=0)
	    			{
	    				System.out.print(m);
	    				System.out.print(n);
	    				System.out.println(valueofedg[m][n]);
	    			}
	    		}
	    	}*/
	    	
	    	shape="drawpiont";
	    	drawl.repaint();
	    	//System.out.println("heh");
	    	
	    }
	    if (e.getSource()==b7)
	    {
	    	t1.setText("");
	    	t2.setText("");
	    	t3.setText("");
	    	t4.setText("");
	    	t5.setText("");
	    	t6.setText("");
	    	t7.setText("");
	    	t8.setText("");
	        shape="";
	        drawl.repaint();
	    }
	    		
	    	
	    }
	 public void DFS(int i)
	 {
		 pointofdfs[count]=i;
		 visit[i]=true;
		 count++;
		 for (int j=1;j<=numofpoint;j++)
		 {
			 if ((valueofedg[i][j]!=0)&&(!visit[j]))
			 {
				 DFS(j);
			 }
		 }
	 }
	 public void BFS(int k)
	 {
		 int n1;
		 Myqueueint Q = new Myqueueint();
		 Q.clean();
		 pointofdfs[count]=k;
		 count++;
		 visit[k]=true;
		 Q.enqueue(k);
		 while (!Q.isEmpty())
		 {
			 n1=Q.dequeue();
			 for(int i = 1;i<=numofpoint;i++)
			 {
				 if ((valueofedg[n1][i]!=0)&&(!visit[i]))
				 {
					 pointofdfs[count]=i;
					 count++;
					 visit[i]=true;
					 Q.enqueue(i);
				 }
			 }
		 }
	 }
	  
	  /* public static void main(String[] args)
	    {
	         new WindowOfGraphics();   
	    }*/

}

