package practiceProblems;

import java.math.BigDecimal;
import java.util.Arrays;

public class Exercise6SortedMin {

	public static void main(String[] args) {
		Exercise6SortedMin test = new Exercise6SortedMin();
		/*BigDecimal[] arr = { BigDecimal.valueOf(2), BigDecimal.valueOf(3), BigDecimal.valueOf(1), BigDecimal.valueOf(7),
				BigDecimal.valueOf(9) }; */
		int[] arr = {5, 7, 9, 65, 765, 34567, -1234567, -4567, 0,1,2, 3, 4,5,6,7,8,9};
		Number result = test.findMinimum(arr); 
		System.out.println("Minimum is: " + result);
	}

	public Number findMinimum(int[] arr) {
		int left = 0;
        int right = arr.length - 1;
        int minimum = Integer.MAX_VALUE;
        
        while (left < right) {
            int mid = (left + right) / 2;
            
            // Checks if element is the minimum
            if (arr[mid] < minimum) {
                minimum = arr[mid];
            }
            // If target greater, ignore left half
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            
            // If target is smaller, ignore right half
            } else {
                right = mid;
            }
        }
        return minimum;
    }
	

}
