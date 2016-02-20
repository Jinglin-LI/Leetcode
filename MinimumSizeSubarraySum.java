/*
Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.
For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.
*/
// to sum to the index end, minus the number of index start.

public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int res = Integer.MAX_VALUE;
        int start = 0, end = 0, sum = 0;
        while (end < nums.length) {
            sum = sum + nums[end];
            while (sum >= s) {
                res = Math.min(res, end - start + 1);
                sum = sum - nums[start];
                start++;
            }
            end++;
        }
        return res == Integer.MAX_VALUE? 0 : res;
    }
}
