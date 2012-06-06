package ofwindow;
import java.util.*;
public class Linetable {
	public int x;
	public String[] dataofline = new String[50];  
	public Linetable()
	{
		x=0;
	}
	public void addline (String s1)
	{
		x=0;
		for (int i=0;i<s1.length();i++)
		{
		dataofline[x]=Character.toString(s1.charAt(x));
		x++;
		}
	}
	public void addline(int i1,String s1)
	{
		if (i1<=x)
		{
		for (int j=x-1;j>=i1-1;j--)
		{
			dataofline[j+1]=dataofline[j];
		}
		dataofline[i1-1]=s1;
		x++;
		}
		//else 异常处理 
	}
	public void deleteline(int i1)
	{
		if (i1<x)
		{
		for (int i=i1;i<x;i++)
		{
			dataofline[i-1]=dataofline[i];
		}
		x--;
		}
		//else 异常处理
	}
	public String backline(int i1)
	{
		return dataofline[i1-1];
		
	}
	public String Dout()
	{
		if (x>0)
		{
		String dout=dataofline[x-1];
		for (int i=x-2;i>=0;i--)
		{
			dout=dout+dataofline[i];
		}
		return dout;
		}
		else
		{
			String dout="";
			return dout;
		}
	}
	public String Sout()
	{
		if (x>0)
		{  
			String sout= dataofline[0];
			for (int i=1;i<x;i++)
			{
				sout=sout+dataofline[i];
				
			}
			return sout;
		}
		else
		{
			String  sout= "";
		    return   sout;
		}
	}
	public void makenull()
	{
	    x=0;
	}

}
