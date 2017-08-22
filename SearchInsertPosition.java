/*
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
You may assume no duplicates in the array.
Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
*/

public class Solution {
    
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        int low = 0; 
        int high = nums.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }
        return low;
    }
    
    /**************************************************************************************************/
    
    // discard this
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        
        while (low <= high) {
            int middle = (low + high) / 2;
            if (nums[middle] < target) {
                low = middle + 1;
            }
            else if (nums[middle] > target) {
                high = middle - 1;
            }
            else 
                return middle;
        }
        if (low > high) {
            int middle = (low + high) / 2;
            if (nums[middle] < target)
                return middle + 1;
            if (nums[middle] >= target)
                return Math.max(middle - 1, 0);
        }
        return -1;
    }
}
