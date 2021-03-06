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
        else if (n == 2) {
            return "11";
        }
        else {
            return helper(countAndSay(n - 1));
        }
    }
    public String helper(String string) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < string.length()) {
            int count = 1;
            while (i + 1 < string.length() && string.charAt(i) == string.charAt(i + 1)) {
                i++;
                count++;
            }
            sb.append(count); // 注意这点。sb.append(int). 如果是count + '0' 则为i.e. 10, 20, or 50. 所以用string + ""代替StringBuilder更好
            sb.append(string.charAt(i));
            i++;
        }
        return sb.toString();
    }
    
    /*******************************一样的，上面的更简洁***********************************************************/
    
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
