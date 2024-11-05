package numberGames;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Numbers {

	/**
	 * This is the main method that helps run the implemented functions.
	 * 
	 * @param args  array of Strings from main method
	 */
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		
		// populating the ArrayList with random numbers from the
		// "big big pile of cards".
		list.add(6);
		list.add(7);
		list.add(2147483647);
		list.add(64);
		list.add(2147483646);
		list.add(26);
		list.add(891);
		
		int unsaidNumber = getNumber(list);
		System.out.println("An integer not in the card pile was " + unsaidNumber);
	}
	
	/**
	 * Method that gets a number that does not appear in the "big big pile of
	 * cards"
	 * 
	 * @param list List of Integers from the "big big pile of cards"
	 * @return returns an integer not in the pile of cards
	 */
	public static int getNumber(List<Integer> list) {
		Set<Integer> givenNumbers = new HashSet<>();
		int compareNum = Integer.MAX_VALUE;
		boolean key = true;
		
		// adding all given numbers to HashSet
		for (int i : list) {
			givenNumbers.add(i);
		}
		
		// loop to find any integer not in the "big big pile of cards".
		while (key) {
			if (!givenNumbers.contains(compareNum)) {
				return compareNum;
			}
			compareNum--;
		}
		
		return 0;
	}

}
