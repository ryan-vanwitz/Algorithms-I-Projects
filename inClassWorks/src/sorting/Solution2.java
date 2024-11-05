package sorting;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution2<E extends Comparable<? super E>> {
	
	public List<E> shared2(List<E> L1, List<E> L2) {
		Collections.sort(L1);
		Collections.sort(L2);
		List<E> list = new LinkedList<>();
		int index1 = 0;
		int index2 = 0;
		while ((index1 < L1.size()) && (index2 < L2.size())) {
			if (L1.get(index1) == L2.get(index2)) {
				list.add(L1.get(index1));
				index1++;
				index2++;
			} else if (L1.get(index1).compareTo(L2.get(index2)) < 0) {
				index1++;
			} else {
				index2++;
			}
		}
		return list;
    }
}
