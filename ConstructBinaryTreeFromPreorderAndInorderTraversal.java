/*
Given preorder and inorder traversal of a tree, construct the binary tree.
Note:
You may assume that duplicates do not exist in the tree.
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 && inorder.length == 0)
            return null;
        int i = 0;
        for (i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) 
                break;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int[] inorderLeft = Arrays.copyOfRange(inorder, 0, i);
        int[] inorderRight = Arrays.copyOfRange(inorder, i + 1, inorder.length);
        int[] preorderLeft = Arrays.copyOfRange(preorder, 1, i + 1);
        int[] preorderRight = Arrays.copyOfRange(preorder, i + 1, preorder.length);
        root.left = buildTree(preorderLeft, inorderLeft);
        root.right = buildTree(preorderRight, inorderRight);
        return root;
    }
}
