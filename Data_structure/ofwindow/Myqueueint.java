package ofwindow;
import java.util.*;
public class Myqueueint {
	public int[] intlist = new int[50];
	public int x;
	public Myqueueint()
	{
		x=0;
	}
	public void clean()
	{
		x=0;
	}
	public boolean isEmpty()
	{
	   return x==0;	
	}
	public int dequeue()
	{
		int i1=intlist[0];
		for (int i=1;i<x;i++)
		{
			intlist[i-1]=intlist[i];
		}
		x--;
		return i1;
	}
	public int getqueue()
	{
		return intlist[0];
	}
	public void enqueue(int e1)
	{
		intlist[x]=e1;
		x++;
	}
}
