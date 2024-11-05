package practiceProblems;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.tuple.Pair;

public class Exercise3LargestYear {

	public static void main(String[] args) {
		  Exercise3LargestYear test = new Exercise3LargestYear();
	        List<Pair<Integer, Integer>> facultyList = List.of(
	            Pair.of(1971, 1975),
	            Pair.of(1995, null),
	            Pair.of(2016, 2018),
	            Pair.of(1996, 2001),
	            Pair.of(2020, null),
	            Pair.of(1997, 2002)
	        );
	        int largestYear = test.largestYear(facultyList);
	        System.out.println("Year with the largest number of teachers: " + largestYear);

	}
	
	public int largestYear(List<Pair<Integer,Integer>> list) {
	     // Initialize a HashMap to store the count of occurrences for each year
		 Map<Integer, Integer> numOfYears = new HashMap<>();
		
	   	 // Iterate through the list of pairs to determine the count of each year
		 for (Pair<Integer, Integer> pair : list) {
	            int startYear = pair.getLeft();
	            int endYear;
	            if (pair.getRight() == null) {
	              	 endYear = 2024;
	               } else {
	              	 endYear = pair.getRight();    
	               }
	            // Increment the count for each year within the range
	            for (int year = startYear; year <= endYear; year++) {
	            	numOfYears.put(year, numOfYears.getOrDefault(year, 0) + 1);
	            }
	        }

		    // Find the year with the maximum count
	        Integer maxYear = null;
	        int maxCount = 0;
	        for (int year : numOfYears.keySet()) {
	            if (numOfYears.get(year) > maxCount) {
	                maxYear = year;
	                maxCount = numOfYears.get(year);
	            }
	        }

	        return maxYear;
	}

}
