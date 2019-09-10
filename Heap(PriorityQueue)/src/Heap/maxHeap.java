package Heap;

import java.lang.reflect.Array;

public class maxHeap<AnyType extends Comparable <? super AnyType>> {
	private HeapNode HeapArray[];
	private int capacity;
	private int length;
	
	public maxHeap(HeapNode myArray[]){
		 HeapArray = myArray;
		 capacity = HeapArray.length;
		 length = HeapArray.length;
	}
	
	public maxHeap(int Capacity){
		capacity =  Capacity;
		length = Capacity;
		HeapArray = new HeapNode[Capacity];
	}
		
	public void buildMaxHeap(HeapNode myArray[] ){
	    HeapArray = myArray;
		for(int i = length/2-1; i >= 0; i--){
			siftDown(i);
		}
	}
	
	public boolean isHeapEmpty(){
		if(length == 0){
			return true;
		}
		else {
			return false;
		}
	}
	
	public void makeHeapEmpty(){
		for(int i = 0; i < length; i++){
			HeapArray[i] = null;
		}
		length = 0;
	}
	
	public void insertion(HeapNode input) {
		DoubleCapacity();
		HeapArray[length] = input;
		siftUp(length);
		length++;
	}
	
	public void deleteMax(){
		if(isHeapEmpty()){
			System.out.println("EmptyHeap");
		}
		else {
			swap(0, length-1);
			HeapArray[length-1] = null;
			length--;
			siftDown(0);
		}
	}
	
	public void print(){
		if(isHeapEmpty()){
			System.out.println("EmptyHeap");
		}
		else {
			for(int i = 0; i < length; i++){
				System.out.println(HeapArray[i].priority);
			}
		}
	}
	
	
	
	private void DoubleCapacity(){
		if(length < capacity){
			return;
		}
		else {
			HeapNode[] temp = new HeapNode[capacity];
			for(int i =0; i < capacity; i++){
				temp[i] = HeapArray[i];
			}
			HeapArray = new HeapNode[capacity *2];
			for(int j=0; j < capacity; j++){
				HeapArray[j] = temp[j];
			}
			capacity = capacity *2;
		}
	}
	
	
	private void siftDown(int index){
	    if(index* 2 + 1 >= length || index*2 + 2 >= length){
	    	return;
	    }
	    else {
	        int swapIndex = (HeapArray[index*2+1].priority > HeapArray[index*2+2].priority) ? index*2+1 : index*2+2;
	        if(HeapArray[index].priority < HeapArray[swapIndex].priority) {
	            swap(index, swapIndex);
	            siftDown(swapIndex);
	        }
	        else {
	            return;
	        }
	    }
	}
	
	private void siftUp(int index){
		if(index == 0){
			return;
		}
		else {
		    int minus = (index%2 == 0) ? 2 : 1; 
		    int swapIndex = (index-minus)/2;
			if(HeapArray[index].priority > HeapArray[swapIndex].priority) {
				swap(index, swapIndex);
				siftUp(swapIndex);
			}
			else {
				return;
			}
		}
	}
	
	private void swap(int a, int b){
		HeapNode temp = HeapArray[a];
		HeapArray[a] = HeapArray[b];
		HeapArray[b] = temp;
	}
	
	public static void main(String args[]){
		HeapNode<String> s1 = new HeapNode<String>(88, "88");
		HeapNode<String> s2 = new HeapNode<String>(85, "85");
		HeapNode<String> s3 = new HeapNode<String>(83,"83");
		HeapNode<String> s4 = new HeapNode<String>(72, "72");
		HeapNode<String> s5 = new HeapNode<String>(73, "73");
		HeapNode<String> s6 = new HeapNode<String>(42, "42");
		HeapNode<String> s7 = new HeapNode<String>(57, "57");
		HeapNode<String> s8 = new HeapNode<String>(6, "6");
		HeapNode<String> s9 = new HeapNode<String>(48, "48");
		HeapNode<String> s10 = new HeapNode<String>(60, "60");
		HeapNode<String> s11 = new HeapNode<String>(99, "99");
		HeapNode<String> s12 = new HeapNode<String>(24, "24");
		HeapNode<String> s13 = new HeapNode<String>(21, "21");
		HeapNode<String> s14 = new HeapNode<String>(7, "7");
	    HeapNode[] array = new HeapNode[]{s6, s9, s8, s5, s4,s1,s10, s3,s2,s7};
		maxHeap heap = new maxHeap(10);
		heap.buildMaxHeap(array);
		//heap.insertion(s11);
		heap.print();
	}
}
