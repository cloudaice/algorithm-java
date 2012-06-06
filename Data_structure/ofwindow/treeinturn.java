package ofwindow;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.Timer;

import java.math.*;

public class treeinturn extends JFrame implements ActionListener{
	public JTextField[] oftext = new JTextField[18];
	public JTextField[] outtext = new JTextField[18];
	public JButton b1 = new JButton("È·¶¨");
	public JLabel j1 = new JLabel("Êä³ö");
	public JPanel p1 = new JPanel();
	public JPanel p2 = new JPanel();
	public JPanel p3 = new JPanel();
	public JPanel p4 = new JPanel();
	public Mypanel draw2 = new Mypanel(); 
	public Treeint root = new Treeint();
	public Treeint root1 = new Treeint();
	public int[]  getoftext = new int[18];
	public int count3=0;
	public int count4=1;
	public int count5=0;
	Timer timer1;
	String textstr="";
	public treeinturn ()
	{
		for (int i=0;i<oftext.length;i++)
		{
			oftext[i]=new  JTextField("",3);
			outtext[i]= new JTextField("",3);
		}
		
		this.setLayout(new BorderLayout());
		//this.add(p1,BorderLayout.NORTH);
		this.add(p2,BorderLayout.CENTER);
		this.add(p4,BorderLayout.SOUTH);
		p4.setLayout(new GridLayout(2,1));
		p4.add(p1);
		p4.add(p3);
		p3.add(j1);
		for (int i = 0;i<oftext.length;i++)
		{
			p1.add(oftext[i]);
			p3.add(outtext[i]);
		}
		p1.add(b1);
		p2.add(draw2);
		this.setTitle("ÅÅÐòÊ÷");
		draw2.setPreferredSize(new Dimension(800,600));
		this.pack();
		this.setVisible(true);
		b1.addActionListener(this);
		Frame frame = new Frame();
     	frame.addWindowListener(new WindowAdapter() {
   	    public void windowClosing(WindowEvent evt) {
   	    Frame frame = (Frame) evt.getSource();
   	    frame.setVisible(false);
   	     // frame.dispose();
   	      }
   	    });
	}
	class Mypanel extends JPanel{
		public void paint(Graphics g)
		{
			if (textstr.equals("draw"))
			{
			g.setColor(new Color(80,100,200));
            Treeint p = new Treeint();
            root1.key=Integer.parseInt(oftext[0].getText().trim());
            root1.x=400;
            root1.y=20;
            p=root1;
            g.fillOval(400, 20, 10, 10);
            g.drawString(oftext[0].getText(), 400, 20);
			boolean istrue =true;
	    	while (istrue)
	    	{
	    		if (Integer.parseInt(oftext[count4].getText().trim())>=p.key)
	    		{
	    			if (p.right==null)
	    			{
	    				p.right=new Treeint();
	    				p.right.x=(int)(p.x+200/Math.pow(2,(int)(p.y/140)));
	    				p.right.y=p.y+140;
	    				p.right.key=Integer.parseInt(oftext[count4].getText().trim());
	    				g.fillOval(p.right.x, p.right.y, 10, 10);
	    				g.drawString(oftext[count4].getText(), p.right.x, p.right.y);
	    				g.drawLine(p.x+5, p.y+5, p.right.x+5, p.right.y+5);
	    				istrue=false;
	    			}
	    			p=p.right;
	    		}
	    		else
	    		{
	    			if (p.left==null)
	    			{
	    				p.left=new Treeint();
	    				p.left.x=(int)(p.x-(200/Math.pow(2,(int)(p.y/140))));
	    				p.left.y=p.y+140;
	    				p.left.key=Integer.parseInt(oftext[count4].getText().trim());
	    				g.fillOval(p.left.x, p.left.y, 10, 10);
	    				g.drawString(oftext[count4].getText(), p.left.x, p.left.y);
	    				g.drawLine(p.x+5, p.y+5, p.left.x+5, p.left.y+5);
	    				istrue=false;
	    			}
	    			p=p.left;
	    		}
	    	}
	    	count4++;
	    	if (count4==count5+1)
	    	{
	    		timer1.stop();
	    	}
	    	}
		}
	}
	ActionListener taskPerformer = new ActionListener()
	{
		public void  actionPerformed(ActionEvent evt)
		{
			draw2.repaint();
		}
	};
    public void intree(Treeint p,int e1)
    {
    	boolean istrue =true;
    	while (istrue)
    	{
    		if (e1>=p.key)
    		{
    			if (p.right==null)
    			{
    				p.right=new Treeint();
    				p.right.key=e1;
    				istrue=false;
    			}
    			p=p.right;
    		}
    		else
    		{
    			if (p.left==null)
    			{
    				p.left=new Treeint();
    				p.left.key=e1;
    				istrue=false;
    			}
    			p=p.left;
    		}
    	} 	
    }
    public void inorder(Treeint q)
    {
    	if (q!=null)
    	{
    		inorder(q.left);
    		getoftext[count3]=q.key;
    		count3++;
    		inorder(q.right);
    	}
    }

	 public void actionPerformed(ActionEvent e)
	    {
		 if (e.getSource()==b1)
		 {
			
			 root.key=Integer.parseInt(oftext[0].getText().trim());
			 count3=0;
			 count5=0;
			 for (int i=1;i<oftext.length;i++)
			 {	
				if (!(oftext[i].getText().equals("")))
				{			
				int getint= Integer.parseInt(oftext[i].getText().trim());
				count5++;
				intree(root,getint);
				}
			 } 
				inorder(root);
			for (int i =0;i<count3;i++)
				{
				outtext[i].setText(String.valueOf(getoftext[i]));
				}
			 }
		 textstr="draw";
		 timer1 = new Timer(1000,taskPerformer);
		 timer1.start();
	    }
	
	
}
