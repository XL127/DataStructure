
public class ArrayList<AnyType> {
   private int capacity;
   private AnyType theArray[];
   private AnyType value;
   private int length;
   
   
   public ArrayList(int setCapacity) {
	   length = 0;
	   capacity =  setCapacity;
	   theArray = (AnyType[]) new Object [capacity];
   }
   
   public void  checkCapacity(){
	   if (length < capacity){ }
	   else{
		  AnyType oldArray[] = theArray;
		  theArray = (AnyType[]) new Object [capacity*2];
		  for(int i = 0; i < length; i++) {
			  theArray[i] = oldArray[i];
		  }
		  capacity = capacity * 2;
	   }
   }
   
   public void append(AnyType newValue){
	   checkCapacity();
	   theArray[length] = newValue;
	   length++;
   }
   
   public boolean checkValid(int position){
	   if (position >= length || position < 0) 
		   return false;
	   else
		   return true;			   
   }
   
   public void insert(int position, AnyType newValue) {
	 if(checkValid(position)) {
	   checkCapacity();
	   for(int i = length-1 ; i >= position; i--){
		   theArray[i+1] = theArray[i];
	   }
	   theArray[position] = newValue;
	   length++;
	 }
	 else
		 System.out.println("index out of range");
   }
   
   public void delete(int position){
	  if(checkValid(position)) {
	   for(int i = position; i < length-1; i++){
		   theArray[i] = theArray[i+1];
	   }
	   length--;
	  }
	  else 
		  System.out.println("index out of range");
   }
   
   public void  getNodeAt(int position){
	   if(checkValid(position)){
		  System.out.println(theArray[position]);
	   }
	   else {
		   System.out.println("index out of range");
	   }
   }
   
   public void printList(){
	   for(int i = 0; i < length; i++) {
		   System.out.println(theArray[i]);
		  }
   }
   
   public static void main(String[] args){
	   ArrayList<Long> myArray = new ArrayList<Long>(2);
	   for(int i =0; i < 100000; i++)
	   {
		   myArray.append(System.currentTimeMillis());
	   }
	   long startTime = System.nanoTime();
	   myArray.insert(66666,System.currentTimeMillis());
	   long endTime = System.nanoTime();
	   System.out.println(endTime - startTime);
	   //myArray.printList();
	   //myArray.getNodeAt(1);
	  // System.out.println("the length is " + myArray.length);
	   //System.out.println("the cpacity is " + myArray.capacity);
   }
}


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
    1. fewer data: linked list
    2. when a array is close to full, it is better than linked list
  */

