/**
Given two non-negative numbers num1 and num2 represented as string, return the sum of num1 and num2.
Note:
The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
*/

public class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        if (num1 == "0" || num2 == "0")
            return num1 == "0"? num2 : num1;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        while (i >= 0 && j >= 0) {
            int digit = carry + num1.charAt(i) - '0' + num2.charAt(j) - '0';
            sb.insert(0, digit % 10);
            carry = digit / 10;
            i--;
            j--;
        }
        while (i >= 0) {
            int digit = carry + num1.charAt(i) - '0';
            sb.insert(0, digit % 10);
            carry = digit / 10;
            i--;
        }
        while (j >= 0) {
            int digit = carry + num2.charAt(j) - '0';
            sb.insert(0, digit % 10);
            carry = digit / 10;
            j--;
        }
        if (carry != 0)
            sb.insert(0, carry);
        return sb.toString();
    }
}
