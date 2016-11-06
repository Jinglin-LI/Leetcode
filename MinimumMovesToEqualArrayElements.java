/*
Given a non-empty integer array of size n, 
find the minimum number of moves required to make all array elements equal, where a move is incrementing n - 1 elements by 1.

Example:
Input:
[1,2,3]
Output:
3
Explanation:
Only three moves are needed (remember each move increments two elements):
[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
*/
// 这方法挺巧妙的。自己想的LTE. 比如{1, 2147483647}. 

public class Solution {
    public int minMoves(int[] nums) {
		int res = 0;
		Arrays.sort(nums);
		int i = nums.length - 1;
		while (i > 0) {
			
			int gap = nums[i] - nums[0];
			if (gap == 0)
				break;
			res += gap;
			i--;
		}
		return res;
	}
}
