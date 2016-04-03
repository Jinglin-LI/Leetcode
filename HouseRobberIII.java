/*
The thief has found himself a new place for his thievery again. 
There is only one entrance to this area, called the "root." 
Besides the root, each house has one and only one parent house. 
After a tour, the smart thief realized that "all houses in this place forms a binary tree".
It will automatically contact the police if two directly-linked houses were broken into on the same night.
Determine the maximum amount of money the thief can rob tonight without alerting the police.

Example 1:
     3
    / \
   2   3
    \   \ 
     3   1
Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
Example 2:
     3
    / \
   4   5
  / \   \ 
 1   3   1
Maximum amount of money the thief can rob = 4 + 5 = 9.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// 递归和DP. // maxVal[0] store the max value withouth the current root; maxVal[1] with robing the current root

public class Solution {
    public int rob(TreeNode root) {
        int[] maxVal = helper(root);
        return Math.max(maxVal[0], maxVal[1]);              // 求抢劫root和不抢劫root的最大利益的较大值
    }
    private int[] helper(TreeNode root) {
        if (root == null)
            return new int[]{0, 0};
        int[] maxVal = new int[2];
        int[] leftMax = helper(root.left);                  // 递归，求左子数不抢劫root.left的最大利益和抢劫root.left的最大利益
        int[] rightMax = helper(root.right);
        maxVal[0] = Math.max(leftMax[0], leftMax[1]) + Math.max(rightMax[0], rightMax[1]);
        maxVal[1] = leftMax[0] + root.val + rightMax[0];
        return maxVal;
    }
}
