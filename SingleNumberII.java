/*
Given an array of integers, every element appears three times except for one. Find that single one.
Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*/
/*
Reference: http://www.cnblogs.com/springfor/p/3870863.html

把每一位数都想成二进制的数，用一个32位的数组来记录每一位上面的1的count值。
这里注意数组计数是从左往右走，而二进制数数是从右往左的。
所以数组第0位的count就是二进制最低位上的count的。
例如：4的二进制是100（当然作为32位就是前面还一堆了000...000100这样子），
3个4的话按照每位相加的话，按照二进制表示法考虑就是300，当然存在数组里面就是003（A[0]=0;A[1]=0;A[2]=3，然后后面到A[31]都得0）。 

然后对所有数按照二进制表示按位加好后，就要把他还原成所求的值。
这里面的想法是，如果一个数字出现了3次，那么这个数字的每一位上面，如果有1那么累加肯定是得3的，如果是0，自然还是0。
所以对每一位取余数，得的余数再拼接起来就是我们要找的那个single one。

这里还原的方法是，对32位数组从0开始，对3取余数，因为数组0位置其实是二进制的最低位，所以每次要向左移。用OR（|）和 + 都可以拼接回来。
*/


public class Solution {
    public int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int[] count = new int[32];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 32; j++) {
                if ((nums[i] >> j & 1) == 1) {
                    count[j]++;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res += (count[i] % 3) << i;
        }
        return res;
    }
}
