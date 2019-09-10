package Hash;

public class ListNode<AnyType> {
	public ListNode(AnyType key)
	{
		this(key, null);
	}
	
	public ListNode (AnyType element, ListNode<AnyType> n)
	{
		key = element;
		next  = n;
	}
	
	public AnyType key;
	public ListNode<AnyType> next;
}
