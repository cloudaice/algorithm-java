package ofwindow;
import java.util.*;
public class Mystack {
         private LinkedList list= new LinkedList();
         public Mystack()
         {
         }
         public void clear()
         {
        	 list.clear();
         }
         public boolean isEmpty()
         {
        	 return list.isEmpty();
         }
        public Object top()
         {
			if (isEmpty())
				throw new EmptyStackException();
			return list.getLast();
         }
        public Object pop()
        {
        	if (isEmpty())
				throw new EmptyStackException();
        	return list.removeLast();
        }
        public void push(Object e1)
        {
        	list.addLast(e1);
        }
        

}