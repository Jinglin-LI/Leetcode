/*
Missing Ranges Total Accepted: 510 Total Submissions: 2300
Given a sorted integer array where the range of elements are [lower, upper] inclusive, return its missing ranges.
For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].
*/
// lower跟a中元素相比。如果a中有lower，lower也要加加。如果只有一个元素lower在a中空缺，不加“->”. 最后处理upper是否大于a中最后的元素。

import java.util.*;

public class Solution {
	public List<String> findMassingRanges(int[] a, int lower, int upper) {
		List<String> res = new ArrayList<>();
		if (a == null)
			return res;
		for (int i = 0; i < a.length; i++) {
			while (i < a.length && a[i] == lower) {
				lower++;
				i++;
			}
			if (i >= a.length)
				break;
			if (a[i] == lower + 1) {
				res.add(String.valueOf(lower));     // the only gap in the a[].
			}
			else {
				res.add(lower + "->" + (a[i] - 1));
			}
			lower = a[i] + 1;	
		}
		
		if (lower == upper) {
			res.add(String.valueOf(lower));      // because lower points to the last element in a[]. In this case, a[a.length - 1] >= upper
		}
		else if (lower < upper) {              // a[a.length - 1] < upper
			res.add(lower + "->" + upper);
		}
		return res;
	}
}
