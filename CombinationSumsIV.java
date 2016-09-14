/*
Given an integer array with all positive numbers and no duplicates, 
find the number of possible combinations that add up to a positive integer target.
Example:
nums = [1, 2, 3]
target = 4
The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)
Note that different sequences are counted as different combinations.
Therefore the output is 7.
Follow up:
What if negative numbers are allowed in the given array?
How does it change the problem?
What limitation we need to add to the question to allow negative numbers?
*/
// DP. 用DP存储0~target的结果。比如[1,2,3]问target == 3时的结果。3 = 1 + 2 （dp[2]） = 2 + 1 (dp[1]) = 3 + 0 (dp[0])。 所以要把前面的小于3的dp[]的数加起来。
// Tracebacking会LTE。

public class CombinationSumIV {
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		System.out.println(new CombinationSumIV().combinationSum4(nums, 6));
	}
	public int combinationSum4(int[] nums, int target) {
		int[] dp = new int[target + 1];
		dp[0] = 1;
		for (int i = 1; i <= target; i++) {
			for (int num : nums) {
				if (i >= num)
					dp[i] += dp[i - num];
			}
		}
		return dp[target];
	}
}
