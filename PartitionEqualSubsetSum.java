/**
Given a non-empty array containing only positive integers, 
find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
Note:
Both the array size and each of the array element will not exceed 100.
Example 1:
Input: [1, 5, 11, 5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].
Example 2:
Input: [1, 2, 3, 5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.
*/

public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);
        for (int i : nums) 
            sum += i;
        if (sum % 2 == 1)
            return false;
        int target = sum / 2;
        return helper(nums, 0, target);
    }
	public boolean helper(int[] nums, int start, int target) {
		for (int i = start; i < nums.length; i++) {
			if (nums[i] == target)
				return true;
			if (nums[i] > target)
				return false;
			if (helper(nums, start + 1, target - nums[i]))
				return true;
		}
		return false;
	}
}
