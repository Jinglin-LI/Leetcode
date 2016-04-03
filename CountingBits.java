/*
Given a non negative integer number num. 
For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

Example:
For num = 5 you should return [0,1,1,2,1,2].

Follow up:
It is very easy to come up with a solution with run time O(n*sizeof(integer)). 
But can you do it in linear time O(n) /possibly in a single pass?
Space complexity should be O(n).
Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.

Hint:
You should make use of what you have produced already.
Divide the numbers in ranges like [2-3], [4-7], [8-15] and so on. And try to generate new range from previous.
Or does the odd/even status of the number help you in calculating the number of 1s?
*/
/*
DP. 以[2-3], [4-7], [8-15]为分隔，2、4、8、16都是1个1. 其他的数减去因子发现都是循环。最后返回dp整个数组。
例子：  nums: 0 1 2 3     4 5 6 7  (5~7剪4后是dp[i - 4] + 1)   8 9 10 11 12 (9~15剪8后是dp[i - 8] + 1)
          dp: 0 1 1 2     1 2 2 3                              1 2  2  3  2
*/

public class Solution {
    public int[] countBits(int num) {
        if (num == 0)
            return new int[]{0};
        int[] dp = new int[num + 1];
        dp[0] = 0;
        dp[1] = 1;
        int factor = 1;
        
        for (int i = 2; i < num + 1; i++) {
            if (i == factor * 2) {              // 2、4、8、16 的dp[i]为1
                dp[i] = 1;
                factor = i;
            }
            else {
                dp[i] = dp[i - factor] + 1;
            }
        }
        return dp;
    }
}
