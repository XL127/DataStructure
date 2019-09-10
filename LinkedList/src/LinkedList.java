/*
comparion between array list and linked list
    1. insert and deletion: arraylist needs n (worst case)
                         Linked list needs 1 
    2. traverse and direct accesss: arraylist needs n (worst case)
                                 Linked List needs 1
    3. overhead for linked list:
          1.every element requires for a overhead(the "next" pointer)
          2.tail and head pointer
       overhead for array list:
       if the array is not full, then the empty array elements are overhead
    
    4. memory allocate:
       arraylist: allocate in advance
       linked list: memory growing with elements
       
       
    Conclusion:
    1. arraylist : traversing and direct access
    2. insertion and deletion : linked list 
    3. fewer data: linked list
    2. when a array is close to full, it is better than linked list
    probably:
    1. array list is always better than linked list
    2. when doing deletion and insertion, if the data is close to head or end, than using linked list
  */
public class LinkedList<AnyType> {

	public LinkedList(){
		top = new ListNode<AnyType>(null);
		current = top;
		tail = new ListNode<AnyType>(null);
		top.next = tail;
		length = 0;
	}
	
	public boolean isEmpty(){
		if(top.next == tail) { return true;}
		else 
			return false;
	}
	
	public void append(AnyType element){
		   current = top;
		   while(true){
			   if(current.next == tail) {break;}
			   current =current.next;
		   }
		   current.next = new ListNode<AnyType>(element);
		   current.next.next = tail;
		   length++;
	}
	
	
	public ListNode<AnyType> getNodeAt(int position){
		 if(position >= length || position < 0){
			  System.out.println("index out of range");
			  return null;
		  }
		 else {
			 int count = 0;
			 current = top.next;
			 for(count = 0; count < position; count++){
					current = current.next;
			}
			return current;
		 }
	}
	
	public void insert(int newPosition, AnyType newValue)
	{
	  if(newPosition >= length || newPosition < 0){
		  System.out.println("index out of range");
	  }
	  else {
		  ListNode<AnyType> newNode = new ListNode<AnyType>(newValue);
		  current = getNodeAt(newPosition-1);
		  newNode.next = current.next;
		  current.next = newNode;
		  length++;
	  }
	}
	
	public void delete(int DeletePosition)
	{
		if(DeletePosition >= length || DeletePosition < 0){
			System.out.println("Index out of range");
		}
		else {
		    current = getNodeAt(DeletePosition -1);
		    current.next = current.next.next;
		    length--;
		}
	}
	
	public void printList(){
		current = top.next;
		while(current != tail){
			System.out.println(current.value);
			current = current.next;	
		}
	}
	
	public void clear(){
		top.next = tail; 
		length = 0;
	}
	
	
	/*public void add(LinkedList<AnyType> newList){
		for(int = 0; )
	}
	*/
	private int length;
	public ListNode<AnyType> current;
	public ListNode<AnyType> top;
	public ListNode<AnyType> tail;
	
	public static void main(String[] args)
	{
		System.out.println("hello");
		LinkedList myList1 = new LinkedList();
		 myList1.append(1);
		 myList1.append(2);
		 myList1.append(3);
		 myList1.append(4);
		 myList1.delete(1);
		 myList1.insert(1, 7);
		// myList1.clear();
		 myList1.printList();
		//System.out.println("Length is: " + myList1.length);
	//	LinkedList<Integer> myList2 = new LinkedList<Integer>();
		//myList2 =  myList1;
		//myList1.insert(2, 7);
		//myList2.printList();
	}
}

//Question: why need prev and cur
//In the code above, cur is prev.

//Question: why need top and tail
//top for recognize the head of the list, tail is for the code is able to delete the last element.


