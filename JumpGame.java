/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.
Each element in the array represents your maximum jump length at that position.
Determine if you are able to reach the last index.
For example:
A = [2,3,1,1,4], return true.
A = [3,2,1,0,4], return false.
*/

public class Solution {
    public boolean canJump(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            i += nums[i];
            
            if (i >= nums.length - 1)
                return true;
            if (nums[i] == 0) {
                for (int j = i; j >= 0; j--) {
                    if (nums[j] > i - j) {
                        i = j;
                        break;                                        // Note the usage of break
                    }
                    if (j == 0) 
                        return false;
                }
            }
        }
        return false;
    }
}
