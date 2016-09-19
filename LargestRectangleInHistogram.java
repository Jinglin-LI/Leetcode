/*
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, 
find the area of largest rectangle in the histogram.

Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
The largest rectangle is shown in the shaded area, which has area = 10 unit.
For example,
Given heights = [2,1,5,6,2,3],
return 10.
*/
// 图与解释参考 http://www.cnblogs.com/lichen782/p/leetcode_Largest_Rectangle_in_Histogram.html
// stack中存储升序序列的index. 当指针i指向的数小于peek()时，逐步取大，计算前面高于h[i]的stack中的面积。
// 用dummy = 0为histogram最后最小的一个假象值。

import java.util.*;
public class LargestRectangleInHistogram {
	public static void main(String[] args) {
		int[] heights = {2,1,5,6,2,3};
		System.out.println(new LargestRectangleInHistogram().largestRectangleArea(heights));
	}
	public int largestRectangleArea(int[] heights) {
		Stack<Integer> stack = new Stack<>();
		int res = 0;
		int[] h = Arrays.copyOf(heights, heights.length + 1);		// 前面copy进h[], 后面加一个0；
		int i = 0;
		while (i < h.length) {
			if (stack.isEmpty() || h[stack.peek()] <= h[i]) {
				stack.push(i);
				i++;
			}
			else {
				int temp = stack.pop();
				res = Math.max(res, ((stack.isEmpty()? i : i - stack.peek() - 1) * h[temp]));
			}
		}
		return res;
	}
}
