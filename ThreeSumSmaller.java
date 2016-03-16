/*
Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.
For example, given nums = [-2, 0, 1, 3], and target = 2.
Return 2. Because there are two triplets which sums are less than 2:
[-2, 0, 1]
[-2, 0, 3]
*/
// 初始时，i指向第一个元素，left指向第二个元素，第三个指针right从后面向前移动。left向后移动，right向前移动。

public class Solution {
	public int threeSumSmaller (int[] nums, int target) {
		Arrays.sort(nums);
		int res = 0;
		for (int i = 0; i < nums.length - 2; i++) {
			int left = i + 1;
			int right = nums.length - 1;
			while (left < right) {
				int sum = nums[left] + nums[right] + nums[i];
				if (sum >= target)
					right--;
				else {
					res = res + right - left;
					left++;
				}
			}
		}
		return res;
	}
}
