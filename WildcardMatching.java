/*
Implement wildcard pattern matching with support for '?' and '*'.
'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)
Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false
*/
// 贪心算法。两个字符串各两个指针，如果p中'*'存在，flag为真，记录当前两个指针的位置为preS与preP. indexS继续移动（都与'*'相配）。
// 当之后遇到不相同时，preS++，indexS回溯成preS， preP不变， indexP回溯成preP. 例子：abcdade, ab*de.
/*
update: 增加了DP的解法(LC会超时)：Matrix了后，注意dp[][]的用法。dp[i][j] 与 s.charAt(i - 1)相比
1. 初始化：dp[0][0] = true, 因为空与空相配为true. ‘*’与空相配也为true。所以dp[0][j] = dp[0][j - 1] && p.charAt(i - 1) == '*';
2. 遍历：‘*’可以与0,1,2...个元素配对。即， dp[i][j] = dp[i - 1][j - 1], or = dp[i - 1][j] or = dp[i][j - 1].  
*/

public class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null)
            return false;
        int indexS = 0, indexP = 0;
        int preS = 0, preP = 0;
        boolean flag = false;
        
        while (indexS < s.length()) {
            if (indexP < p.length() && isMatch(s.charAt(indexS), p.charAt(indexP))) {
                indexS++;
                indexP++;
            }
            else if (indexP < p.length() && p.charAt(indexP) == '*') {
                while (indexP < p.length() && p.charAt(indexP) == '*')
                    indexP++;
                if (indexP == p.length())
                    return true;
                flag = true;
                preS = indexS;
                preP = indexP;
            }
            else if (flag) {
                preS++;
                indexS = preS;
                indexP = preP;
            }
            else
                return false;
        }
        while (indexP < p.length() && p.charAt(indexP) == '*')    // 忽略p中末尾的*. 因为之前判断indexS < s.length(), 最后判断都到末尾
            indexP++;
        
        if (indexS == s.length() && indexP == p.length())
            return true;
        return false;
    }
    private boolean isMatch(char a, char b) {
        return (b == '?' || a == b);
    }
    
    // add the DP solution
    public boolean isMatch2(String s, String p) {
		int m = s.length();
		int n = p.length();
		boolean[][] dp = new boolean[m + 1][n + 1];
		dp[0][0] = true;                                                        // 注意dp[0][0]的用法。dp[i][j] 与 s.charAt(i - 1)相比
		for (int i = 1; i <= n; i++) {
			dp[0][i] = dp[0][i - 1] && p.charAt(i - 1) == '*';                  // 初始化
		}
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (isMatch(s.charAt(i - 1), p.charAt(j - 1)))
					dp[i][j] = dp[i - 1][j - 1];
				else if (p.charAt(j - 1) == '*')
					dp[i][j] = dp[i - 1][j - 1] || dp[i][j - 1] || dp[i - 1][j];
			}
		}
		return dp[m][n];
	}
}
