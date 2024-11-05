package numberGames;

import java.util.ArrayList;
import java.util.List;

public class Rooms {
	
	/**
	 * This method finds the free dorm room from the given List of Integers
	 * 
	 * @param dormRooms list of Integers of occupied dorms
	 * @return  returns the empty dorm room 
	 */
	public static int getFreeRoom (List<Integer> dormRooms) {
		int previousRoom = -1;
		
		// for-each loop that traverses the entire list to find the empty room
		for (int i: dormRooms) {
			if (previousRoom == -1) {
				previousRoom = i;
			} else if (i > previousRoom + 1){
				return i - 1;
			} else {
				previousRoom = i;
			}
		}
		
		return -1;
	}
	
	/**
	 * This is the main method that helps run the implemented functions.
	 * 
	 * @param args  array of Strings from main method
	 */
	public static void main(String[] args) {
		List<Integer> dormRooms = new ArrayList<>();
		
		// populating the ArrayList with the occupied dorm rooms
		dormRooms.add(2);
		dormRooms.add(3);
		dormRooms.add(5);
		dormRooms.add(6);
		
		System.out.println("The free room is Room " + getFreeRoom(dormRooms));
		
	}
	
}
