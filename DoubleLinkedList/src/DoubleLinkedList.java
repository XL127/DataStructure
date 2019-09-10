
public class DoubleLinkedList<AnyType> {
    private ListNode<AnyType> head;
    private ListNode<AnyType> cur;
    private ListNode<AnyType> tail;
    private int length;
    
    public DoubleLinkedList(){
    	head = new ListNode<AnyType>(null);
    	cur =  head;
    	tail = new ListNode<AnyType>(null);
    	head.next  = tail;
    	tail.previous = head;
    	length =0;
    }
    
    public void append(AnyType newValue){
    	ListNode<AnyType> newNode = new ListNode<AnyType>(newValue);
    	newNode.previous = tail.previous;
    	tail.previous = newNode;
    	newNode.previous.next = newNode;
    	newNode.next = tail;
    	length++;
    }
    
    private ListNode<AnyType> getNodeAt(int position){
    	if(position >= length || position < 0){
    		System.out.println("Index out of range");
    		return null;
    	}
    	else {
    		cur = head.next;
    		int count = 0;
    		for(count = 0;count < position; count++){
    			cur = cur.next;
    		}
    	return cur;
    	}
    }
    
    public void getValueAt(int position){
    	 if(position < 0 || position >= length){
    		 System.out.println("Index out of range");
     	 }
    	else {
    		cur = head.next;
    		int count = 0;
    		for(count = 0;count < position; count++){
    			cur = cur.next;
    		}
    		System.out.println(cur.value);
    	}
}
    
    public void insert(int position, AnyType newValue){
        if(position < 0 || position >= length){
    		System.out.println("Index out of range");
    	 }
        else {
        	cur = getNodeAt(position);
        	ListNode<AnyType> newNode = new ListNode<AnyType>(newValue);
            cur.previous.next = newNode;
            newNode.next = cur;
            cur.previous = newNode;
            newNode.previous = cur.previous; 
            length++;
        }
    }
    
    public void delete(int position){
    	if(position < 0 || position >= length){
    		System.out.println("Index out of range");
    	}
    	else {
    		cur = getNodeAt(position);
    		cur.previous.next = cur.next;
    		cur.next.previous = cur.previous;
    		length--;
    	}
    }
    
    public AnyType getPrevious(int position){
    	if(position <= 0 || position >= length){
    		System.out.println("Index out of range");
    		return null;  //////////////////////////////////
    	}
    	else {
    	cur = getNodeAt(position);
    	System.out.println(cur.previous.value);
    	return cur.previous.value;
    	}
    }
    
    public void clear(){
    	head.next = tail;
    	tail.previous = head;
    	length=0;
    }
    
    public void printList() {
    	cur = head.next;
    	while(cur != tail){
    		System.out.println(cur.value);
    		cur = cur.next;
    	}
    }
    
    public boolean isEmpty(){
    	if (head.next == tail)
    		return true;
    	else 
    		return false;
    }
    
    public void add(DoubleLinkedList<AnyType> newList) {
    	newList.cur = newList.head.next;
    	for(int i = 0; i < newList.length; i++)
    	{
    		this.append(newList.cur.value);
    		newList.cur = newList.cur.next;
    	}
    }
    
    //deep copy the list to newList
    public void equal(DoubleLinkedList<AnyType> newList){
    	/*boolean ifEnd =false;
    	newList.cur = newList.head.next;
    	cur = head.next;
    	for(int i = 0; i < length; i++)
    	{
    		if(ifEnd == true)
    		{
    			newList.append(cur.value);
        		cur = cur.next;
    		}
    		else 
    		{
    			newList.cur.value = this.cur.value;
    			this.cur = this.cur.next;
    		
    			if(newList.cur.next == newList.tail)
    				ifEnd = true;
    			else 
    				newList.cur = newList.cur.next;
    		}
    	}
    	newList.cur.previous.next = newList.tail;*/
    	newList.clear();
    	this.cur = this.head.next;
    	for(int i = 0; i < length; i++){
    		newList.append(this.cur.value);
    		this.cur = this.cur.next;
    	}
    }
    
    
    public static void main(String[] args)
	{
		System.out.println("hello");
		DoubleLinkedList<Integer> myList1 = new DoubleLinkedList<Integer>();
		myList1.append(1);
		myList1.append(2);
		myList1.append(3);
		myList1.append(4);
	    //myList1.getValueAt(1);
	    
		DoubleLinkedList<Integer> myList2 = new DoubleLinkedList<Integer>();
	    myList2 = myList1;
	    myList2.printList();
	    myList1.clear();
	    myList2.printList();
	}
}
