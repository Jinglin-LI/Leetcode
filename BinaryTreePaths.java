/*
Given a binary tree, return all root-to-leaf paths.
For example, given the following binary tree:
   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:
["1->2->5", "1->3"]
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null)
            return res;
        String str = "" + root.val;
        helper(res, root, str);
        return res;
    }
    private void helper(List<String> res, TreeNode node, String str) {
        if (node.left == null && node.right == null) {
            res.add(str);
            return;
        }
        if (node.left != null) 
            helper(res, node.left, str + "->" + node.left.val);
        if (node.right != null)
            helper(res, node.right, str + "->" + node.right.val);
    }
}
