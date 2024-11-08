package DivideAndConquer;

import java.util.Arrays;
import java.util.LinkedList;

public class DivideAndConquerSORT<E extends Comparable<? super E>> {

	 public static void main(String[] args) {
	        Integer[] array = {5, 3, 8, 2, 1, 7, 4, 6};
	        
	        DivideAndConquerSORT<Integer> sorter = new DivideAndConquerSORT<>();
	        
	        // Testing divide method
	        System.out.println("Dividing array:");
	        printLinkedList(sorter.divide(array, 0, array.length - 1));

	        // Testing sort method
	        System.out.println("\nSorting array:");
	        Integer[] sortedArray = sorter.sort(array);
	        System.out.println(Arrays.toString(sortedArray));
	    }
	    
	    // Method to print a LinkedList
	    private static void printLinkedList(LinkedList<Integer> list) {
	        StringBuilder sb = new StringBuilder();
	        sb.append("[");
	        for (int i = 0; i < list.size(); i++) {
	            sb.append(list.get(i));
	            if (i < list.size() - 1) {
	                sb.append(", ");
	            }
	        }
	        sb.append("]");
	        System.out.println(sb.toString());
	    }

	public LinkedList<Integer> divide(E[] array, int start, int end) {
		if (start == end) {
			LinkedList<Integer> res = new LinkedList<>();
			res.add(start);
			return res;
		}
		return conquer(array, divide(array, start, (start + end) / 2), divide(array, (start + end) / 2 + 1, end));
	}

	public LinkedList<Integer> conquer(E[] array, LinkedList<Integer> L1, LinkedList<Integer> L2) {
		if (L1.isEmpty())
			return L2;
		
		if (L2.isEmpty())
			return L1;
		
		LinkedList<Integer> res = new LinkedList<>();
		if (array[L1.get(0)].compareTo(array[L2.get(0)]) < 0) {
			res.add(L1.removeFirst());
		} else {
			res.add(L2.removeFirst());
		}
		
		res.addAll(conquer(array, L1, L2));
		return res;
	}
	
	public E[] sort(E[] array) {
		// E[] copy = Arrays.copyOf(array, array.length);
		E[] copy = array.clone();
		return sort(array, divide(array, 0, array.length-1), copy, 0);
	}
	
	
	public E[] sort(E[] array, LinkedList<Integer> res, E[] result, int index) {
		if (res.isEmpty()) {
			return result;
		}
		
		result[index] = array[res.removeFirst()];
		index++;
		
		return sort(array, res, result, index);
	}
}











