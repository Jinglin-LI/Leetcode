/*
Given a sorted array of integers, find the starting and ending position of a given target value.
Your algorithm's runtime complexity must be in the order of O(log n).
If the target is not found in the array, return [-1, -1].
For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
*/

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        int temp = BinarySearch(nums, 0, nums.length - 1, target);
        
        if (temp != -1) {
            int low = temp, high = temp;
            res[0] = low;                                                                   // single target
            res[1] = high;
            
            while ((low = BinarySearch(nums, 0, low - 1, target)) != -1)                    // change low, change res[0]
                res[0] = low;
            while ((high = BinarySearch(nums, high + 1, nums.length - 1, target)) != -1)
                res[1] = high;
        }
        return res;
    }
    private int BinarySearch(int[] a, int low, int high, int target) {
       while (low <= high) {                                                                // single number
            int mid = (low + high) / 2;
            if (a[mid] < target)
                low = mid + 1;
            else if (a[mid] > target)
                high = mid - 1;                                                             // because of low <= high, if high = mid, LTE
            else
                return mid;
       }
       return -1;
    }
}
