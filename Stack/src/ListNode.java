

class ListNode <AnyType>{
	public ListNode(AnyType Myelement)
	{
		this(Myelement, null);
	}
	public ListNode(AnyType Myelement, ListNode<AnyType> n)
	{
		element =  Myelement;
		next = n;
	}

	public AnyType element;
	public ListNode<AnyType> next;
}
