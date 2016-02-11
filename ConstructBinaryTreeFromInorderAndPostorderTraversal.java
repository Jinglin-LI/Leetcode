/*
Given inorder and postorder traversal of a tree, construct the binary tree.
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 && postorder.length == 0)
            return null;
        int i = 0;
        for (i = 0; i < inorder.length; i++) {
            if (inorder[i] == postorder[postorder.length - 1])
                break;
        }
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        int[] inorderLeft = Arrays.copyOfRange(inorder, 0, i);
        int[] inorderRight = Arrays.copyOfRange(inorder, i + 1, inorder.length);
        int[] postorderLeft = Arrays.copyOfRange(postorder, 0, i);
        int[] postorderRight = Arrays.copyOfRange(postorder, i, postorder.length - 1);
        root.left = buildTree(inorderLeft, postorderLeft);
        root.right = buildTree(inorderRight, postorderRight);
        return root;
    }
}
