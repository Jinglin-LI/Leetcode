/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.
Each element in the array represents your maximum jump length at that position.
Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]
The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
*/
// 参考 http://www.cnblogs.com/lichen782/p/leetcode_Jump_Game_II.html
// Reach指的是可能达到的最大的index。lastReach是已经达到的index.当当前的i超越lastReach时候，表示需要再加step来到达可能的Reach.

public class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int lastReach = 0;
        int reach = 0;
        int step = 0;
        for (int i = 0; i <= reach && i < nums.length; i++) {
            if (i > lastReach) {
                step++;
                lastReach = reach;
            }
            reach = Math.max(reach, nums[i] + i);
        }
        if (reach < nums.length - 1)
            return 0;
        return step;
    }
}
