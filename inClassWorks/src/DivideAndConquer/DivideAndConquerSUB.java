package DivideAndConquer;

import java.util.LinkedList;

import org.apache.commons.lang3.StringUtils;

public class DivideAndConquerSUB {
	public static void main(String[] args) {
		String arr[] = {"Dystopia","Dystrophy","Dyslipidemia",
				"Dyslexia","Dyspnea", "Dysentery"}; 
		DivideAndConquerSUB test = new DivideAndConquerSUB();
		String answer = test.divide(arr, 0, arr.length-1);
		System.out.println("The answer is: "+answer);
	}
	
	public String divide(String[] array, int start, int end) {
		display(array, start, end);
		if(start==end) { //if we have only one element, we return it
			return array[start];
		}//otherwise, general case... We compute both halves and we apply conquer
		return conquer( divide(array,start,(start+end)/2),
						divide(array,(start+end)/2+1,end));
	}
	
	public String conquer(String S1, String S2) {
		System.out.println(S1 + " & " + S2 + "-> " + StringUtils.getCommonPrefix(S1,S2));
		return StringUtils.getCommonPrefix(S1,S2);
	}
	
	public void display(String[] array, int start, int end) {
		System.out.print("Operating on [");
		for(int i=start; i<end; i++)
			System.out.print(array[i]+" ");
		System.out.println("]");
	}

}
