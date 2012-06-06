package ofwindow;
import java.util.*;
public class Mylist {
       protected Listnode head,tail;
       public Mylist()
       {
    	   head=tail=null;
       }
       public boolean Isempty()
       {
    	   return head==null;
       }
       public void addtoHead(String s1)
       {
    	   head = new Listnode(s1,head);
    	   if (tail==null)
    		   tail=head;
       }
       public void addtoTail(String s1)
       {
    	   if (!Isempty())
    	   {
    		   tail.next=new Listnode(s1);
    		   tail = tail.next;  		   
    	   }
    	   else head=tail=new Listnode(s1);
       }
       public void makenull()
       {
    	   head=tail=null;
       }
}

