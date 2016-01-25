/*
Given an integer, write a function to determine if it is a power of three.
*/

public class Solution {
    public boolean isPowerOfThree(int n) {
        while (n > 1) {
            if (n % 3 != 0)
                return false;
            n = n / 3;
        }
        if (n == 1)
            return true;
        return false;
    }
}
