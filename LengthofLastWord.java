/*
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
If the last word does not exist, return 0.
Note: A word is defined as a character sequence consists of non-space characters only.
*/

public class Solution {
    public int lengthOfLastWord(String s) {
        int count = 0;
        int i = s.length() - 1;
        
        while (i >= 0 && s.charAt(i) == ' ')
            i--;
        while (i >= 0) {
            if (s.charAt(i) != ' ') {
                count++;
                i--;
            }
            else
                return count;
        }
        if (i < 0)
            return count;
        return 0;
    }
}
