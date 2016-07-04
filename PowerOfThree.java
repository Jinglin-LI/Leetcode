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
    public boolean isPowerOfThree2(int n) {
        return n > 0 && 1162261467 % n == 0;                    // 1162261467 is 3^19,  3^20 is bigger than 2147483647 
    }
}
