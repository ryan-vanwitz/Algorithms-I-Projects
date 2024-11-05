package practiceProblems;

import java.util.Arrays;

public class Exercise7CountingSort {

	public static void main(String[] args) {
		
		/*int[] arr = {0,3,-5,3,0,0,-2,0,4,2,3,6};
		int[] arr2 = {4,5,8,2};
		int[] test = nonComparisonSort(arr2);
		
		for(int i = 0; i < test.length; i++) {
			System.out.print(test[i] + ",");
		}*/
		
	}
	
	public void nonComparisonSort(int[] arr) {
		int min = Arrays.stream(arr).min().getAsInt();
		int max = Arrays.stream(arr).max().getAsInt();
		
		// Initialize a histogram array to count occurrences of each element
	    // Adjust the histogram range if the minimum value is negative
		if (min < 0) {
			int[] histogram = new int[max - min + 1];
			Arrays.fill(histogram, 0);
			
	        // Count occurrences of each element and adjust index by Math.abs(min)
			for (int i = 0; i < arr.length; i++) {
				histogram[arr[i] + Math.abs(min)]++;
			}
			int index = 0;	
			
			// Reconstruct the sorted array from the histogram
	        // Adjust element values back to their original scale
			for (int bin = 0; bin < histogram.length ; bin++) {
				while (histogram[bin] > 0) {
					arr[index] = bin + min;
					histogram[bin]--;
					index++;
				}
			}
		} else {
			int[] histogram = new int[max + Math.abs(min) + 1];
			Arrays.fill(histogram, 0);
			
	        // Count occurrences of each element and adjust index by Math.abs(min)
			for (int i = 0; i < arr.length; i++) {
				histogram[arr[i] + Math.abs(min)]++;
			}
			int index = 0;
			
			// Reconstruct the sorted array from the histogram
	        // Adjust element values back to their original scale
			for (int bin = 0; bin < histogram.length ; bin++) {
				while (histogram[bin] > 0) {
					arr[index] = bin - Math.abs(min);
					histogram[bin]--;
					index++;
				}
			}
		}
	}
		
}
