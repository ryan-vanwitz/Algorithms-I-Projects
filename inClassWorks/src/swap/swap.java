package swap;

public class swap {

	public static void main(String[] args) {
		int x = 10;
		int y = -6;
		
		
		// int temp = x;
		int temp = y; // take the sum
		y = x; // saves 
		x = temp;
		
		System.out.println(x + " " + y);
		// Space(variables made): 1
		// Time(operations done): 3
		
		
		x = x + y; // take the sum
		y = x - y; // saves 
		x = x - y;
		
		System.out.println(x + " " + y);
		// Space(variables made): 0 
		// Time(operations done): 6
		
	}

}
