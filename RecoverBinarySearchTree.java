/*
Two elements of a binary search tree (BST) are swapped by mistake.
Recover the tree without changing its structure.
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
// 中序遍历，两个错误的Node有可能相连或有间隔。上调的中序遍历第一个错的和最后一个错的（大于其root的）便是答案。相连的却只能检测出一次，所以b的初始化为a + 1. 
// 此题还需要考虑复杂度和空间问题。（即用另一个ArrayList存储需要换的Node但是无需把全部中序遍历进行存储）其Reference：http://blog.csdn.net/linhuanmars/article/details/24566995
 
public class Solution {
    public void recoverTree(TreeNode root) {
        ArrayList<TreeNode> list = new ArrayList<>();
        inOrder(root, list);
        int a = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).val > list.get(i + 1).val) {
                a = i;
                break;
            }
        }
        int b = a + 1;                                      // note: 如果两个相连的node写错，则只能检测出一次。所以b初始化不是0.
        for (int i = a + 1; i < list.size() - 1; i++) {
            if (list.get(i).val > list.get(i + 1).val) {
                b = i + 1;
                break;
            }
        }
        int temp = list.get(a).val;
        list.get(a).val = list.get(b).val;
        list.get(b).val = temp;
    }
    private void inOrder(TreeNode root, ArrayList<TreeNode> list) {
        if (root == null)
            return;
        inOrder(root.left, list);
        list.add(root);
        inOrder(root.right, list);
    }
}
