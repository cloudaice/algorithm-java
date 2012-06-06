	package ofwindow;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class WindowOfTable extends JFrame implements ActionListener{
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JPanel panel4 = new JPanel();
	JPanel panel5 = new JPanel();
	JPanel panel6 = new JPanel();
	JPanel panel7 = new JPanel();
	JPanel panel8 = new JPanel();
	
	JLabel label1 = new JLabel("输入 ",JLabel.LEFT);
	JLabel label2 = new JLabel("输出 ",JLabel.LEFT);
	JLabel label3 = new JLabel("在第 ");
	JLabel label4 = new JLabel("位插入");
	JLabel label5 = new JLabel("删除第 ");
	JLabel label6 = new JLabel("位");
	JLabel label7 = new JLabel("返回第");
	JLabel label8 = new JLabel("位");
	
	
	
	JButton b1 = new JButton ("确定");
	JButton b2 = new JButton ("顺序输出");
	JButton b3 = new JButton ("倒序输出");
	JButton b4 = new JButton ("确定插入");
	JButton b5 = new JButton ("确定删除");
	JButton b6 = new JButton ("全部清空");
	JButton b7 = new JButton ("确定返回");
	
	JTextField t1 = new JTextField(30);	
	JTextField t2 = new JTextField(30);
	JTextField t3 = new JTextField(10);
	JTextField t4 = new JTextField(10);
	JTextField t5 = new JTextField(10);
	JTextField t6 = new JTextField(10);
	JTextField t7 = new JTextField(10);
	Linetable oftable = new Linetable();
	
	
	
	public WindowOfTable()
	{
		this.setTitle("线性表");
		//设置布局管理器为四行两列
		this.setLayout(new GridLayout(4,2));
		this.add(panel1);
		this.add(panel2);
		this.add(panel3);
		this.add(panel4);
		this.add(panel5);
		this.add(panel6);
		this.add(panel7);
		this.add(panel8);
		panel1.setLayout(new FlowLayout());
		panel2.setLayout(new FlowLayout());
		panel3.setLayout(new FlowLayout());
		panel4.setLayout(new FlowLayout());
		panel5.setLayout(new FlowLayout());
		panel6.setLayout(new FlowLayout());
		panel7.setLayout(new FlowLayout());
		panel1.add(label1);
		panel1.add(t1);
		panel1.add(b1);
		panel2.add(label2);
		panel2.add(t2);
		panel3.add(b2);
		panel4.add(b3);
		panel5.add(label3);
		panel5.add(t3);
		panel5.add(label4);
		panel5.add(t4);
		panel5.add(b4);
		panel6.add(label7);
		panel6.add(t6);
		panel6.add(label8);
		panel6.add(b7);
		panel6.add(t7);
		panel7.add(label5);
		panel7.add(t5);
		panel7.add(label6);
		panel7.add(b5);
		panel8.add(b6);
		//为按钮增加监听器
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		//设置窗口大小
		this.setBounds(50, 50, 900, 600);   
		//设置窗口可见
    	this.setVisible(true);
    	//添加窗口关闭事件
    	 Frame frame = new Frame();
    	    frame.addWindowListener(new WindowAdapter() {
    	      public void windowClosing(WindowEvent evt) {
    	        Frame frame = (Frame) evt.getSource();
    	        frame.setVisible(false);
    	      }
    	    });
		
		
	}
	//时间监听器
	 public void actionPerformed(ActionEvent e)
	    {
	    	if (e.getSource()==b1)
	    	{
	    		oftable.addline(t1.getText().trim());
	    	}
	    	else if (e.getSource()==b2)
	    	 {
	    		t2.setText(oftable.Sout()); 
	    	 }
	    	else if (e.getSource()==b3)
	    	{
	    		t2.setText(oftable.Dout());
	    	}
	    	else if (e.getSource()==b4)
	    	{
	    		if (oftable.x>=Integer.parseInt(t3.getText().trim()))
	    		{
	    		oftable.addline(Integer.parseInt(t3.getText().trim()), t4.getText());
	    		t2.setText(oftable.Sout());
	    		}
	    		else
	    		{
	    			JOptionPane.showMessageDialog(null, "您输入数字过大，检查后再输入",
	    					"错误提示",JOptionPane.WARNING_MESSAGE);
	    		}
	    	}
	    	else if (e.getSource()==b5)
	    	{
	    		oftable.deleteline(Integer.parseInt(t5.getText().trim()));
	    		t2.setText(oftable.Sout());
	    	}
	    	else if (e.getSource()==b6)
	    	{
	    		oftable.makenull();
	    		t2.setText(oftable.Sout());
	    		t1.setText("");
	    		t3.setText("");
	    		t4.setText("");
	    		t5.setText("");
	    		t6.setText("");
	    		t7.setText("");	    			    		
	    	}
	    	else if (e.getSource()==b7)
	    	{
	    		if (oftable.x>=Integer.parseInt(t6.getText().trim()))
	    		{
	    		t7.setText(oftable.backline(Integer.parseInt(t6.getText().trim())));
	    		t2.setText(oftable.Sout());
	    		}
	    		else
	    		{
	    			JOptionPane.showMessageDialog(null, "您输入数字过大，检查后再输入",
	    					"错误提示",JOptionPane.WARNING_MESSAGE);
	    		}
	    		
	    	}
	    	
	    }
	  
	   /* public static void main(String[] args)
	    {
	         new WindowOfTable();   
	    }*/

}
