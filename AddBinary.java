/*
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
*/

public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0, i = 0, j = 0;
        if (a == null || b == null)
            return a == null? b : a;
        for (i = a.length() - 1, j = b.length() - 1; i >= 0 && j >= 0; i--, j--) {
            int digit = (int)(a.charAt(i) - '0' + b.charAt(j) - '0') + carry;
            carry = digit / 2;
            digit = digit % 2;
            sb.insert(0, digit);
        }
        while (i >= 0) {
            int digit = (int) (a.charAt(i) - '0') + carry;
            carry = digit / 2;
            digit = digit % 2;
            sb.insert(0, digit);
            i--;
        }
        while (j >= 0) {
            int digit = (int) (b.charAt(j) - '0') + carry;
            carry = digit / 2;
            digit = digit % 2;
            sb.insert(0, digit);
            j--;
        }
        if (carry > 0)
            sb.insert(0, 1);
		return sb.toString();
    }
}
