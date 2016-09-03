/*
Given a binary tree, return the preorder traversal of its nodes' values.
For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].
*/

import java.util.*;
public class BinaryTreePreorderTraversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		if (root == null)
			return list;
		Stack<TreeNode> stack = new Stack<>();
		stack.add(root);
		while (!stack.isEmpty()) {
			TreeNode temp = stack.pop();
			if (temp.right != null)
				stack.add(temp.right);
			if (temp.left != null)
				stack.add(temp.left);
			list.add(temp.val);
		}
		return list;
	}
}
