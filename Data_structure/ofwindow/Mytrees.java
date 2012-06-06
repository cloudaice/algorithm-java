package ofwindow;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Mytrees {
        public Treenode root = new Treenode();
        public Treenode p = new Treenode();
        public String[] Tarray = new String[40];
        public int count1;
        public Mytrees()
        {
        	count1=0;
        }
        
        public void Readintree(JCheckBox[] o1 )
        {
        	int i=0;
        	Myqueue queue = new Myqueue();
        	p=root;
        	queue.enqueue(p);
        	
        	while (i<15)
        	{
        		
        		p=queue.dequeue();
        		p.key=o1[i];
        		i++;
        		p.left=new Treenode();
        		p.right=new Treenode();
        		p.left.key=o1[1];
        		p.right.key=o1[1];
        		queue.enqueue(p.left);
        		queue.enqueue(p.right);
        	}
        	for(int j=15;j<31;j++)
        	{
        		p=queue.dequeue();
        		p.key= o1[j];
        		p.left=null;
        		p.right=null;
        	}		
        	
         }
        public void preorder(Treenode q)
        {
        	if ((q!=null)&&(q.key.isSelected()))
        	{
                Tarray[count1]=q.key.getText();
                count1++;
        	preorder(q.left);
        	preorder(q.right);
        	}
        }
       
        public void inorder(Treenode q)
        {
        	if ((q!=null)&&(q.key.isSelected()))
        	{
        		inorder(q.left);
        		Tarray[count1]=q.key.getText();
                count1++;
        		inorder(q.right);
        	}
        }
      
        public void postorder(Treenode q)
        {
        	if ((q!=null)&&(q.key.isSelected()))
        	{
        		postorder(q.left);
        		postorder(q.right);
        		Tarray[count1]=q.key.getText();
                count1++;
        	}
        }
        public String Spreorder()
        {
        	count1=0;
        	preorder(root);
        	String Spre=Tarray[0];
        	for (int i=1;i<count1;i++)
        	{
        		Spre=Spre+Tarray[i];
        	}
        	return Spre;
        	
        }
        public String  Sinorder()
        {
        	count1=0;
        	inorder(root);
        	String Sin=Tarray[0];
        	for (int i =1;i<count1;i++)
        	{
        		Sin=Sin+Tarray[i];
        	}
        	return Sin;
        }
        public String Spostorder()
        {
        	count1=0;
        	postorder(root);
        	String Spost=Tarray[0];
        	for (int i=1;i<count1;i++)
        	{
        		Spost= Spost+Tarray[i];
        	}
            return Spost;
        }
     
        public void Cpreorder(Treenode q)
        {
        	if ((q!=null)||(q.key.isSelected()))
        	{
                 count1++;
        	}
        	preorder(q.left);
        	preorder(q.right);
        }
        public int  Ccpreorder()
        {
        	count1=0;
        	preorder(root);
        	return count1;
        }
}
