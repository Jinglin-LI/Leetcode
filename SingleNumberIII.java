/*
Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. 
Find the two elements that appear only once.

For example:
Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

Note:
The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
*/
/* 
位操作。全部异或，得到num1^num2。将nums[]分成两部分（每部分只含有num1或num2），分开的原则如下：
num1^num2至少有一位为1。找到最低位为1的位置，将nums[]分成一部分这个位置为1，一部分这个位置为0. 则将两个数分成两部分。分别异或得值。
*/

public class Solution {
    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        if (nums == null || nums.length == 0)
            return nums;
        int x1_XOR_x2 = 0;
        for (int num : nums)
            x1_XOR_x2 ^= num;
   
        int last_1_Bit = x1_XOR_x2 - (x1_XOR_x2 & (x1_XOR_x2 - 1));     // get the last 1 bit of x1_XOR_x2, e.g. 1010 ==> 0010 
        int num1 = 0;
        int num2 = 0;
        for (int num : nums) {
            if ((last_1_Bit & num) == 0)
                num1 ^= num;
            else
                num2 ^= num;
        }
        res[0] = num1;
        res[1] = num2;
        return res;
    }
}
