/*
Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.
*/
// DP. s1的前i个数和s2的前j个数组成二维数组dp[i][j]. 初始化时，要初始dp[i][0]和dp[0][j]. 
// 如何判断true呢？1) 新添的字符，要等于s3中（i + j - 1）的字符； 2) 添字符之前的dp[i - 1][j] 或 dp[i][j - 1]也要为true. 
// 比如s1 = ab, s2 = c, s3 = bbc前两位是flase, 第三位是即使是true也不行; s1 = ab, s2 = c, s3=abc前两位是true。

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len1 + len2 != len3)
            return false;
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;
        for (int i = 1; i <= len1 && s1.charAt(i - 1) == s3.charAt(i - 1); i++)     // 此限制条件值得注意。要连续相等。
            dp[i][0] = true;
        for (int j = 1; j <= len2 && s2.charAt(j - 1) == s3.charAt(j - 1); j++)
            dp[0][j] = true;
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (s3.charAt(i + j - 1) == s1.charAt(i - 1) && dp[i - 1][j])       // 此限制条件值得注意。要确定dp[i][j]真假，要判断左边和上边才好。。
                    dp[i][j] = true;
                if (s3.charAt(i + j - 1) == s2.charAt(j - 1) && dp[i][j - 1])       // 此限制条件值得注意。
                    dp[i][j] = true;
            }
        }
        return dp[len1][len2];
    }
}
