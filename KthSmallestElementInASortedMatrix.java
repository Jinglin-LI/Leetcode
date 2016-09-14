/*
Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.
Note that it is the kth smallest element in the sorted order, not the kth distinct element.
Example:
matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,
return 13.
Note: 
You may assume k is always valid, 1 ≤ k ≤ n2.
*/

// http://www.guoting.org/leetcode/leetcode-378-kth-smallest-element-in-a-sorted-matrix/
/*
思路一:PriorityQueue
维护一个优先级队列,每次从队列的头部移除最小元素,并且将和当前元素相邻的元素加入到队列中,从队列中移除第k次的元素即为所求。

但是需要注意的一点是,除了最后一行和最后一列之外,每个元素都有两个相邻的元素,如果我们每从队列头部移除一个元素,
都将相邻的两个元素添加到队列中,这样的话势必会引起重复,所以这里有一点需要注意,这个方法对这类的问题都是通用的:

只有在第一行的时候,我们才添加它的右面和下面的元素,其他行只添加它下面的元素。
*/
// 此题解法是https://discuss.leetcode.com/topic/52948/share-my-thoughts-and-clean-java-code/2的变体。即将元素坐标记录下来。class Tuple
// 此题用int[] peak = {matrix[][], x, y} 为集合根据matrix[][]值加入在最小堆。

import java.util.*;
public class KthSmallestElementInASortedMatrix {
	public int kthSmallest(int[][] matrix, int k) {
		if (matrix == null || matrix.length == 0)
			return -1;
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		pq.add(new int[] {matrix[0][0], 0, 0});                       // note: 每次加入到pq中, new 一个！
		int[] peak = new int[3];
		while (k-- > 0) {
			peak = pq.poll();
			if (peak[1] + 1 < matrix.length) {
				pq.add(new int[] {matrix[peak[1] + 1][peak[2]], peak[1] + 1, peak[2]});
			}
			if (peak[1] == 0 && peak[2] + 1 < matrix[0].length) {       // 如果在第一行，即再加入右边元素。防止重复。
				pq.add(new int[] {matrix[peak[1]][peak[2] + 1], peak[1], peak[2] + 1});
			}
		}
		return peak[0];
	}
}
