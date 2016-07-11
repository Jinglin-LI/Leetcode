/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
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
 
import java.util.*;
public class PathSumII {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode (int x) {
			val = x;
		}
	}
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null)
			return res;
		List<Integer> list = new ArrayList<>();
		helper(res, list, root, sum);
		return res;
	}
	private void helper(List<List<Integer>> res, List<Integer> list, TreeNode node, int sum) {
		if (node == null)
			return;
		list.add(node.val);
		if (node.left == null && node.right == null && sum == node.val) 
			res.add(new ArrayList<>(list));
		
		helper(res, list, node.left, sum - node.val);
		helper(res, list, node.right, sum - node.val);
		list.remove(list.size() - 1);
	}
}
