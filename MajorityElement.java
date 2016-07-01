/*
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
You may assume that the array is non-empty and the majority element always exist in the array.
*/

public class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (hm.containsKey(nums[i]))
                hm.put(nums[i], hm.get(nums[i]) + 1);
            else if (!hm.containsKey(nums[i]))
                hm.put(nums[i], 1);
            if (hm.get(nums[i]) > nums.length / 2)
                return nums[i];
        }
        return 0;
    }
    public int majorityElement2(int[] nums) {
		if(nums == null || nums.length == 0)
			return 0;
		int count = 1;
		int res = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == res)
				count++;
			else {
				count--;
			}
			if (count == 0) {
				res = nums[i];
				count = 1;
			}
		}
		return res;
	}
}
