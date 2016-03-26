/*
Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
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
 NP. 依次选取一个节点i为根，左子数取0到i-1，右子树取i+1到n.且左右子树是乘积。leftList和rightList每一个index里面存的都是完整的子树
 当left > right时，因为递归的关系，res要add(null)表示其返回空子树。例子：input 1, 返回[[1]]而不是空。
 */
 
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> list = new ArrayList<>();                  // 排除掉input为0的情况
        if(n == 0)
            return list;
        return helper(1, n);
    }
    private List<TreeNode> helper(int left, int right) {
        List<TreeNode> res = new ArrayList<>();                   // 每一次recursive都要创造新的List<TreeNode>, 如leftList和rightList.
        if (left > right) {
            res.add(null);                                        // 空子树
            return res;
        }
        for (int i = left; i <= right; i++) {
            List<TreeNode> leftList = helper(left, i - 1);
            List<TreeNode> rightList = helper(i + 1, right);
            for (int j = 0; j < leftList.size(); j++) {
                for (int k = 0; k < rightList.size(); k++) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftList.get(j);
                    root.right = rightList.get(k);
                    res.add(root);
                }
            }
        }
        return res;
    }
}
