/*
Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?
Would this affect the run-time complexity? How and why?
Write a function to determine if a given target is in the array.
*/

public class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) 
            return false;
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (nums[mid] == target) 
                return true;
            if(nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
                high--;
            } 
            else if(nums[low] == nums[mid])
                low = mid + 1;
            else if(nums[mid] == nums[high])
                high = mid;
            else if (nums[low] < nums[mid]) {                   // left half sorted
                if (nums[low] <= target && target < nums[mid]) 
                    high = mid - 1;
                else
                    low = mid + 1;
            } 
            else if (nums[low] > nums[mid]) {                   // right half sorted
                if (nums[mid] < target && target <= nums[high])
                    low = mid + 1;
                else high = mid - 1;
            }
        }
        return false;
    }
}
