/*
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
An example is the root-to-leaf path 1->2->3 which represents the number 123.
Find the total sum of all root-to-leaf numbers.
For example,
    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Return the sum = 12 + 13 = 25.
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
 // Recursive. base每次递归时乘以10. 题目要求求左右子树的数字之和。思路是递归得左子数，右子树，然后求和。
 
public class Solution {
    public int sumNumbers(TreeNode root) {
        int res = 0;
        if (root == null)
            return res;
        return helper(root, 0);
    }
    private int helper(TreeNode node, int base) {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null)
            return base + node.val;
        int nextBase = (base + node.val) * 10;
        
        int leftSubtreeSum = helper(node.left, nextBase);
        int rightSubtreeSum = helper(node.right, nextBase);
        return leftSubtreeSum + rightSubtreeSum;
    }
}
