package ofwindow;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import java.awt.Container;


public class WindowOfTrees extends JFrame implements ActionListener{
	public int count;//计数器，用于判断遍历到的树是否是所有打上勾的节点
	
    Mytrees boxtree = new Mytrees();
	JButton b1 = new JButton("清空");
	JTextField t1 = new JTextField(40);
	JButton b2 = new JButton("先序输出");
	JButton b3 = new JButton("中序输出");
	JButton b4 = new JButton("后序输出");
	JButton b5 = new JButton("层序输出");
	JCheckBox ca= new JCheckBox("a");
	JCheckBox cb= new JCheckBox("b");
	JCheckBox cc= new JCheckBox("c");
	JCheckBox cd= new JCheckBox("d");
	JCheckBox ce= new JCheckBox("e");
	JCheckBox cf= new JCheckBox("f");
	JCheckBox cg= new JCheckBox("g");
	JCheckBox ch= new JCheckBox("h");
	JCheckBox ci= new JCheckBox("i");
	JCheckBox cj= new JCheckBox("j");
	JCheckBox ck= new JCheckBox("k");
	JCheckBox cl= new JCheckBox("l");
	JCheckBox cm= new JCheckBox("m");
	JCheckBox cn= new JCheckBox("n");
	JCheckBox co= new JCheckBox("o");
	JCheckBox cp= new JCheckBox("p");
	JCheckBox cq= new JCheckBox("q");
	JCheckBox cr= new JCheckBox("r");
	JCheckBox cs= new JCheckBox("s");
	JCheckBox ct= new JCheckBox("t");
	JCheckBox cu= new JCheckBox("u");
	JCheckBox cw= new JCheckBox("w");
	JCheckBox cx= new JCheckBox("x");
	JCheckBox cy= new JCheckBox("y");
	JCheckBox cz= new JCheckBox("z");
	JCheckBox cA= new JCheckBox("A");
	JCheckBox cB= new JCheckBox("B");
	JCheckBox cC= new JCheckBox("C");
	JCheckBox cD= new JCheckBox("D");
	JCheckBox cE= new JCheckBox("E");
	JCheckBox cF= new JCheckBox("F");
	public JCheckBox[]  namearray={ca,cb,cc,cd,ce,cf,cg,ch,ci,cj,ck,cl,
			cm,cn,co,cp,cq,cr,cs,ct,cu,cw,cx,cy,cz,
			cA,cB,cC,cD,cE,cF};
	
	
	
	
	
    
	public WindowOfTrees()
	{   
		
		this.setTitle("树");
		this.setBounds(0, 0, 1220, 720);  
		ImageIcon img = new ImageIcon("picture/1-1.jpg");
		JLabel imglabel = new JLabel(img);
		this.getLayeredPane().add(imglabel, new Integer(Integer.MIN_VALUE));
		imglabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
		Container data = this.getContentPane();
	    data.setLayout(null);
		data.add(ca); 
		data.add(cb);
		data.add(cc);
		data.add(cd);
		data.add(ce);
		data.add(cf);
		data.add(cg);
		data.add(ch);
		data.add(ci);
		data.add(cj);
		data.add(ck);
		data.add(cl);
		data.add(cm);
		data.add(cn);
		data.add(co);
		data.add(cp);
		data.add(cq);
		data.add(cr);
	    data.add(cs);
		data.add(ct);
		data.add(cu);
		data.add(cw);
		data.add(cx);
		data.add(cy);
		data.add(cz);
		data.add(cA);
		data.add(cB);
		data.add(cC);
		data.add(cD);
		data.add(cE);
	    data.add(cF);
	    data.add(b1);
	    data.add(t1);
	    data.add(b2);
	    data.add(b3);
	    data.add(b4);
	    data.add(b5);
	    t1.setBounds(330, 580, 300, 30);
	    b1.setBounds(750, 580, 100, 30);
	    b2.setBounds(200, 630, 100, 30);
	    b3.setBounds(450, 630, 100, 30);
	    b4.setBounds(700, 630, 100, 30);
	    b5.setBounds(950, 630, 100, 30);
	    ca.setBounds(584, 0, 35, 15);
	    cb.setBounds(273, 120, 35, 15);
	    cc.setBounds(894, 120, 35, 15);
	    cd.setBounds(117, 240, 35, 15);
		ce.setBounds(428, 240, 35, 15);
		cf.setBounds(739, 240, 35, 15);
		cg.setBounds(1049, 240, 35, 15);
		ch.setBounds(39, 380, 35, 15);
		ci.setBounds(194, 380, 35, 15);
		cj.setBounds(350, 380, 35, 15);
		ck.setBounds(505, 380, 35, 15);
		cl.setBounds(661, 380, 35, 15);
		cm.setBounds(816, 380, 38, 15);
		cn.setBounds(971, 380, 35, 15);
		co.setBounds(1127, 380, 35, 15);
		cp.setBounds(0, 500, 35, 15);
		cq.setBounds(78, 500, 35, 15);
		cr.setBounds(155, 500, 35, 15);
		cs.setBounds(233, 500, 35, 15);
		ct.setBounds(311, 500, 35, 15);
		cu.setBounds(389, 500, 35, 15);
		cw.setBounds(466, 500, 35, 15);
		cx.setBounds(544, 500, 35, 15);
		cy.setBounds(622, 500, 35, 15);
		cz.setBounds(699, 500, 35, 15);
		cA.setBounds(777, 500, 35, 15);
		cB.setBounds(855, 500, 35, 15);
		cC.setBounds(932, 500, 35, 15);
		cD.setBounds(1010, 500, 35, 15);
		cE.setBounds(1088, 500, 35, 15);
		cF.setBounds(1166, 500, 35, 15);
      	/*	for(int i =0;i<31;i++)
		{
			namearray[i].addActionListener(this);
		}*/
	    ((JPanel) data).setOpaque(false);
        b1.addActionListener(this);	
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
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
	 
	 
      public void Read_Textbox()
	{
    	  count=0;
    	  for (int i=0;i<31;i++)
    	  {
    		  if (namearray[i].isSelected())
    		  {
    			  count++;
    	      } 
    	  }
    	 
	}
      
	 public void actionPerformed(ActionEvent e)
	    {
		 if (e.getSource()==b1)
		 {  
			 Read_Textbox();
			 boxtree.Readintree(namearray);
			/* if (boxtree.root.left.left.left.left.right!=null)
			 {
				 System.out.println("nihao");
				 System.out.println(boxtree.root.left.left.left.left.right.key.getText());
			 }
			 System.out.println(count);*/
			 for (int i=0;i<31;i++)
			 {
				 namearray[i].setSelected(false);
			 }
			 t1.setText("");
		 }
	 else if (e.getSource()==b2)
		 {
		     Read_Textbox();
		     boxtree.Readintree(namearray);
		     if (count==boxtree.Ccpreorder())
		     {
		     t1.setText(boxtree.Spreorder());
		     }
		     else 
		     {
		    	JOptionPane.showMessageDialog(null, "请检查您的输入是否正确","错误提示",JOptionPane.WARNING_MESSAGE); 
		     }
			 
		 }
		 else if (e.getSource()==b3)
		 {
			 
			 Read_Textbox();
			 boxtree.Readintree(namearray);
			 if (count==boxtree.Ccpreorder())
			 {
			 t1.setText(boxtree.Sinorder());
			 }
			 else 
		     {
		    	JOptionPane.showMessageDialog(null, "请检查您的输入是否正确","错误提示",JOptionPane.WARNING_MESSAGE); 
		     }
			 
		 }
		 else if (e.getSource()==b4)
		 {
			
			 Read_Textbox();
			 boxtree.Readintree(namearray);
			 if (count==boxtree.Ccpreorder())
			 {
			 t1.setText(boxtree.Spostorder());
			 }
			 else 
		     {
		    	JOptionPane.showMessageDialog(null, "请检查您的输入是否正确","错误提示",JOptionPane.WARNING_MESSAGE); 
		     }
		 }
		 else if(e.getSource()==b5) 
		 {
			 Read_Textbox();
			 boxtree.Readintree(namearray);
			 if ( count==boxtree.Ccpreorder())
			 {
			     String s1="";
				 for (int i=0;i<31;i++)
				 {
				 if (namearray[i].isSelected())
				 {
					 s1=s1+namearray[i].getText();
				 }
				 }
				 t1.setText(s1);
			 }
			 else 
		     {
		    	JOptionPane.showMessageDialog(null, "请检查您的输入是否正确","错误提示",JOptionPane.WARNING_MESSAGE); 
		     }
			 
		 }
		
	    }
	
}