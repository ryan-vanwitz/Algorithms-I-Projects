package heapWork;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MaxHeap<E extends Comparable<? super E>> {
	private E[] array;
	private int lastUsedSpot;
	
	//A heap needs to create an array of 'some size'.
	//Java chose 11, and we're using the same here.
	public MaxHeap(Class<E[]> c) { this(c,11); } 
	
	public MaxHeap(Class<E[]> c, int initialCapacity) {
		array = c.cast(Array.newInstance(c.getComponentType(), initialCapacity));  
		lastUsedSpot = 0; //arithmetic is simpler if we start at 1 and consider 0 'used up'
	}
	
	private void dump(E element) {
		array[++lastUsedSpot]=element;
	}
	//Fix a heap that we messed up by dumping data in spot k
	private void fix(int k) {
		while (k > 1 && array[k/2].compareTo(array[k]) < 0) {
			E temp = array[k/2];
			array[k/2] = array[k];
			array[k] = temp;
			k = k/2;
		}
	}
	public void insert(E element) {
		if(lastUsedSpot == array.length-1) //resize
			this.array = Arrays.copyOf(array, array.length * 2);
		dump(element);
		fix(lastUsedSpot);
	}
	
	public String toString() {
		String res = "";
		for(int i=1; i<=lastUsedSpot; i++)
			res += array[i].toString() + " ";
		return res;
	}
	
	public void heapify(int position) {
		int subtreeLeft = position * 2;
		int subtreeRight = position * 2 + 1;	
		int maximum = Integer.MIN_VALUE;
		if ((subtreeLeft <= lastUsedSpot) && array[subtreeLeft]
				.compareTo(array[position]) > 0) {
			maximum  = subtreeLeft;
		} else {
			maximum = position;
		}
		if ((subtreeRight <= lastUsedSpot) && array[subtreeRight]
				.compareTo(array[maximum]) > 0) {
			maximum  = subtreeRight;
		} 
		if (maximum != position) {
			E temp = array[position];
			array[position] = array[maximum];
			array[maximum] = temp;
			heapify(maximum);
		}
	}
	
	public void insert (E[] elements) {	
		if (elements.length >= array.length - 1) {
			this.array = Arrays.copyOf(array, elements.length * 2);
		}
		int i;
		lastUsedSpot = elements.length;	
		for (i = 0; i < elements.length; i++) {
			array[i + 1] = elements[i];
		}
		for(i = lastUsedSpot; i >= 1; i--) {
			heapify(i);
		}
	}
	
	public E getMinimum() {
		E minSoFar = array[lastUsedSpot];
		
		for ( int i = lastUsedSpot-1; i <= Math.ceil(lastUsedSpot/2.0); i--) {
			if (array[i].compareTo(minSoFar) < 0) {
				minSoFar = array[i];
			}
		}
		return minSoFar;
	}
	
	public static void main(String[] args) {
		MaxHeap<Integer> heapee = new
				MaxHeap<Integer>(Integer[].class);
		Integer[] content = {5,9,7,14,2};
		heapee.insert(content);
		System.out.println(heapee);
		
		//If you want to insert a few elements one by one:
		heapee.insert(5);
		heapee.insert(9);
		heapee.insert(7);
		heapee.insert(14);
		heapee.insert(2);
		System.out.println(heapee);
		
		Integer minimum = heapee.getMinimum();
		System.out.println(minimum);

	}

}
