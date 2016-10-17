/**
Given a set of distinct positive integers, 
find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies: Si % Sj = 0 or Sj % Si = 0.
If there are multiple solutions, return any subset is fine.
Example 1:
nums: [1,2,3]
Result: [1,2] (of course, [1,3] will also be ok)
Example 2:
nums: [1,2,4,8]
Result: [1,2,4,8]
*/
/*
用DP做，记载形成的第几个整除数。parent[]记载某个可整除的数是从哪里来的。用max记载最长的整除子序列的长度，maxIndex记载此数的index. 
例子：   1 3 6
dp:     1 2 3
parent: -1 0 1
用i和j（j<i）是因为，比如1,2,8,9,72. 算72时，从9往回算。dp[4] = dp[3] + 1 = 3, 还要算dp[4] = dp[2] + 1 = 4. 
*/

public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
		List<Integer> res = new ArrayList<>();
		if (nums.length == 0)
			return res;
		int n = nums.length;
		Arrays.sort(nums);
    
		int[] dp = new int[n];
		Arrays.fill(dp, 1);                   // dp记载形成的最长的subset的长度
    
		int[] parent = new int[n];
		Arrays.fill(parent, -1);              // parent记载每个数形成最长subset上一辈父亲的index, 而不是祖先. parent为-1代表自己形成最长的subset.
    
		int max = 1;
		int maxIndex = 0;
    
		for (int i = 1; i < n; i++) {
			for (int j = i - 1; j >= 0; j--) {                        // 遍历i和j, 寻找整除数。
				if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
					parent[i] = j;                                        // 找到nums[i]的上一辈父亲的index
					if (dp[i] > max) {                                    // max 记载总体形成的最长的subset的长度。
						max = dp[i];
						maxIndex = i;
					}
				}
			}
		}
		for (int i = maxIndex; i != -1; i = parent[i])            // 很有技巧性的for loop. Note that. 
			res.add(nums[i]);
		return res;
	}
}
