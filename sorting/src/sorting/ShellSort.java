//Summary:
//1.  premium insertion sort
//2.time complexity: 
//  worst case: O(N^2)
//  best case: O(N)
//  average:   O(nlogn)
//3.this is a unstable sorting

package sorting;

public class ShellSort<AnyType> {
	private int myArray[];
	private AnyType Array[];
	private int Length;
	
	public ShellSort(int length, int Array []){
		myArray = new int[length];
		myArray = Array;
		Length = length;
	}
	
	public void ShellSortImplementation(){
		int increment = Length/2;
		while(increment >= 1) {
			for(int i = 0; i < Length; i= i + increment){
				for(int j = i; j >= 1; j =  j- increment){
					int temp =  myArray[j];
					if(temp < myArray[j-increment]){
						myArray[j] = myArray[j-increment];
						myArray[j-increment] = temp;
					}
				}
			}
			increment--;
		}
	}
	
	public static void main(String args[]){
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
		ShellSort<Integer> myShell = new ShellSort<Integer>(10,array);
		long startTime =  System.nanoTime();
		myShell.ShellSortImplementation();
		long endTime = System.nanoTime();
		System.out.println(endTime-startTime);
		for(int k = 0; k < 10; k++){
			 System.out.println(array[k]);
		 }
	}
	
}
