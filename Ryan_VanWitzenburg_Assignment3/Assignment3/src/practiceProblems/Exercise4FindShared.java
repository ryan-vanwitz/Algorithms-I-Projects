package practiceProblems;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Exercise4FindShared<E extends Comparable<? super E>> {
	
	 public static void main(String[] args) {
	        Exercise4FindShared<Integer> test = new Exercise4FindShared<>();
	        
	        List<Integer> list1 = new LinkedList<>(Arrays.asList(1, 3, 5, 7, 9));
	        List<Integer> list2 = new LinkedList<>(Arrays.asList(2, 3, 5, 7, 8));
	        
	        List<Integer> sharedElements = test.shared2(list1, list2);
	        
	        System.out.println("Shared elements: " + sharedElements);
	    }
	
	public List<E> shared2(List<E> L1, List<E> L2) {
		List<E> smallerList;
        List<E> largerList;
        
        // Determine the smaller and larger lists between L1 and L2
        if (L1.size() <= L2.size()) {
            smallerList = new LinkedList<>(L1);
            largerList = new LinkedList<>(L2);
        } else {
            smallerList = new LinkedList<>(L2);
            largerList = new LinkedList<>(L1);
        }
        
        // Sort the smaller list for efficient binary search
        Collections.sort(smallerList);
        
        List<E> sharedElements = new LinkedList<>();
        
        // Find shared elements between the larger list and the smaller list
        for (E element : largerList) {
            if (Collections.binarySearch(smallerList, element) >= 0) {
                sharedElements.add(element);
            }
        }
        return sharedElements;

    }
}
