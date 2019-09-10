
public class stack<AnyType> 
{
	public stack(){
		top = null;
	}
	
	public boolean isEmpty(){
		if(top == null)
			return true;
		else 
			return false;
	}
	
	public void push(AnyType value){
		if(top == null){
			top = new ListNode<AnyType>(value);
		}
		else {
			ListNode<AnyType> newNode = new ListNode<AnyType>(value);
			newNode.next = top;
			top = newNode;
		}
	}
	
	public void pop() { 
		if(top == null){
			System.out.println("Empty stack");
		}
		else {
		  top = top.next;
		}
	}
	
	public void top(){
		if(top == null){
			System.out.println("Empty stack");
		}
		else {
			AnyType TopValue = top.element;
			System.out.println(TopValue);
		}
	}
	
	public void topAndpop(){  
		if(top == null){
			System.out.println("Empty stack");
		}
		else {
			AnyType TopValue = top.element;
			System.out.println(TopValue);
		    top = top.next;
		}
	}	
	private ListNode<AnyType> top;
	public static void main(String[] args)
	{
	  stack<Double> FirstStack =  new stack<Double>();
	  FirstStack.push(1.7);
	  FirstStack.push(2.2);
	  FirstStack.top();
	}
} 
