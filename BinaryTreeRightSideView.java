/*
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        q.add(null);                                     // use null to separate tree layers
        int cur = 0;
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node != null) {
                cur = node.val;                         // 需要把null之前的node值记住。
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            }
            else {                                      // when point to the null, store the last element of the last layer, add null
                res.add(cur);
                if (q.isEmpty())                        // 要判断q是否为空。note. 
                    break;
                q.add(null);
            }
        }
        return res;
    }
}
