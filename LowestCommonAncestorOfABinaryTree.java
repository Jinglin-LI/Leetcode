/*
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
According to the definition of LCA on Wikipedia: 
“The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants 
(where we allow a node to be a descendant of itself).”
        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4
For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. 
Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)                   // 发现目标节点
            return root;
        TreeNode inLeft = lowestCommonAncestor(root.left, p, q);      // 寻找左子树中是存在p和q的祖先，没有返回null
        TreeNode inRight = lowestCommonAncestor(root.right, p, q);    // 同上，寻找右子树中p和q的祖先
        if(inLeft != null && inRight != null)
            return root;                                              // 如果左右子树都不存在p和q的祖先，则root为最小祖先
        return inLeft == null? inRight : inLeft;
        
    }
}
