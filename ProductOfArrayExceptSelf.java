/*
Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
Solve it without division and in O(n).
For example, given [1,2,3,4], return [24,12,8,6].
*/
// consider the 0. the res[i] return other elements' product except 0.

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int totalProduct = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                totalProduct = 1;
                int index = i;
                for (int j = 0; j < nums.length; j++) {
                    if (j != index) {
                        totalProduct = totalProduct * nums[j];
                    }
                }
                res[index] = totalProduct;
                return res;
            }
            totalProduct = totalProduct * nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0)
                res[i] = totalProduct / nums[i];
        }
        return res;
    }
}
