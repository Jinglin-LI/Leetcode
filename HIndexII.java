/*
Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?
Hint:
Expected runtime complexity is in O(log n) and the input is sorted.
*/
// https://discuss.leetcode.com/topic/52656/most-clear-explanation-with-java-solution
// {0, 2, 3, 7}返回2.

public class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
		int low = 0;
		int high = len;
		while (low < high) {
			int mid = (low + high) / 2;
			if (citations[mid] == len - mid)               // len - mid 表示至少有len - mid篇文章IF大，跟某个数citations[mid]相比
				return len - mid;
			else if (citations[mid] < len - mid)
				low = mid + 1;
			else
				high = mid;
		}
		return len - low;                               // 当low取mid + 1时候，注意这个, 比如{0,2,3,7}。而且当{100}时，res = 1
}
