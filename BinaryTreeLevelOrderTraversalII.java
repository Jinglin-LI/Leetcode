/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> reversedres = new ArrayList<List<Integer>>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null)
            return res;
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        
        while (!q.isEmpty()) {
            List<Integer> cur = new ArrayList<Integer>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode n = q.poll();
                cur.add(n.val);
                if (n.left != null)
                    q.add(n.left);
                if (n.right != null)
                    q.add(n.right);
            }
            reversedres.add(cur);
        }
        
        for (int j = reversedres.size() - 1; j >= 0; j--)
            res.add(reversedres.get(j));
        return res;
    }
}
