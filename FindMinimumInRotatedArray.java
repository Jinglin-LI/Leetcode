/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.
(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
Find the minimum element.
You may assume no duplicate exists in the array.
*/

public class Solution {
    public int findMin(int[] nums) {
        int low = 0; 
        int high = nums.length - 1;
        
        while (low < high && nums[low] > nums[high]) {
            int middle = (low + high) / 2;
            if (nums[middle] > nums[high])
                low = middle + 1;
            else if (nums[middle] < nums[high]) 
                high = middle;                                    // Note the high change to middle instead of middle - 1 in case of ignoring array[middle]
        }
        return nums[low];
    }
}
