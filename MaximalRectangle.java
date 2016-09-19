/*
Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
For example, given the following matrix:
1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 6.
*/
// Largest Rectangle in Histogram 的变体。思路见 http://www.cnblogs.com/lichen782/p/leetcode_maximal_rectangle.html
// 矩阵每一行当做每一个histogram，同一列都为1的话，下面同列的histogram加一。

import java.util.*;
public class MaximalRectangle {
	public int maximalRectangle(char[][] matrix) {
		int res = 0;
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] height = new int[m][n + 1];                       // add dummy 0
		for (int i = 0; i < m; i++) {                             // construct histogram for each i. 
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '0')
					height[i][j] = 0;
				else {
					if (i == 0)
						height[i][j] = 1;
					else
						height[i][j] = height[i - 1][j] + 1;
				}	 
			}
		}
		for (int i = 0; i < m; i++) {                             // search每一行里最大的area
			int area = maxAreaEachRow(height[i]);
			res = Math.max(res, area);
		}
		return res;
	}
	private int maxAreaEachRow(int[] heights) {
		Stack<Integer> stack = new Stack<>();
		int res = 0;
		int i = 0;
		while (i < heights.length) {
			if (stack.isEmpty() || heights[stack.peek()] <= heights[i])
				stack.push(i++);
			else {
				int temp = stack.pop();
				res = Math.max(res, heights[temp] * (stack.isEmpty()? i : i - stack.peek() - 1));
			}
		}
		return res;
	}
}
