/*
Given a non-negative number represented as an array of digits, plus one to the number.
The digits are stored such that the most significant digit is at the head of the list.
*/

public class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            else {
                digits[i] = 0; 
            }
        }
		if (digits[0] == 0) {
			int[] result = new int[digits.length + 1];
			    result[0] = 1;
			for (int j = 1; j < digits.length; j++)
			    result[j] = 0;
			return result;
		}
		else
			return digits;
    }
}
