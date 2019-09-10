/* summary:
 * 1. Time complexity:
 *    best case: nlogn
 *    worst case: N^2 (completely reversed: 987654321)
 *    average case: nlogn
 * 2. This is a unstable sorting
 * 
 * 3. quick sort is not suitable for linked list, since linked list 
 *    does not support direct access. Therefore, traverse is costly
 */


package sorting;

public class quickSort <AnyType extends Comparable <? super AnyType>> {
	
	private int array[];
	
	public quickSort(int newArray[]){
	    array = new int[newArray.length];
		for(int i = 0; i < newArray.length; i++)
		{
			array[i] = newArray[i];
		}
	}
	
	
	public void quickSort(int leftInput, int rightInput, int pivot)	{
		int left = leftInput;
		int right = rightInput;
	
    	if(left >= right) {
			return;
		}
		
		while(left < right){
			while(array[right] > array[pivot] && left < right){
				right = right - 1;
			}
			
			while (array[left] <= array[pivot] && left < right){
				left = left + 1;
			}
			 swap(array, left, right);
		}
			swap(array, left, pivot);
			
			
			/*System.out.println(left);
			System.out.println(right);
			System.out.println(pivot);
			System.out.println("HHHH");*/
			//print();
		    quickSort(leftInput, right-1, leftInput);
		    quickSort(right+1,rightInput, right+1);
	}
	
	public void swap(int array[], int left, int right){
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp; 
	}
	
	 public void print()
	 {
			for(int i = 0; i < array.length; i++)
			{
				System.out.println(array[i]);
			}
	  }
		
	
	public static void main(String args[])
	{
		int myArray[] = new int[] {3,2, 1, 87, 9, 13, 4, 99, 43, 23, 45, 12, 87, 1, 2};
		quickSort sort = new quickSort(myArray);
		//sort.print();
		 sort.quickSort(0, myArray.length-1, 0);
		 sort.print();
	//	System.out.print("HELLO");
	}
}
