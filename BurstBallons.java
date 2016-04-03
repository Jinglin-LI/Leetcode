/*
Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. 
You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. 
Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.
Find the maximum coins you can collect by bursting the balloons wisely.

Note: 
(1) You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
(2) 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100

Example:
Given [3, 1, 5, 8]
Return 167
    nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
   coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
*/
/*
二维DP. dp[i][j]用来存储，打破了i~j气球之后（即remove掉不再参与），得到的最多的硬币。所以最后返回都打破（1, nums.length）得到的硬币。
对于介于i~j之间的任意数x(x没被打破，即，将假设i~j之间加上这个数，将中间三个数分成三个离得很远的index)，遍历以求dp[i][j].
例子：          i   x1 x2 x3 x4...   j
因此这次不用for循环遍历i与j, 直接求dp[1][nums.length].
global硬币数目由三部分组成，左边部分得到的最大值 + 中间三个数相乘 + 右边部分得到的最大值。
左边和右边得到硬币最大值由递归得到。
*/

public class Solution {
    public int maxCoins(int[] nums) {
        int[] newNums = new int[nums.length + 2];
        for (int i = 0; i < nums.length; i++) {                               // 假设nums最左边和最右边的数为1
            newNums[i + 1] = nums[i];
        }
        newNums[0] = newNums[nums.length + 1] = 1;
        int[][] dp = new int[nums.length + 2][nums.length + 2];
        return helper(1, nums.length, newNums, dp);
    }
    private int helper(int i, int j, int[] newNums, int[][] dp) {             // helper得到打破i~j气球后得到最多的硬币数目
        if (dp[i][j] != 0)                                                    // 如果dp[i][j]已更新了，就返回，不再参与for循环
            return dp[i][j];
        for (int x = i; x <= j; x++) {                                        // 对于i~j中任意气球x
            dp[i][j] = Math.max(dp[i][j], 
                      helper(i, x - 1, newNums, dp) + 
                      newNums[i - 1] * newNums[x] * newNums[j + 1] +
                      helper(x + 1, j, newNums, dp));
        }
        return dp[i][j];
    }
}
