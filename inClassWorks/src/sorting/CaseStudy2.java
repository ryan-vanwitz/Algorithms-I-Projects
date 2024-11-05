package sorting;

import java.util.List;
import java.math.BigDecimal;

public class CaseStudy2<E extends Number> {
	// FINDING END NUMBER BY MOVING FROM BOTH SIDES OF LIST
	public boolean matchingTwo(List<E> list, Number num) {
		int index1 = 0;
		int index2 = 0;
		for (Number elem1 : list) {
			index2 = 0;
			for (Number elem2 : list) {
				if (index1 == index2) continue;
				Number c = new BigDecimal(elem1.toString()).add(new BigDecimal(elem2.toString()));
				if (c.equals(new BigDecimal(num.toString()))) {
					return true;
				}
				index2++;
			}
			index1++;
		}
		return false;
	}
}
