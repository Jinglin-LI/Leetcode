/*
Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
*/
/* 
DP. 前面如果很小的负数，后面如果有负数，则变正且大的数。所以利用max和min存储local的最大和最小乘积。
其存储三个值的最大（小）值：nums[i], max * nums[i], min * nums[i]. 而max和min都会update，所以用一个tempMax暂时存储max. 
实际上是利用两个一位数组，然而只是最后一个数用到，所以就用两个int值即可.
*/

public class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int max = nums[0];
        int min = nums[0]; 
        
        int res = max;
        for (int i = 1; i < nums.length; i++) {
            int tempMax = max;                               // because max will be updated before the update of min, but min need the previous max. So store the previous max. 
            max = Math.max(nums[i], Math.max(nums[i] * tempMax, nums[i] * min));
            min = Math.min(nums[i], Math.min(nums[i] * tempMax, nums[i] * min));
            res = Math.max(res, max);
        }
        return res;
    }
}
