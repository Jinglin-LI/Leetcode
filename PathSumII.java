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
 
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Stack<Integer> stack = new Stack<>();
        DFS(res, stack, root, sum);
        return res;
    }
    private void DFS(List<List<Integer>>res, Stack<Integer> stack, TreeNode node, int sum) {
        if (node == null)
            return;
        stack.push(node.val);
        if (node.left == null && node.right == null) {
            if (sum == node.val) {
                res.add(new ArrayList<Integer> (stack));                          // Note this
            }
        }
        DFS(res, stack, node.left, sum - node.val);
        DFS(res, stack, node.right, sum - node.val);
        stack.pop();
    }
}
