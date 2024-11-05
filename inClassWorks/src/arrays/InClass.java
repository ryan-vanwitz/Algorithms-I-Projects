package arrays;

import java.util.Arrays;

public class InClass<E> {

	public static void main(String[] args) {
		InClass<Integer> obj = new InClass<>();
		Integer[] arr = {1,2,2,3,2,3,2,5,3,7,7,2,2,2};
		
		Integer[] newArr = obj.shift(arr, 2);
		Integer[] newArr2 = obj.shift2(arr, 2);
		
		for (Integer elem : newArr) {
			System.out.print(elem + ", ");
		}
		
		System.out.println();
		
		for (Integer elem : newArr2) {
			System.out.print(elem + ", ");
		}
	}
	
	public E[] shift(E[] arr, E target) {
		int removedCount = 0;
		for (int i = 0; i < arr.length - removedCount; i++) {
			if (arr[i].equals(target)) {
				for (int j = i+1; j < arr.length - removedCount; j++) {
					arr[j - 1] = arr[j];
				}
				removedCount++;
			    i--;
			}
		}	
		return arr;
	}
	
	public E[] shift2(E[] arr, E target) {
		int removedCount = 0;
		for (int i = 0; i < arr.length - removedCount; i++) {
			if (arr[i].equals(target)) {
				for (int j = i+1; j < arr.length - removedCount; j++) {
					arr[j - 1] = arr[j];
				}
				removedCount++;
			    i--;
			}
		}	
		return Arrays.copyOf(arr, arr.length - removedCount);
	}
	
	public E[] shift3(E[] arr, E target) {
		int removedCount = 0;
		for (int i = 0; i < arr.length - removedCount;) {
			if (arr[i].equals(target)) {
				for (int j = i+1; j < arr.length - removedCount; j++) {
					arr[j - 1] = arr[j];
				}
				removedCount++;
			} else {
				i++;
			}
		}	
		return Arrays.copyOf(arr, arr.length - removedCount);
	}

}
