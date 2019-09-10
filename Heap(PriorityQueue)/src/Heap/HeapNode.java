package Heap;

public class HeapNode <AnyType extends Comparable <? super AnyType>> {
	public Integer priority;
	public AnyType value;
	private int leftPriority;
	private int rightPriority;
	
	public HeapNode(int Priority, AnyType Value){
		priority = Priority;
		Value = value;
		leftPriority = -1;
		rightPriority = -1;
	}
}
