/*
Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. 
Find and return the shortest palindrome you can find by performing this transformation.
For example:
Given "aacecaaa", return "aaacecaaa".
Given "abcd", return "dcbabcd".
*/

public class Solution {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() <= 1) return s;
        // find the longest palin beginning at the left
        int l = s.length();
        int maxL = 0;
        for(int i = 0; i <= l /2 ; i++) {
            maxL = Math.max(maxL, Math.max(expand(s, i, false),expand(s, i, true)));
        }
        // use maxL as point
        String suffix = s.substring(maxL+1);
        return new StringBuffer(suffix).reverse().toString() + s.substring(0, maxL+1) + suffix;
    }
    private int expand(String s, int i, boolean isCenter) {
        int j = isCenter? i: i+1;
        while(i >=0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }
        // only return if goes to the start
        if (i < 0 ) return --j;
        return -1;
    }
}
