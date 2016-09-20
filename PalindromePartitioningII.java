/*
Given a string s, partition s such that every substring of the partition is a palindrome.
Return the minimum cuts needed for a palindrome partitioning of s.
For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
*/
// 找最少的切割数。
/*
http://www.cnblogs.com/springfor/p/3891896.html
两个指针 + DP。 
首先设置dp变量 dp[len+1]。dp[i]表示从第i位置到第len位置（包含，即[i, len])的切割数（第len位置为空）。
初始时，是len-i。比如给的例子aab，cuts[0]=3，就是最坏情况每一个字符都得切割：a|a|b|' '。cuts[1] = 2, 即从i=1位置开始，a|b|' '。
dp[2] = 1 b|' '。dp[3]=0,即第len位置，为空字符，不需要切割
所以从i开始到末尾以j (i < j < n)为划分点的最小划分数为: dp[j+1]+1 和 dp[i]中的最小值。
判断回文，每一个字符判断太花时间。则用二维数组palindrome[][] 为1代表。判断palindrome[i][j]则palindrome[i + 1][j - 1]一定为1. 
*/

public class PalindromePartitioningII {
	public int minCut(String s) {
		if (s == null || s.length() <= 1)
			return 0;
		int len = s.length();
		boolean[][] palindrome = new boolean[len][len];                           // 回文序列的话，值为true. 
		int[] dp = new int[len + 1];
		for (int i = 0; i < len; i++)
			dp[i] = len - i;					  // 初始化。最小为1. (最后一个可为0)
		
		for (int i = len - 1; i >= 0; i--) {
			for (int j = i; j < len; j++) {
				if (s.charAt(i) == s.charAt(j)) {
					if (j - i < 2 || palindrome[i + 1][j - 1] == true) {     // j与i为相同，或者只有一个字符（j - i == 1）.
						palindrome[i][j] = true;
						dp[i] = Math.min(dp[i], dp[j + 1] + 1);
					}
				}
			}
		}
		return dp[0] - 1;                                                 // 因为初始化每次都先增加了1. 
	}
}
