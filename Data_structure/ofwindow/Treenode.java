package ofwindow;
import java.util.*;
import java.awt.*;
import javax.swing.*;
/*¶¨ÒåÊ÷*/
public class Treenode {
       public JCheckBox key ;
       public   Treenode left, right;
       public Treenode()
       {
    	   left=right=null;
       }
       public Treenode(JCheckBox e1,Treenode lt,Treenode rt)
       {
    	   key = e1;left=lt;right = rt;
       }
       
}
