
public class BinaryNode <AnyType> {
	
	public BinaryNode(AnyType element)
	{
		this(element, null, null);
	}
	
	public BinaryNode(AnyType element, BinaryNode<AnyType> Left, BinaryNode<AnyType> Right)
	{
		value = element;
		left = Left;
		right = Right;
	}
	
	public AnyType value;
	public BinaryNode<AnyType> left;
	public BinaryNode<AnyType> right;
}
