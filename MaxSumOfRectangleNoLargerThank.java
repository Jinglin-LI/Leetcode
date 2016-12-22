/*
Given a non-empty 2D matrix matrix and an integer k, 
find the max sum of a rectangle in the matrix such that its sum is no larger than k.

Example:
Given matrix = [
  [1,  0, 1],
  [0, -2, 3]
]
k = 2
The answer is 2. Because the sum of rectangle [[0, 1], [-2, 3]] is 2 and 2 is the max number no larger than k (k = 2).

Note:
The rectangle inside the matrix must have an area > 0.
What if the number of rows is much larger than the number of columns?
*/

// http://www.jianshu.com/p/e9ff87d6bf8e
// https://www.youtube.com/watch?v=yCQN096CwWM

import java.util.*;
public class MaxSumofRectangleNoLargerThanK {
	public int maxSumSubMatrix(int[][] matrix, int k) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return 0;
		int res = Integer.MIN_VALUE;
		
		int m = matrix.length;
		int n = matrix[0].length;
		
		for (int i = 0; i < n; i++) {
			// 以列为单位，每一列建一个m大小的临时数组
			int[] sum = new int[m];
			
			for (int j = i; j < n; j++) {
				// 每一行的数加到临时数组里面
				for (int p = 0; p < m; p++) {
					sum[p] += matrix[p][j];
				}
				// cum为一维数组临时的最大值。
				int cum = 0;
				// 利用treeset有ceiling的性质，可返回小于K的最大值
				TreeSet<Integer> ts = new TreeSet<>();
				// 后面ceiling值有可能小于0， 所以会返回0，可更改Min_Value变为0.
				ts.add(0);
				for (int p = 0; p < m; p++) {
					cum += sum[p];
					// 利用ceiling， 返回的是TreeSet中存在的大于cum-k的最小值。如果不存在就返回null
					Integer value = ts.ceiling(cum - k);
					if (value != null) {
						// cum-value实际上就是不小于k的最大值。
						if (res < cum - value) {
							res = cum - value;
						}
					}
					ts.add(cum);
				}
			}
		}
		return res;
	}
}
