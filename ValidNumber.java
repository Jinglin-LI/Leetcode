/*
Validate if a given string is numeric.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false

Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.
*/

// This version didn't take exponent into account.

public class Solution {
    public boolean isNumber(String s) {
        int i = 0;
        boolean isNumber = false;
        while (i < s.length() && Character.isWhitespace(s.charAt(i)))
            i++;
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            i++;
            isNumber = true;
        }
        if (i < s.length() && s.charAt(i) == '.') {
            i++;
            while (i < s.length() && Character.isDigit(s.charAt(i))) {
            i++;
            isNumber = true;
            }
        }
        while (i < s.length() && s.charAt(i) == ' ') 
            i++;
        if (isNumber == true && i == s.length())
            return true;
        else
            return false;
    }
}
