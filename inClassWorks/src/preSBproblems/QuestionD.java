package preSBproblems;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import caseStudy3.SortingClass;

public class QuestionD<E extends Number & Comparable<? super E>> {


	public static void main(String[] args) {
		List<String> hello = new ArrayList<>();
        hello.add("fire");
        hello.add("water");
        hello.add("fire");
        hello.add("water");
        hello.add("fire");
        hello.add("fire");
        hello.add("water");
        hello.add("water");
        hello.add("water");

        // Create an instance of SortingClass
       System.out.println(isBalanced(hello));
       System.out.println(isBalanced2(hello));
	}

	public static boolean isBalanced(List<String> L) {
		Collections.sort(L);
		return (L.get((L.size()/2)-1).equals(L.get((L.size()/2)-2)));
	}	
	
	public static boolean isBalanced2(List<String> L) {
		
		return true;
	}
}
