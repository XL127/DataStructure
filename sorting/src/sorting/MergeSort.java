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

package sorting;
import java.util.LinkedList;
public class MergeSort {  
	 
	public void sort(int Left, int Right, int Data[])
	{
		if(Left < Right){
			int mid = (Left + Right)/2;
			//System.out.println("----------------" + Left + "    " + mid + "    " + Right);
			sort(Left, mid, Data);
			sort(mid+1, Right, Data);
			Merge(Left, mid, Right, Data);
		}
		else
			return;
	}
	
	private void Merge(int Left, int mid, int Right, int [] Data)
	{
		//System.out.println("++++++++++++++" + Left + "    " + mid + "    " + Right);
		int temp[];
		temp = new int[Data.length];
		int rightStart = mid + 1;
		int tempCount = Left;
		int count = Left;
		
		while(Left <= mid && rightStart <= Right){
			
			if(Data[Left] < Data[rightStart]){
				temp[tempCount++] = Data[Left++];
				//System.out.println(temp[tempCount-1]);
			}
			else if (Data[rightStart] < Data[Left]){
				temp[tempCount++] = Data[rightStart++];
				//System.out.println(temp[tempCount-1]);
			}
		}
		
		while(Left <= mid) {
			temp[tempCount++] = Data[Left++];
		}
		
		while(rightStart <= Right){
			temp[tempCount++] = Data[rightStart++];
		}
		
		while(count <= Right)
		{
			Data[count] = temp[count];
			count++;
		}
	}
	
   public void print(int Data[])
   {
		for(int i = 0; i < Data.length; i++)
		{
			System.out.println(Data[i]);
		}
   }
	
	public static void main(String args[])
	{
		int myArray[] = new int[] {5, 3, 6, 2, 1, 9, 4, 8, 7};
		MergeSort sort = new MergeSort();
		sort.sort(0, myArray.length-1, myArray);
		sort.print(myArray);
	}
}
