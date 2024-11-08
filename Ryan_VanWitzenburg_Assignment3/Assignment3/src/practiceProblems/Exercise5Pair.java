package practiceProblems;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.tuple.Pair;

public class Exercise5Pair<E extends Number & Comparable<? super E>> {

	public static void main(String[] args) {

		Exercise5Pair test = new Exercise5Pair();
		BigDecimal[] arr = { BigDecimal.valueOf(1), BigDecimal.valueOf(3), BigDecimal.valueOf(5), BigDecimal.valueOf(7),
				BigDecimal.valueOf(9) };
		BigDecimal target = BigDecimal.valueOf(5);
		Pair<Integer, Integer> result = test.lessOrGreater(arr, target);
		System.out.println("Numbers less than or equal to " + target + ": " + result.getLeft());
		System.out.println("Numbers strictly greater than " + target + ": " + result.getRight());
	}

	public Pair<Number, Number> lessOrGreater(BigDecimal[] arr, BigDecimal target) {
		Arrays.sort(arr); // Ensure the array is sorted
		int index = Arrays.binarySearch(arr, target);
		int lessOrEqualCount = 0;
		int greaterThanCount = 0;

		// Determine counts based on the binary search result
		if (index >= 0) {
			// If target found, counts are calculated directly
			lessOrEqualCount = index + 1;
			greaterThanCount = arr.length - lessOrEqualCount;
		} else {
		    // If target not found, calculate counts based on insertion point
			lessOrEqualCount = -1 * (index + 1);
			greaterThanCount = arr.length - lessOrEqualCount;
		}

		return Pair.of(lessOrEqualCount, greaterThanCount);
	}
}
