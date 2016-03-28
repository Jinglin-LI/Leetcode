/*
Follow up for "Find Minimum in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

The array may contain duplicates.
*/
// 跟I比，II中的数组中可包含duplicates. Reference : http://www.cnblogs.com/yuzhangcmu/p/4049117.html

public class Solution {
    public int findMin(int[] nums) {
        if (nums == null | nums.length == 0)
            return 0;
        int len = nums.length;
        if (len == 1)
            return nums[0];
        else if (len == 2)
            return Math.min(nums[0], nums[1]);
        int left = 0, right = len - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[left] < nums[right])
                return nums[left];
            if (nums[left] < nums[mid])
                left = mid;
            else if (nums[left] > nums[mid])
                right = mid;
            else
                left++;
        }
        return Math.min(nums[left], nums[right]);
    }
}
