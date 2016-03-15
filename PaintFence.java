/*
There is a fence with n posts, each post can be painted with one of the k colors.
You have to paint all the posts such that no more than two adjacent fence posts have the same color.
Return the total number of ways you can paint the fence.
Note: n and k are non-negative integers.
*/
// 题目要求：最多连续两个篱笆可以是一个颜色。第一个篱笆和第二个篱笆自己算。
// 从第三个篱笆开始，颜色不能跟第二个一样，或者不能跟第一个一样，于是有 (k - 1) * dp[1] + (k - 1) * dp[2]中方法。dp[1]和dp[2]向后移一位。

public class Solution {
	public int numWays(int n, int k) {
		int dp[] = {0, k, k * k, 0};
		if (n <= 2)
			return dp[n];
		for (int i = 3; i <= n; i++) {
			dp[3] = (k - 1) * (dp[1] + dp[2]);
			dp[1] = dp[2];
			dp[2] = dp[3];
		}
		return dp[3];
	}
}
