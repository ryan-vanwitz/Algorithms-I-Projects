package practiceProblems;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Exercise2Shared<E extends Comparable<? super E>> {

	public static void main(String[] args) {
		Exercise2Shared<Integer> test = new Exercise2Shared<>();

        List<Integer> list1 = new LinkedList<>(Arrays.asList(14, 3, 54, 37, 95));
        List<Integer> list2 = new LinkedList<>(Arrays.asList(289, 37, 54, 7, 809));

        List<Integer> result = test.shared2(list1, list2);

        System.out.println("Common elements: " + result);

	}
	
    public List<E> shared2(List<E> L1, List<E> L2) {
        Collections.sort(L1);
        Collections.sort(L2);
        
        // Initialize an empty list to store common elements
        List<E> L3 = new LinkedList<>();
        
        // Initialize iterators for both lists
        Iterator<E> iterator1 = L1.iterator();
        Iterator<E> iterator2 = L2.iterator();
        E item1 = null, item2 = null;

        // Compare elements of both lists and add common elements to L3
        while (iterator1.hasNext() && iterator2.hasNext()) {
            if (item1 == null) item1 = iterator1.next();
            if (item2 == null) item2 = iterator2.next();

            int comparison = item1.compareTo(item2);

            if (comparison == 0) {
                L3.add(item1);
                item1 = null;
                item2 = null;
            } else if (comparison < 0) {
                item1 = null;
            } else {
                item2 = null;
            }
        }

        return L3;
    }
}