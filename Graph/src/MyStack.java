import java.util.*;
public class MyStack {
   LinkedList<Node> t;
   MyStack() {
     t=new LinkedList<>();  
   }
   void clear() {
     t.clear();  
   }
   boolean isEmpty() {
     return(t.isEmpty());  
   }
   void enqueue(Node p) {
      t.addLast(p);
   }
   Node dequeue() {
      if(isEmpty()) return(null);
      return(t.removeFirst());
   }
   Node front() {
      if(isEmpty()) return(null);
      return(t.getFirst());    
   }
}
