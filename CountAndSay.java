/*
The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.
*/

public class Solution {
    public String countAndSay(int n) {
        if (n == 1)
            return "1";
        
        String string = nextString(countAndSay(n - 1));
        return string;
    }
    private String nextString(String s) {
        String res = "";
        int len = s.length();
        if (len == 1) 
            return "1" + s.charAt(0);
        int i = 0;
        for (i = 0; i < len - 1; i++) {
            int count = 1;
            while (i < len - 1 && s.charAt(i) == s.charAt(i + 1)) {
                i++;
                count++;
            }
            res = res + count + s.charAt(i);
        }
        
        if (i > 0 && i < len && s.charAt(i) != s.charAt(i - 1))
            res = res + "1" + s.charAt(i);
        return res;
    }
}
