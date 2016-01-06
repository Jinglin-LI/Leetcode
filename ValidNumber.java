/*
Validate if a given string is numeric.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true

Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.
*/

// This version takes exponent into account. 

public class Solution {
    public boolean isNumber(String s) {
        int i = 0;
        boolean isNumber = false;
        while (i < s.length() && Character.isWhitespace(s.charAt(i)))
            i++;
        if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-'))
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
        if (isNumber && i < s.length() && s.charAt(i) == 'e') {
            i++;
            isNumber = false;
            if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-'))
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
