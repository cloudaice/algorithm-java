package ofwindow;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main_window extends JFrame implements ActionListener{
	Button b1 = new Button ("�����Ա�");
	Button b2 = new Button ("��");
	Button b3 = new Button ("ͼ��СӦ��");
	Button b4 = new Button ("����������");
	JLabel label=new JLabel("���ݽṹ��ʾ",JLabel.CENTER);//��֪����ô��
    JPanel pare1 = new JPanel();
    public Main_window()
    {   this.setTitle("���ݽṹ��ʾ");
    	this.setLayout(new BorderLayout());
    	pare1.add(label);
    	pare1.add(b1);
    	pare1.add(b2);
    	pare1.add(b3);
    	pare1.add(b4);
    	pare1.setLayout(new GridLayout(1,6));
    	b1.addActionListener(this);
    	b2.addActionListener(this);
    	b3.addActionListener(this);
    	b4.addActionListener(this);
    	this.add(pare1,BorderLayout.NORTH);
    	pare1.setBackground(Color.green);
    	this.setBounds(50, 50, 900, 600);    
    	this.setVisible(true);
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    }
    public void actionPerformed(ActionEvent e)
    {
    	if (e.getSource()==b1)
    		new WindowOfTable();
    	if (e.getSource()==b2)
    		new WindowOfTrees();
    	if (e.getSource()==b3)
    		new WindowOfGraphics();
    	if (e.getSource()==b4)
    	{
    		new treeinturn();
    	}
    	
    }
  
    public static void main(String[] args)
    {
        Main_window window=new Main_window();      
    }
}
