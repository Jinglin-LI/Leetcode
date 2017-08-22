/*
Given a non-negative number represented as an array of digits, plus one to the number.
The digits are stored such that the most significant digit is at the head of the list.
*/

public class Solution {
	public int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        
        while (i >= 0 && digits[i] == 9) {
            digits[i--] = 0;
        }
        if (i == -1) {
            int[] res = new int[digits.length + 1];
            Arrays.fill(res, 0);
            res[0] = 1;
            return res;
        }
        else {
            digits[i] += 1;
        }
        return digits;  
}
	
/***************************************************************************************/
	
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
