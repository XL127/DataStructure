/*
Merge Sort:
1. Time complexity:
   worst case: nlogn
   best case:  nlogn
   averge:     nlogn

2. This is a stable sorting 
3.     merge sort is best for Linked List, since linked list is easy to break and 
   re-linked, there is no additional space required. In addition, merge sort does
   not require insert and traverse methods.
      For an array, merge sort requires additional space (the temp array to store
   sorted value)
*/


public class MergeSortList<AnyType extends Comparable <? super AnyType>> {
	
	public ListNode<AnyType> Sort(ListNode<AnyType> head){
		//System.out.println("HELLO");
		if(head.next.next.next == null){	
			return head;
		}
		//System.out.println("HELLO");
		ListNode<AnyType> slow = new ListNode<AnyType>(null);
		ListNode<AnyType> fast = new ListNode<AnyType>(null);
		slow = head;
		fast = head;
		while ( fast.next != null  && fast.next.next != null){
			//   System.out.println("Hello");
				slow = slow.next;
				fast = fast.next.next;
		} 
		//System.out.println(slow.value);
	//	System.out.println(slow.next.value);
		ListNode<AnyType> mid = new ListNode<AnyType>(null);
		ListNode<AnyType> headEnd = new ListNode<AnyType>(null);
		mid.next = slow.next ;
		slow.next = headEnd;
		head = Sort(head);
		mid = Sort(mid);
	   // print(head);
	   // System.out.println("FENGE");
	   // print(mid.next);
	   // System.out.println("HELLO");
		return Merge(head, mid);
	}
	
	public ListNode<AnyType> Merge(ListNode<AnyType> head, ListNode<AnyType> mid){
		ListNode<AnyType> newNode = new ListNode<AnyType>(null);
		ListNode<AnyType> compareHead = new ListNode<AnyType>(null);
		ListNode<AnyType> compareMid = new ListNode<AnyType>(null);
		ListNode<AnyType> newNodeReturn = new ListNode<AnyType>(null);
		newNodeReturn =  newNode;
		
		compareHead = head.next;
		compareMid = mid.next;
		//System.out.println(compareHead.value);
		//System.out.println(compareMid.value);
		do{
			if(compareHead.value.compareTo(compareMid.value) <= 0){
			//	System.out.println(compareHead.value);
			//	System.out.println("JJJ");
				newNode.next = compareHead;
				compareHead = compareHead.next;
			//	System.out.println(compareHead.value);
			}
			else if (compareHead.value.compareTo(compareMid.value) > 0){
				newNode.next = compareMid;
				compareMid = compareMid.next;
			//	System.out.println("BIGER");
			//	System.out.println(compareHead.value);
			}
			newNode = newNode.next;
		} while(compareHead.next !=  null && compareMid.next != null);
		
		if(compareHead.next == null) {
			newNode.next = compareMid;
		//	System.out.println("JJJ");
		}
		else {
			newNode.next = compareHead;
		//	System.out.println("GGG");
		}
		//System.out.println(">>>>>>>>>>>>>>>>>>>");
	//	print(newNodeReturn);
	//	System.out.println("FENGE");
		return newNodeReturn;
	}
	
	
	public void print(ListNode<AnyType> print)
	{
		//ListNode<AnyType> print = printNode.top;
		while(print.next != null){
			System.out.println(print.value);
			print = print.next;
		}
	}
	
	public static void main(String args[]){
		LinkedList<Integer> myList = new LinkedList<Integer>();
		myList.append(2);
		myList.append(1);
		myList.append(3);
		myList.append(5);
		myList.append(7);
		myList.append(6);
		myList.append(4);
		myList.append(8);
		myList.append(9);
		myList.append(13);
		myList.append(10);
		myList.append(11);
     	myList.append(13);
		MergeSortList<Integer> sort = new MergeSortList<Integer>();
		myList.top = sort.Sort(myList.top);
		sort.print(myList.top.next);
	}
}
