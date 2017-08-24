/*
Given a non-empty string check if it can be constructed by taking a substring of it 
and appending multiple copies of the substring together. 
You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.

Example 1:
Input: "abab"
Output: True
Explanation: It's the substring "ab" twice.

Example 2:
Input: "aba"
Output: False

Example 3:
Input: "abcabcabcabc"
Output: True
Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
*/

// 此题难点是不知道重复字符串长度。所以用helper来传入重复字符串长度。

public class Solution {
    
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        int i = len / 2;
        while (i > 0) {
            String str = s.substring(0, i);
            for (int j = i; j < s.length() - i + 1; j = j + i) {
                String str2 = s.substring(j, j + i);
                if (!str.equals(str2)) {
                    break;
                }
                else {
                    if (j + i == s.length()) {
                        return true;
                    }
                }
            }
            i--;
            while (i > 0 && s.length() % i != 0) {
                i--;
            }
        }
        return false;
    }
    
    /*******************************************************************************/
    
    public boolean repeatedSubstringPattern(String str) {
        for (int i = 1; i <= str.length() / 2; i++) {
            if (helper(str, i))
                return true;
        }
        return false;
    }
    public boolean helper(String str, int len) {
        if (str.length() % len != 0)
            return false;
        for (int i = len; i < str.length(); i++) {
            if (str.charAt(i % len) != str.charAt(i))         // 以第0-len的字符做判断
                return false;
        }
        return true;
    }
}
