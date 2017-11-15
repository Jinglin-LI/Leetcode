/*
There is a garden with N slots. In each slot, there is a flower. The N flowers will bloom one by one in N days. 
In each day, there will be exactly one flower blooming and it will be in the status of blooming since then.

Given an array flowers consists of number from from 1 to N. Each number in the array represents the place where the flower will open 
in that day.

For example, flowers[i] = x means that the unique flower that blooms at day i will be at position x, 
where i and x will be in the range from 1 to N.

Also given an integer k, you need to output in which day there exists two flowers in the status of blooming, 
and also the number of flowers between them is k and these flowers are not blooming.

If there isn't such day, output -1.
*/

import java.util.HashSet;
import java.util.TreeSet;

public class Solution {
	public static void main(String[] args) {
		Solution test = new Solution();
		int[] flowers = {1,3,2};
		System.out.println(test.kEmptySlots(flowers, 1));
	}
	public int kEmptySlots(int[] flowers, int k) {
        int n = flowers.length;
        if (n == 1 && k == 0) return 1;
        TreeSet<Integer> sort = new TreeSet<>();
        for (int i = 0; i < n; ++i) {
            sort.add(flowers[i]);
            Integer min = sort.lower(flowers[i]);
            Integer max = sort.higher(flowers[i]);
            int mi = min == null ? -1111111 : min;
            int ma = max == null ? -1111111 : max;
            if (valid(flowers[i], k, mi, ma)) return i + 1;
        }
        return -1;
    }

    boolean valid(int x, int k, int min, int max) {
        if (max - x == k + 1) return true;
        if (x - min == k + 1) return true;
        return false;
    }
}
