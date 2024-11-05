package histogram;

import java.util.Arrays;

public class histogram {

	public static void main(String[] args) {
		
		int[] arr = {0,3,5,3,0,0,2,0,4,2,3,6};
		int[] ryan = nonComparisonSort(arr);
		
		for(int i = 0; i < ryan.length; i++) {
			System.out.print(ryan[i] + ",");
		}
		
	}
	
	public static int[] nonComparisonSort(int[] arr) {
		
		int max = Arrays.stream(arr).max().getAsInt();
		
		int[] histogram = new int[max+1];
		Arrays.fill(histogram, 0);
		for (int i = 0; i < arr.length; i++) {
			histogram[arr[i]]++;
		}
		int index = 0;	
		for (int bin = 0; bin < histogram.length ; bin++) {
			while (histogram[bin] > 0) {
				arr[index] = bin;
				histogram[bin]--;
				index++;
			}
		}
		return arr;
	}
	

}
