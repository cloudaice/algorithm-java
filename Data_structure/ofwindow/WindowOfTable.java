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
	
	JLabel label1 = new JLabel("���� ",JLabel.LEFT);
	JLabel label2 = new JLabel("��� ",JLabel.LEFT);
	JLabel label3 = new JLabel("�ڵ� ");
	JLabel label4 = new JLabel("λ����");
	JLabel label5 = new JLabel("ɾ���� ");
	JLabel label6 = new JLabel("λ");
	JLabel label7 = new JLabel("���ص�");
	JLabel label8 = new JLabel("λ");
	
	
	
	JButton b1 = new JButton ("ȷ��");
	JButton b2 = new JButton ("˳�����");
	JButton b3 = new JButton ("�������");
	JButton b4 = new JButton ("ȷ������");
	JButton b5 = new JButton ("ȷ��ɾ��");
	JButton b6 = new JButton ("ȫ�����");
	JButton b7 = new JButton ("ȷ������");
	
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
		this.setTitle("���Ա�");
		//���ò��ֹ�����Ϊ��������
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
		//Ϊ��ť���Ӽ�����
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		//���ô��ڴ�С
		this.setBounds(50, 50, 900, 600);   
		//���ô��ڿɼ�
    	this.setVisible(true);
    	//��Ӵ��ڹر��¼�
    	 Frame frame = new Frame();
    	    frame.addWindowListener(new WindowAdapter() {
    	      public void windowClosing(WindowEvent evt) {
    	        Frame frame = (Frame) evt.getSource();
    	        frame.setVisible(false);
    	      }
    	    });
		
		
	}
	//ʱ�������
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
	    			JOptionPane.showMessageDialog(null, "���������ֹ��󣬼���������",
	    					"������ʾ",JOptionPane.WARNING_MESSAGE);
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
	    			JOptionPane.showMessageDialog(null, "���������ֹ��󣬼���������",
	    					"������ʾ",JOptionPane.WARNING_MESSAGE);
	    		}
	    		
	    	}
	    	
	    }
	  
	   /* public static void main(String[] args)
	    {
	         new WindowOfTable();   
	    }*/

}
