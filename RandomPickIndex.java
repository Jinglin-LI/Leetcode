/*
Given an array of integers with possible duplicates, randomly output the index of a given target number. 
You can assume that the given target number must exist in the array.

Note:
The array size can be very large. Solution that uses too much extra space will not pass the judge.

Example:

int[] nums = new int[] {1,2,3,3,3};
Solution solution = new Solution(nums);

// pick(3) should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
solution.pick(3);

// pick(1) should return 0. Since in the array only nums[0] is equal to 1.
solution.pick(1);

*/



/* 概率解释： 
The first index has a probability of 1 of being selected. 
The second has a probability of 1 / 2 of swapping the original and then 1 / 3 and so on and so forth
*/
public class Solution {
    public int[] nums;
    public Random random;
    
    public Solution(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }
    
    public int pick(int target) {
        int res = -1;                  // 初始化为-1，如果没找到返回-1
        int upbound = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
            
                // 从0-upbound中随机取
                if (random.nextInt(upbound) == 0) {
                    res = i;
                }
                upbound++;
            }
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
