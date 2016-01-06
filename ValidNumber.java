/*
Validate if a given string is numeric.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false

Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.
*/

// This version didn't take exponent into account. Only the traditional number was taken into consideration. ig, neither "1." nor ".1" is true.

public class Solution {
    public boolean isNumber(String s) {
        int flag = 0;                                           // flag whether there exists decimal point already
        int i = 0;
        
        while (i < s.length() && s.charAt(i) == ' ')            // ignore blank
        i++;
        
        if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-'))           // ignore '+''-' signal, which is in the beginning
            i++;
            
        if (i < s.length() && s.charAt(i) == '0') {
            if (s.length() == 1)
                return true;                                    // 0 is true
            else if (i + 1 < s.length() && s.charAt(i + 1) == '.') {
                while (i + 2 < s.length() && Character.isDigit(s.charAt(i + 2)))
                    i++;
                    if (i + 2 == s.length())
                        return true;
            }
        }
        
        else if (i < s.length() && Character.isDigit(s.charAt(i))) {
            while (i < s.length() && Character.isDigit(s.charAt(i)))
                    i++;
                    if (i == s.length())
                        return true;
                    else if (i < s.length() && s.charAt(i) == '.' && flag == 0) {
                        flag = 1; 
                        i++;
                        while (i < s.length() && Character.isDigit(s.charAt(i)))
                             i++;
                             if (i == s.length())
                                return true;
                             else if (i < s.length() && s.charAt(i) == ' ')
                                while (i < s.length() && Character.isWhitespace(s.charAt(i)))
                                    i++;
                                    if (i == s.length())
                                        return true;
                    }
                    else if (i < s.length() && s.charAt(i) == ' ') {
                        while (i < s.length() && Character.isWhitespace(s.charAt(i)))
                                    i++;
                                    if (i == s.length())
                                        return true;
                    }
        }
        return false;
    }
}
