/*
Find the sum of all left leaves in a given binary tree.
Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
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
public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        int res = 0;
        if (root == null)
            return res;
        if (root.left != null && root.left.left == null && 
        root.left.right == null)                // 判断s根的左子数是左叶子。
            res += root.left.val;
        else
            res += sumOfLeftLeaves(root.left);
        res += sumOfLeftLeaves(root.right);
        return res;
    }
}
