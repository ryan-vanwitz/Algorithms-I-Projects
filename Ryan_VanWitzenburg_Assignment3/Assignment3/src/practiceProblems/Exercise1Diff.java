package practiceProblems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Exercise1Diff<E extends Comparable<? super E>> {

	  public static void main(String[] args) {
	        // Example usage:
	        Exercise1Diff test = new Exercise1Diff();
	        List<Integer> list = List.of(3, 1, 2);
	        int result = test.compare(list, Comparator.naturalOrder(), Comparator.reverseOrder());
	        System.out.println("Number of elements in the same place: " + result); // Output: 1
	    }

	    public int compare(List<E> list, Comparator c1, Comparator c2) {
	    	// Create sorted copies of the input list using the provided comparators
	        List<E> sorted1 = new ArrayList<>(list);
	        List<E> sorted2 = new ArrayList<>(list);
	        sorted1.sort(c1);
	        sorted2.sort(c2);
	        
	        // Compare corresponding elements of the sorted lists
	        // Increment count if corresponding elements are equal
	        int count = 0;
	        for (int i = 0; i < list.size(); i++) {
	        	// System.out.println(sorted1.get(i));
	        	// System.out.println(sorted2.get(i));
	            if (sorted1.get(i).equals(sorted2.get(i))) {
	                count++;
	            }
	        }
	        return count;
	    }
	}