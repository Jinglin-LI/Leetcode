/*
Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
Solve it without division and in O(n).
For example, given [1,2,3,4], return [24,12,8,6].
*/
// consider the 0. the res[i] return other elements' product except 0.

/*
用int[] res 正向与反向两次记录除本身的乘积。第一次正向记录nums[i]前面的数的乘积，第二次反向记录nums[i]后面的数的乘积 * res[i]。
例如            1   2   3   4   5
    正向        1   1   2   6   24
    反向      120  60  40  30
或者，利用两个array记录，再乘起来。
*/

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length < 1)
			return nums;
		int[] res = new int[nums.length];
		res[0] = 1;
		for (int i = 1; i < nums.length; i++)
			res[i] = res[i - 1] * nums[i - 1];
		int right = 1;                                      // 用right记录nums[i]后面的数的乘积。
		for (int i = nums.length - 1; i >= 0; i--) {
			res[i] *= right;
			right *= nums[i];
		}
		return res;
    }
}
