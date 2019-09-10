
public class ListNode<AnyType>{
	
	public ListNode(AnyType value)
	{
		this(value, null);
	}
	
	public ListNode (AnyType element, ListNode<AnyType> n)
	{
		value = element;
		next  = n;
	}
	
	public AnyType value;
	public ListNode<AnyType> next;
}
