/*
Given a binary tree, determine if it is a valid binary search tree (BST).
Assume a BST is defined as follows:
  The left subtree of a node contains only nodes with keys less than the node's key.
  The right subtree of a node contains only nodes with keys greater than the node's key.
  Both the left and right subtrees must also be binary search trees.
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
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        return isSubLeftLessThan(root.left, root.val) && isSubRightGreaterThan(root.right, root.val) && isValidBST(root.left) && isValidBST(root.right);
    }
    private boolean isSubLeftLessThan(TreeNode p, int value) {
        if (p == null)
            return true;
        return p.val < value && isSubLeftLessThan(p.left, value) && isSubLeftLessThan(p.right, value);
    }
    private boolean isSubRightGreaterThan(TreeNode p, int value) {
        if (p == null)
            return true;
        return p.val > value && isSubRightGreaterThan(p.left, value) && isSubRightGreaterThan(p.right, value);
    }
}
