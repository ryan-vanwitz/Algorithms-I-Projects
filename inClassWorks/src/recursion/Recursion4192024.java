package recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Recursion4192024<E extends Comparable<? super E>> {

	public static void main(String[] args) {
		int result = multiply(6, 9);
		System.out.println(result);

		int result2 = multiply2(7, 9);
		System.out.println(result2);

		int result3 = multiply3(8, 9);
		System.out.println(result3);

		int result4 = interval(1, 4);
		System.out.println(result4);

		int result5 = interval2(1, 4);
		System.out.println(result5);

		// double result6 = integral(1,4);
		// System.out.println(result6);

		int result7 = power(3, 4);
		System.out.println(result7);

		int result8 = power2(3, 4);
		System.out.println(result8);

		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		List<Integer> result9 = reverse(list);
		for (Integer i : result9) {
			System.out.println(i);
		}

		System.out.println();

		int result10 = sum(list);
		System.out.println(result10);

		System.out.println();

		int result11 = max(list);
		System.out.println(result11);

	}

	public static int multiply(int x, int y) {
		if (y == 0) {
			return 0;
		}
		return x + multiply(x, y - 1);
	}

	public static int multiply2(int x, int y) {
		return (y == 0) ? 0 : (x + multiply(x, y - 1));
	}

	// A recursion method that is nice on the memory
	public static int multiply3(int x, int y) {
		return multiply3(x, y, 0);
	}

	public static int multiply3(int x, int y, int result) {
		if (y == 0) {
			return result;
		}
		return multiply3(x, y - 1, result + x);
	}
	// F(5,4) = F(5,4,0) = F(5,3,5) = F(5,2,10) = F(5,1,15) = F(5,0,20)

	// head recursion
	// print numbers throughout interval
	public static int interval(int a, int b) {
		if (a == b) {
			return b;
		}
		return a * interval(a + 1, b);
	}

	// tail recursion
	// print numbers throughout interval
	public static int interval2(int a, int b) {
		return interval2(a, b, 1);
	}

	public static int interval2(int a, int b, int result) {
		if (a > b) {
			return result;
		}
		return interval2(a + 1, b, (result * a));
	}

	// head
	public static double integral(MyFunction F, Double a, Double b, Double dx) {
		if (a.equals(b)) {
			return F.eval(b) * dx;
		}
		return F.eval(b) * dx + integral(F, a + dx, b, dx);
	}

	// tail
	public static double integral2(MyFunction F, Double a, Double b, Double dx) {
		return integral2(F, a, b, dx, 0.0);
	}

	public static double integral2(MyFunction F, Double a, Double b, Double dx, Double result) {
		if (a.compareTo(b) > 0) {
			return result;
		}
		return integral2(F, a + dx, b, dx, result + F.eval(a) * dx);
	}

	private interface MyFunction {
		Double eval(Double x);
	}

	
	/*   Power recursive function one multiplication at a time
	 *   T(n) = 1T(n-1) + Theta(1)  = Theta(n)
	 */
	
	
	
	// head recursion
	// T(n) = 1T(n/2) + Theta(1)  = Theta(log n)
	public static int power(int a, int b) {
		if (b == 0) {
			return 0;
		}
		if (b % 2 == 0) {
			return power(a * a, b / 2);
		}
		return a + power(a * a, b / 2);
	}
	
	
	

	// tail recursion
	public static int power2(int a, int b) {
		return power2(a, b, 1);
	}

	public static int power2(int a, int b, int result) {
		if (b == 0) {
			return result;
		}
		if (b % 2 == 0) {
			return power2(a * a, b / 2, result);
		}
		return power2(a * a, b / 2, result * a);
	}

	// head recursion
	public static List<Integer> reverse(List<Integer> list) {
		if (list.size() == 1) {
			List result = new LinkedList();
			result.add(list.get(0));
			return result;
		}
		List result = reverse(list.subList(1, list.size()));
		result.add(list.get(0));
		return result;
	}

	// tail recursion
	/*
	 * public static List<Integer> reverse(List<Integer> list) { return (list,
	 * List<Integer>) }
	 */

	// Sum(c) = c
	// Sum(c.L) = Sum(L) + c

	public static int sum(List<Integer> list) {
		if (list.size() == 0) {
			return 0;
		}
		int firstElem = list.get(0);
		list.remove(0);
		int sumOfRest = sum(list);
		list.add(0, firstElem);
		return firstElem + sumOfRest;
	}

	// F{3.5.2.7.1.0} = F{5.2.7.1.0} = F{5.7.1.0} = F{7.1.0} = F{7.0} = F{7}
	public static int max(List<Integer> list) {
		if (list.size() == 1) {
			return list.get(0);
		}

		if (list.get(0) > list.get(1)) {
			list.remove(1);
			return max(list);
		}

		list.remove(0);
		return max(list);
	}

}
