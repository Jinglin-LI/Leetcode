/*
Rotate an array of n elements to the right by k steps.
For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
*/

public class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;                                                // Note the usage of this statement. "ROTATE"
        int j = 0;
        int[] helper = new int[nums.length];
        for (int i = nums.length - k; i < nums.length; i++) {
            helper[j] = nums[i];
            j++;
        }
        for (int i = 0; i < nums.length - k; i++) {
            helper[j] = nums[i];
            j++;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = helper[i];
        }
    }
}
