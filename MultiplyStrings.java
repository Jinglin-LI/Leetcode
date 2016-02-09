/*
Given two numbers represented as strings, return multiplication of the numbers as a string.
Note: The numbers can be arbitrarily large and are non-negative.
*/

public class Solution {
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null)
            return null;
        int[] output = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int carry1 = 0, carry2 = 0;
            for (int j = num2.length() - 1; j >= 0; j--) {
                int value = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + carry1;
                carry1 = value / 10;
                int input = output[i + j + 1] + value % 10 + carry2;
                output[i + j + 1] = input % 10;
                carry2 = input / 10;
            }
            output[i] = carry1 + carry2;
        }
        StringBuilder res = new StringBuilder();
        boolean firstZero = true;
        for (int i = 0; i < output.length; i++) {
            
            if (output[i] == 0 && i != output.length - 1) {
                if (!firstZero)
                    res.append(output[i]);
            }
            else {
                res.append(output[i]);
                firstZero = false;
            }
        }
        return res.toString();
    }
}
