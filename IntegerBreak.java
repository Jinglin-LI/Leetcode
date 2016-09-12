/*
Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. 
Return the maximum product you can get.
For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).
Note: You may assume that n is not less than 2 and not larger than 58.
Hint:
There is a simple O(n) solution to this problem.
You may check the breaking results of n ranging from 7 to 10 to discover the regularities.
*/
// 数学问题，找规律

public class IntegerBreak {
	public static void main(String[] args) {
		System.out.println(new IntegerBreak().integerBreak(7));
	}
	public int integerBreak(int n) {
		if (n == 2)
			return 1;
		if (n == 3)
			return 2;
		if (n % 3 == 0)
			return (int)Math.pow(3, n / 3);
		if (n % 3 == 1)
			return 2 * 2 * (int)Math.pow(3, (n - 4) / 3);
		else 
			return 2 * (int)Math.pow(3, n / 3);
	}
	public int intergerBreak2(int n) {
		int[] dp = new int[n + 1];
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j < i; j++) {
				dp[i] = Math.max(dp[i], Math.max(j, dp[j]) * Math.max(i - j, dp[i - j]));
			}
		}
		return dp[n];
	}
}
