package ofwindow;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Myqueue {
     public   Treenode[] jlist = new Treenode[50];
     public  int x;
     public Myqueue()
     {    	
    	 x=0;
     }
     public void clear()
     {
    	 x=0;
     }
     public boolean isEmpty()
     {
    	 return x==0;
     }
    
     public Treenode dequeue()
     {
    	 Treenode j1=jlist[0];
    	 for(int i=1;i<x;i++)
    	 {
    		 jlist[i-1]=jlist[i];
    		 
    	 }
    	 x--;
    	 return j1;
     }
     public Treenode getqueue()
     {
    	 return jlist[0];
     }
     public void enqueue(Treenode e1)
     {
    	 jlist[x]=e1;
    	 x++;
     }
   /*  public static void main(String[] args)
     {
    	Myqueue queue = new Myqueue();
    	for(int i =0;i<10;i++)
    	{
    		queue.enqueue(i);
    	}
    	for (int i=0;i<10;i++)
    	{
    		System.out.println(queue.dequeue());
    	}
    	
    	 
     }*/
     
}    
