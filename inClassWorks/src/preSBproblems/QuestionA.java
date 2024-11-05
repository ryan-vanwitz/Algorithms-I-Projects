package preSBproblems;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import caseStudy3.SortingClass;

public class QuestionA<E extends Number & Comparable<? super E>>{

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
        QuestionA<Integer> QuestionA = new QuestionA<>();
        QuestionA.questionA1(hello);
        QuestionA.questionA2(hello);
	}
	
	public void questionA1(List<E> list) {
		Collections.sort(list);
		System.out.println((list.get(list.size()-1).toString()).add(new BigDecimal(1));
	}
	
	public void questionA2(List<E> list) {
		BigDecimal currMax = new BigDecimal("0");
		for (Number elem1 : list) {
			
				BigDecimal max = new BigDecimal(elem1.toString());
				if (max.compareTo(currMax) > 0) {
					currMax = max;
				}
			}
		System.out.println(currMax.add(new BigDecimal(1)));
	}

}
