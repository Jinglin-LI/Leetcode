/*
Given an integer, write a function to determine if it is a power of two.
*/

public class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n == 0)
            return false;
        if (n == 1)
            return true;
        while (n != 1) {
            if ((n & 1) == 1)
                return false;
            n = n >> 1;
        }
        return true;
    }
}
