
public class ListNode<AnyType> {
          
      public ListNode(AnyType newValue, ListNode<AnyType> n, ListNode<AnyType> p){ //hhhhhh
    	  value = newValue;
    	  next = n;
    	  previous = p;
      }
      
      public ListNode(AnyType newValue){
    	  this(newValue, null, null);
      }
      
      public AnyType value;
      public ListNode<AnyType> next;
      public ListNode<AnyType> previous;
}
//Question private AnyType value ... warning occur