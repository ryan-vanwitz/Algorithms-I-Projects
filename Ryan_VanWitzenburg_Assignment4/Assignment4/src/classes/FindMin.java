package classes;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class FindMin<E extends Comparable<? super E>> {

	public static void main(String[] args) {

		FindMin<Integer> finder = new FindMin<>();
		int[] array = { 5, 2, 8, -1, 9 };
		List<Integer> list = Arrays.asList(-1, 5, 2, 8, 18, 9);
		Integer min = finder.getMin(array);
		Integer min2 = finder.minimum(list);
		Integer min3 = finder.getMin(list);
		System.out.println("Minimum element Question #1: " + min);
		System.out.println("Minimum element Question #2: " + min2);
		System.out.println("Minimum element Question #3: " + min3);

	}
	

	// Part II Question #1

	public int getMin(int[] array) {
		return getMin(array, 0, array.length - 1);
	}

	private int getMin(int[] array, int leftIndex, int rightIndex) {
		if (leftIndex == rightIndex) {
			// Base case: when there's only one element
			return array[leftIndex];
		}
		if (leftIndex == rightIndex - 1) {
			// Base case: when there are two elements
			if (array[leftIndex] < array[rightIndex]) {
				return array[leftIndex];
			} else {
				return array[rightIndex];
			}
		}

		// Recursive case: divide the array and compare the min of leftIndex and
		// rightIndex halves
		int middle = leftIndex + (rightIndex - leftIndex) / 2;
		int minLeftIndex = getMin(array, leftIndex, middle);
		int minRightIndex = getMin(array, middle + 1, rightIndex);
		if (minLeftIndex < minRightIndex) {
			return minLeftIndex;
		} else {
			return minRightIndex;
		}
	}
	

	// Part II Question #2

	/*
	 * Konstantin F's solution is not a good implementation of a recursive function
	 * to find the mean. One of the many things wrong with it is the inefficient
	 * recursion method. The function removes the elements in the list which
	 * decreases its readability and modifies the original list, which may cause
	 * issues later on. Additionally, the unnecessary initialization of variables
	 * adds to the memory inefficiency of their solution.
	 */

	/*
	 * RoyalHouse's code is somewhat better than Konstantin F's and we can improve
	 * upon it below.
	 */
	public E minimum(List<E> t) {
		if (t.size() == 1) {
			return t.get(0);
		}

		E first = t.get(0);
		List<E> u = t.subList(1, t.size());
		E min = minimum(u);
		return first.compareTo(min) < 0 ? first : min;
	}

	
	// Part II Question #3
	
	public E getMin(List<E> L) {
		if (L.isEmpty()) {
			return null; // Or throw an exception, depending on requirements
		}
		Iterator<E> iterator = L.iterator();
		return getMinHelper(iterator, iterator.next());
	}

	private E getMinHelper(Iterator<E> iterator, E currentMin) {
		if (!iterator.hasNext()) {
			return currentMin;
		}
		E nextElem = iterator.next();
		if (nextElem.compareTo(currentMin) < 0) {
			return getMinHelper(iterator, nextElem);
		} else {
			return getMinHelper(iterator, currentMin);
		}
	}

}
