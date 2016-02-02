/*
Given a roman numeral, convert it to an integer.
Input is guaranteed to be within the range from 1 to 3999.
*/

public class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        hm.put('M', 1000);
        hm.put('D', 500);
        hm.put('C', 100);
        hm.put('L', 50);
        hm.put('X', 10);
        hm.put('V', 5);
        hm.put('I', 1);
        
        /*
        int pre = 0;
        int res = 0;
        for (char c : s.toCharArray()) {                       // Can only iterate over an array
            if (hm.get(c) > pre)                               // If the current integer is greater than the previous one, previous one is the offset number
                res = res + (hm.get(c) - 2 * pre);             // MXC = 1010 + (100 - 2 * 10) = 1090. Offset the previous added number
            else
                res = res + hm.get(c);
            pre = hm.get(c);
        }
        */
        
        int res = hm.get(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (hm.get(s.charAt(i)) > hm.get(s.charAt(i - 1)))
                res = res + (hm.get(s.charAt(i)) - 2 * hm.get(s.charAt(i - 1)));
            else
                res = res + hm.get(s.charAt(i));
        }
        return res;
    }
}
