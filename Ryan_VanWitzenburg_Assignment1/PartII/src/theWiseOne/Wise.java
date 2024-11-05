
/*
 * Answer to Part III - 5)
 * 
 * Using a 2D array instead of the object-oritened approach below would help 
 * with space and memory consumption. The way we can track the advice problem
 * using a 2D away is by making a 6x6 (not 6x7 since you cannot give
 * yourself advice) while having each of the 1-6 Student IDs on either the
 * first row or column. Then we would populate the row/column with the student
 * ID when advice is given. We would leave the rows not needed empty and the
 * column with the least amount of empty array segments is the wisest Student.
 * Here is an example of what the 2D array would look like:
 * 
 * [1] [2] [4] [ ] [ ] [ ]
 * [2] [4] [6] [ ] [ ] [ ]
 * [3] [1] [2] [4] [5] [6]
 * [4] [ ] [ ] [ ] [ ] [ ]
 * [5] [2] [ ] [ ] [ ] [ ]
 * [6] [2] [ ] [ ] [ ] [ ]
 * 
 * 
 */


package theWiseOne;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Wise {
	
	// public HashMap with an Integer key and values stored inside a List of
	// Integers
	public static Map<Integer, List<Integer>> adviceGiven = new HashMap<>();
	
	/**
	 * This is the main method that helps run the implemented functions.
	 * 
	 * @param args  array of Strings from main method
	 */
	public static void main(String[] args) {
		
		// following the chart of advice givers and advice takers by
		// populating the public HashMap by calling giveAdvice( , );
		giveAdvice(1,2);
		giveAdvice(1,4);
		giveAdvice(2,4);
		giveAdvice(2,6);
		giveAdvice(3,1);
		giveAdvice(3,2);
		giveAdvice(3,4);
		giveAdvice(3,5);
		giveAdvice(3,6);
		giveAdvice(5,2);
		giveAdvice(6,2);
		
		System.out.println("True or False - Student 1 gave advice to Student 2: " + didGiveAdvice(1,2));
		System.out.println("True or False - Student 1 gave advice to Student 3: " + didGiveAdvice(1,3));
		
		System.out.println("The wisest Student is Student: " + getWise());

	}
	
	/**
	 * This method receives two student IDs and tracks them by adding them to
	 * the public HashMap.
	 * 
	 * @param id1  The student who is giving advice.
	 * @param id2  The student who is receiving advice.
	 */
	public static void giveAdvice(int id1, int id2) {
		List<Integer> values = new ArrayList<Integer>();
		
		// if it is a student's first time giving advice they are added to the
		// HashMap as a key.
		if (!adviceGiven.containsKey(id1)) {
			values = new ArrayList<Integer>();
			adviceGiven.put(id1, values);
		}
		// The student receiving the advice is paired with the student giving.
		adviceGiven.get(id1).add(id2);
	}
	
	/**
	 * This method checks if a given student gave advice to another student.
	 * 
	 * @param id1  The student who is giving advice.
	 * @param id2  The student who is receiving advice.
	 * @return  returns true or false whether or not the first student gave the
	 * second student advice.
	 */
	public static boolean didGiveAdvice(int id1, int id2) {
		List<Integer> values = adviceGiven.get(id1);
		if (values != null && values.contains(id2)) {
			return true;
		}
		return false;
	}
	
	/**
	 * This method determines what student gave out the most advice.
	 * 
	 * @return  returns the studentID of the student who gave out the most 
	 * advice.
	 */
	public static int getWise() {
		Map<Integer, List<Integer>> wiseTracker = new HashMap<>();
		List<Integer> count = new ArrayList<Integer>();
		int temp = 0;
		int id1 = 1;
		int id2 = 1;	
		
		// while loop that counts each time each student gave advice.
		while (temp < 36) {
			// creates a new List if the student had not been checked yet
			if (!wiseTracker.containsKey(id1)) {
				count = new ArrayList<Integer>();
				wiseTracker.put(id1, count);
			}
			// Makes sure the student is not giving advice to themselves
			if (id1 != id2) {
				if (didGiveAdvice(id1, id2)) {
				    wiseTracker.get(id1).add(id2);
				}
				id2++;
				// Makes sure the studentID does not go over the amount present
			    if (id2 > 6) {
				    id2 = 1;
				    id1++;
			    } 
			} else {
				id2++;
			}
			temp++;
		}	
		// System.out.println(wiseTracker.get(3).size());
		
		int largest = 0;
		int studentNumber = 1;
		int theWisest = 1;

		// for-each loop that determines which student had the most true 
		// returns from the above while loop.
		for (List<Integer> i : wiseTracker.values()) {
			if (largest < i.size()) {
				largest = i.size();
				theWisest = studentNumber;
			}
			studentNumber++;
		}
		
		return theWisest;
	}
	
}
