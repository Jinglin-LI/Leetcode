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
// 两个字符串各两个指针，如果p中'*'存在，flag为真，记录当前两个指针的位置为preS与preP. indexS继续移动（都与'*'相配）。
// 当之后遇到不相同时，preS++，indexS回溯成preS， preP不变， indexP回溯成preP. 例子：abcdade, ab*de.

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
}
