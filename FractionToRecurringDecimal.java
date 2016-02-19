/*
Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
If the fractional part is repeating, enclose the repeating part in parentheses.
For example,
Given numerator = 1, denominator = 2, return "0.5".
Given numerator = 2, denominator = 1, return "2".
Given numerator = 2, denominator = 3, return "0.(6)".
*/

public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0)
            return "0";
        if (denominator == 0)
            return null;
            
        StringBuilder res = new StringBuilder();
        if (numerator > 0 && denominator < 0 || (numerator < 0 && denominator > 0))
            res.append("-");
        Long n = new Long(numerator);                           // convert to long to avoid overflow
        Long d = new Long(denominator);
        n = Math.abs(n);
        d = Math.abs(d);
        res.append(n / d);
        if (n % d == 0)
            return res.toString();
        res.append(".");
        HashMap<Long, Integer> hm = new HashMap<>();            // use integer to store the length of res, in order to insert "(".
        Long r = n % d;
        while (r > 0) {
            if (hm.containsKey(r)) {
                res.insert(hm.get(r), "(");
                res.append(")");
                break;
            }
            hm.put(r, res.length());
            r = r * 10;
            res.append(r / d);
            r = r % d;
        }
        return res.toString();
    }
}
