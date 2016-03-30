/*
Given a complete binary tree, count the number of nodes.
Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, 
and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
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
/*
求左子数高度，求右子树高度。相等的话，2^h - 1为节点数。如果高度不相等，递归调用countNode(left) + countNode(right) + 1 （加上最后的root）
用countLeft得到除root之外的左子数节点数；countRight存除root外的右子树节点数。
与一般的条件while式子有一点不同。例子为[1]，先计数1的话，答案为3.（可参考之前的submission）
*/

public class Solution {
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        int left = countLeftExceptRoot(root) + 1;
        int right = countRightExceptRoot(root) + 1;
        if (left == right) 
            return (2 << (left - 1)) - 1;                           // 2的指数次方
        else
            return countNodes(root.left) + countNodes(root.right) + 1;
    }
    private int countLeftExceptRoot(TreeNode root) {
        int count = 0;
        while (root.left != null) {                                // 与常规条件式不同
            count++;
            root = root.left;
        }
        return count;
    }
    private int countRightExceptRoot(TreeNode root) {
        int count = 0;
        while (root.right != null) {
            count++;
            root = root.right;
        }
        return count;
    }
}
