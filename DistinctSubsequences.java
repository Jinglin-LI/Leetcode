/*
Given a string S and a string T, count the number of distinct subsequences of T in S.
A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"
Return 3.
*/
// DP. 记载s的i个字符和t的j个字符相符的子串的数量，可画图。Reference: http://blog.csdn.net/abcbc/article/details/8978146 (其颠倒了i,j)。
/*
The problem itself is very difficult to understand. It can be stated like this:
Give a sequence S and T, how many distinct sub sequences from S equals to T?
How do you define "distinct" subsequence? Clearly, the 'distinct' here mean different operation combination, 
not the final string of subsequence. Otherwise, the result is always 0 or 1. -- from Jason's comment
*/
// 此题的题目要求是，S的subsequence，跟T是一样的。不同的subsequence指的是操作的不同，不是最终得到的string的不同。
/*
公式总结：
S[j-1]!= T[i-1]：DP[i][j] = DP[i][j-1]
S[j-1]==T[i-1]：DP[i][j] = DP[i-1][j-1] + DP[i][j-1]
*/

public class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= s.length(); i++)
            dp[i][0] = 1;
        for (int j = 1; j <= t.length(); j++)
            dp[0][j] = 0;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                dp[i][j] = dp[i - 1][j];
                if (s.charAt(i - 1) == t.charAt(j - 1))
                    dp[i][j] += dp[i - 1][j - 1];
            }
        }
        return dp[s.length()][t.length()];
    }
}
