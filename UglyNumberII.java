/*
Write a program to find the n-th ugly number.
Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
Note that 1 is typically treated as an ugly number.

Hint:
The naive approach is to call isUgly for every number until you reach the nth one. Most numbers are not ugly. Try to focus your effort on generating only the ugly ones.
An ugly number must be multiplied by either 2, 3, or 5 from a smaller ugly number.
The key is how to maintain the order of the ugly numbers. Try a similar approach of merging from three sorted lists: L1, L2, and L3.
Assume you have Uk, the kth ugly number. Then Uk+1 must be Min(L1 * 2, L2 * 3, L3 * 5).
*/

public class Solution {
    public int nthUglyNumber(int n) {
        if (n <= 0)
            return 0;
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        
        int i = 0;                                                // ArrayList中的位置，即代表指针向后移动，再乘以因数2、3、5
        int j = 0;
        int k = 0;
        
        while (nums.size() < n) {
            int m2 = nums.get(i) * 2;
            int m3 = nums.get(j) * 3;
            int m5 = nums.get(k) * 5;
            
            int min = Math.min(Math.min(m2, m3), m5);             // 目前三个之中最小的数加入ArrayList                     
            nums.add(min);
            
            if (min == m2)
                i++;
            if (min == m3)
                j++;
            if (min == m5)
                k++;
        }
        return nums.get(nums.size() - 1);
    }
}
