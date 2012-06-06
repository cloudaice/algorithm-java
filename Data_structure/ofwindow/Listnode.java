package ofwindow;
import java.util.*;
/*定义结点*/
public class Listnode {
     public String info;
     public Listnode next;
     public Listnode(String s1)
     {
    	this(s1,null); 
     }
     public Listnode(String s1,Listnode l1)
     {
    	 info=s1;
    	 next=l1;
     }
}
