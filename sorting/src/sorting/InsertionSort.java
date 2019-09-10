//summary
//1. the time complexity is 
//   worst case: O(N^2), example: 87654321 
//   best case:  O(N), example: 12345678
//   average:    O(N^2)
//2. this is a stable sorting 
//
//3. compare with bublle sort: best than normal bubble sort, but same as premium bubble sort
//   bubble sort: 
//   worst case: O(N^2)
//   best  case: O(N^2)
//   average:  O(N^2)
//
//   premium bubble sort:
//   worst case: O(N^2)
//   best case: O(N)
//   average: O(N^2)  

package sorting;

public class InsertionSort <AnyType> {
  
  private AnyType myArray[];
  private int IntArray[];
	
  public InsertionSort(AnyType [] input, int length){
	 myArray = (AnyType[]) new Object[length];
  }
  
  public InsertionSort(int [] input, int length){
	  IntArray = new int[length];
	  IntArray = input;
  }
  
  public <AnyType extends Comparable<? super AnyType>>  void InsertionImplementation(){
	  for(int i = 1; i < myArray.length; i++){
		  for(int j = i;  j > 1; j--){
			  AnyType temp = (AnyType) myArray[j];
			  if(temp.compareTo((AnyType) myArray[j-1]) < 0){
				  myArray[j] = myArray[j-1];
				//  myArray[j-1] = (AnyType) temp;
		  }
	    }
	  }
	}
  
  
  public void InsertionInt(){
	  for(int i = 1; i < IntArray.length; i++){
		  for(int j = i; j >= 1; j--){
			  int temp = IntArray[j];
			  if(temp < IntArray[j-1]){
				  IntArray[j] = IntArray[j-1];
				  IntArray[j-1] = temp;
			  }
		  }
	  }
	  
  }
  
  public static void main(String args[])
  {
	 int array[] = new int[10];
	 array[0] = 9;
	 array[1] = 3;
	 array[2] = 2;
	 array[3] = 34;
	 array[4] = 12;
	 array[5] = 0;
	 array[6] = 100;
	 array[7] = 45;
	 array[8] = 99;
	 array[9] = 127;
	 int length = 10;
	 InsertionSort<Integer> mySort = new InsertionSort<Integer>(array, 10); 
	 mySort.InsertionInt();
	 for(int k = 0; k < length; k++)
	 {
		 System.out.println(array[k]);
	 }
  }
}
