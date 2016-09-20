/*
Given a string s, partition s such that every substring of the partition is a palindrome.
Return the minimum cuts needed for a palindrome partitioning of s.
For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
*/
// 找最少的切割数。
/*
两个指针 + DP。 
dp[i]代表string的i到len的字符串的最小切割数。所以从i开始到末尾以j (i < j < n)为划分点的最小划分数为: dp[j+1]+1 和 dp[i]中的最小值。
cut_num[i]的初值设为：s.length() - i; 也就是按照字符串中的每个字母都单独被划分来计算。
判断回文，每一个字符判断太花时间。则用二维数组palindrome[][] 为1代表。判断palindrome[i][j]则palindrome[i + 1][j - 1]一定为1. 
*/

public class PalindromePartitioningII {
	public int minCut(String s) {
		if (s == null || s.length() <= 1)
			return 0;
		int len = s.length();
		int[][] palindrome = new int[len][len];                           // 回文序列的话，值为1. 
		int[] dp = new int[len + 1];
		
		for (int i = len - 1; i >= 0; i--) {
			dp[i] = len - i;                                                // 初始化。最小为1. 
			for (int j = i; j < len; j++) {
				if (s.charAt(i) == s.charAt(j)) {
					if (j - i < 2 || palindrome[i + 1][j - 1] == 1) {           // j与i为相同，或者只有一个字符（j - i == 1）.
						palindrome[i][j] = 1;
						dp[i] = Math.min(dp[i], dp[j + 1] + 1);
					}
				}
			}
		}
		return dp[0] - 1;                                                 // 因为初始化每次都先增加了1. 
	}
}
