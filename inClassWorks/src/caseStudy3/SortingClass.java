package caseStudy3;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingClass<E extends Number & Comparable<? super E>> {

	public static void main(String[] args) {
		List<Integer> hello = new ArrayList<>();
        hello.add(1);
        hello.add(4);
        hello.add(6);
        hello.add(3);
        hello.add(5);
        hello.add(3);
        hello.add(86);
        hello.add(80);
        hello.add(4);

        // Create an instance of SortingClass
        SortingClass<Integer> sortingClass = new SortingClass<>();

        // Call maxDiff and maxDiffSorted methods
        sortingClass.maxDiff(hello);
        sortingClass.maxDiffSorted(hello);
        sortingClass.maxDiffLinearTime(hello);

	}
	
	// brute force
	public void maxDiff(List<E> list) {
		BigDecimal currMax = new BigDecimal("0");
		for (Number elem1 : list) {
			for (Number elem2 : list) {
				BigDecimal diff = new BigDecimal(elem1.toString()).subtract(new BigDecimal(elem2.toString()));
				if (diff.compareTo(currMax) > 0) {
					currMax = diff;
				}
			}
		}
		System.out.println(currMax.abs());
	}
	
	// brute force sorted
	public void maxDiffSorted(List<E> list) {
		BigDecimal currMax = new BigDecimal("0");
		Collections.sort(list);
		BigDecimal diff = new BigDecimal(list.get(0).toString()).subtract(new BigDecimal(list.get(list.size()-1).toString()));
		System.out.println(diff.abs());
	}
	
	// Streams (Linear Time)
	public void maxDiffLinearTime(List<E> list) {
		BigDecimal diff = List.stream(list).max();
		System.out.println(diff.abs());

	}
}
