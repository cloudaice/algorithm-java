package ofwindow;
import java.util.*;
import java.awt.*;
import javax.swing.*;
/*¶¨ÒåÊ÷*/
public class Treeint {
	
       public int key ;
       public int x;
       public int y;
       public   Treeint left, right;
       public Treeint()
       {
    	  key =0;x=0;y=0; 
    	  left=right=null;
       }
       public Treeint(int  e1,Treeint lt,Treeint rt)
       {
    	   key = e1;left=lt;right = rt;
       }
       
}
