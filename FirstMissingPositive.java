/*
Given an unsorted integer array, find the first missing positive integer.
For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.
Your algorithm should run in O(n) time and uses constant space.
*/
// O(N). 即遍历nums的同时，将1与nums[0]交换，2与nums[1]交换，等。比nums长度大的、负数的都无视（可留在当前index中等待之后for loop）
// 在nums[0]中存1， nums[1]中存2...比nums长度大的、负数的都无视。nums[i] != nums[nums[i] - 1] 是防止本来那个地方有对的数，造成无限循环。

public class Solution {
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != i + 1 && nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;                   // 交换完，仍然是i再次循环
            }
            else
                i++;                              // 无视负数、大于nums长度的数和应在的相应位置已经对了的书
        }
        for (i = 0; i < nums.length; i++) {       // 新数组i == nums[i], 否则就有missing
            if (nums[i] != i + 1)
                return i + 1;
        }
        return nums.length + 1;                   // 如果都是正整数，返回大于其最大值
    }
}
