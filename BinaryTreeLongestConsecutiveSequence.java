/*
Given a binary tree, find the length of the longest consecutive sequence path.
The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).
For example,
   1
    \
     3
    / \
   2   4
        \
         5 
Longest consecutive sequence path is 3-4-5, so return 3.
   2
    \
     3
    / 
   2    
  / 
 1 
Longest consecutive sequence path is 2-3,not3-2-1, so return 2.
*/
// 题目要求：给一个binary tree, 问怎么找其中最长的连续递增的path.

public class Solution {
	public int res = Integer.MIN_VALUE;
	public int longestConsecutive (TreeNode root) {
		if (root == null)
			return 0;
		dfs(root, 0, root);
		return res;
	}
	private void dfs(TreeNode root, int height, TreeNode preRoot) {
		if (root == null)
			return;
		if (root.val == preRoot.val + 1)
			height++;
		else
			height = 1;                                 // 如果不是递增了，重新从该节点计算height.
		res = Math.max(res, height);                  // 比较现有的res与重新计算的递增节点所形成的height.
		dfs(root.left, height, root);
		dfs(root.right, height, root);
	}
}
