/*
Given an integer n, return the number of trailing zeroes in n!.
Note: Your solution should be in logarithmic time complexity.
*/

public class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            int factors = n / 5;                        // how many 5 factors in numbers from n / 5 to n. 
            count = count + factors;
            n = n / 5;
        }
        return count;
    }
}
