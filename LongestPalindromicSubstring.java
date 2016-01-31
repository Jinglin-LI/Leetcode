/*
Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
*/

public class Solution {
    public String longestPalindrome(String s) {
        int len = 0, start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = lengthOfExpandFromCenter(s, i, i);
            int len2 = lengthOfExpandFromCenter(s, i, i + 1);                           // center is between two characters
            len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }
    private int lengthOfExpandFromCenter(String s, int left, int right) {               // the lenght of palindrom expand from certain center
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;                                                                    // expend 
        }
        return right - left - 1;                                                        // (right - 1) - (left + 1) + 1
    }
}
