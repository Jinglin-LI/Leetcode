/*
Given a binary tree, find the maximum path sum.
For this problem, a path is defined as 
any sequence of nodes from some starting node to any node in the tree along the parent-child connections. 
The path does not need to go through the root.

For example:
Given the below binary tree,
       1
      / \
     2   3
Return 6.
*/
/*
可以以任意结点起，任意结点终。四种情况。
1. Node only （因为本题中的节点可能是负值！）
2. L-sub + Node
3. R-sub + Node
4. L-sub + Node + R-sub
即：
1. root.val
2. root.val + left
3. root.val + right
4. left + root.val + right
用递归计算left和right。current返回的是一边儿（node左边或右边, 即1,2和3情况）的最大值。
res[0]返回的是4种情况的最大值。因为res[0]可返回地址，不仅是值。利用List<>也是返回的地址。
*/
// http://www.programcreek.com/2013/02/leetcode-binary-tree-maximum-path-sum-java/
// http://blog.csdn.net/linhuanmars/article/details/22969069

import java.util.*;
public class BinaryTreeMaximumPathSum {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode (int x) {
			val = x;
		}
	}
	
	// use res[0] to transfer reference, but not value. 
	public int maxPathSum(TreeNode root) {
		int res[] = new int[1];
		res[0] = Integer.MIN_VALUE;
		helper(root, res);
		return res[0];
	}
	private int helper(TreeNode root, int[] res) {
		if (root == null)
			return 0;
		int left = helper(root.left, res);
		int right = helper(root.right, res);
		int current = Math.max(root.val, Math.max(root.val + left, root.val + right));
		res[0] = Math.max(res[0], Math.max(current,  left + root.val + right));		// return res[0] finally
		return current;			// return left and right
	}
	
	// use ArrayList to transfer reference, but not value. 
	public int maxPathSum2(TreeNode root) {
		if (root == null)
			return 0;
		List<Integer> res = new ArrayList<>();
		res.add(Integer.MIN_VALUE);
		helper2(root, res);
		return res.get(0);
	}
	private int helper2(TreeNode root, List<Integer> res) {
		if (root == null)
			return 0;
		int left = helper2(root.left, res);
		int right = helper2(root.right, res);
		int cur = root.val + (left > 0? left : 0) + (right > 0? right : 0);
		if (cur > res.get(0))
			res.set(0, cur);
		return root.val + Math.max(left, Math.max(right, 0));
	}
}
