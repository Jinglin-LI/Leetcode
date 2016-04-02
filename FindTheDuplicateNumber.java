/*
Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), 
prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

Note:
You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n2).
There is only one duplicate number in the array, but it could be repeated more than once.
*/
// 抽屉原理（六个兔子给五个笼子）。例子：1~10.小于等于5的个数一定是5，不然大于5个则目标数小于5。
// 找中间的index，遍历计数小于这个index值的数的个数，小于这个值的说明，目标数在mid左边。

public class Solution {
    public int findDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid)
                    count++;
            }
            if (count > mid)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }
}
