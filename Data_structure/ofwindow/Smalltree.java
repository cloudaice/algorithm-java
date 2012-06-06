package ofwindow;
import java.util.*;
public class Smalltree {
	public ddbian[] ddb = new ddbian[50];
	public  int[][] g = new int[50][50];
	public boolean[] visit1 = new boolean[50];
	public int[] visitofpoint = new int[50];
	public int count1=1;
	public int k;
	public class ddbian {
		public int a;
		public int b;
		public int w;
		
	}
	
	public void getddb(int[][] G,double  point)
	{
		for(int i=0;i<50;i++)
		{
			for(int j=0;j<50;j++)
			{
				g[i][j]=0;
			}
		}
		k=1;
		for(int i = 1;i<=point;i++)
		{
			for(int j=i;j<=point;j++)
			{
				if (G[i][j]!=0)
				{

                    ddb[k]=new ddbian(); 
					ddb[k].a=i;
					ddb[k].b=j;
					ddb[k].w=G[i][j];
					k++;
				}
			}
		}
		sort(ddb,k-1);
		/*for (int i =1;i<k;i++)
		{
			System.out.print(ddb[i].a);
			System.out.print(ddb[i].b);
			System.out.println(ddb[i].w);
		}*/
		g[ddb[1].a][ddb[1].b]=ddb[1].w;
		g[ddb[1].b][ddb[1].a]=ddb[1].w;
		for(int i=2;i<=k-1;i++)
		{
			boolean exit1=false;
			count1=1;
			for (int x=0;x<50;x++)
			{
				visit1[x]=false;
			}
			DFS(ddb[i].a,point);
			for(int h=1;h<=count1-1;h++)
			{
				//System.out.print(visitofpoint[h]);
				if (visitofpoint[h]==ddb[i].b)
				{
					exit1=true;
				}
			}
		//	System.out.println("");
			if(!exit1)
			{
				g[ddb[i].a][ddb[i].b]=ddb[i].w;
				g[ddb[i].b][ddb[i].a]=ddb[i].w;
			}
				
			
		}
		
	}
	public void swap(ddbian[] a1,int i ,int j)
	{
		ddbian temp = new ddbian();
		temp=a1[i];
		a1[i]=a1[j];
		a1[j]=temp;
	}
	public void sort(ddbian[] k1,int num1)
	{
		for (int i=1;i<=num1-1;i++)
			for(int j=num1;j>i;j--)
			{
				if(k1[j].w<k1[j-1].w)
				{
					swap(k1,j,j-1);
				}
			}
	}
	 public void DFS(int i,double numofinpoint)
	 {
		 visitofpoint[count1]=i;
		 visit1[i]=true;
		 count1++;
		 for (int j=1;j<=numofinpoint;j++)
		 {
			 if ((g[i][j]!=0)&&(!visit1[j]))
			 {
				 DFS(j,numofinpoint);
			 }
		 }
	 }
}
