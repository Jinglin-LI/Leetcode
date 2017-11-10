/*
Follow up for problem "Populating Next Right Pointers in Each Node".
What if the given tree could be any binary tree? Would your previous solution still work?
Note:
You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
*/
/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
// 题目要求：之前I是完美二叉树，即全都填充。II为不完美，所以root.right.next就不一定等于root.next.left，允许子树为空。要一层一层链接。
// 要确定好root的右孩子的next结点，然后处理左孩子。
// 然后从右向左依次递归处理右孩子，左孩子。
 
/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeLinkNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            TreeLinkNode first = q.poll();
            if (first.left != null) {
                    q.add(first.left);
                }
                if (first.right != null) {
                    q.add(first.right);
                }
            for (int i = 1; i < size; i++) {
                TreeLinkNode temp = q.poll();
                first.next = temp;
                first = first.next;
                
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
            first.next = null;
        }
    }
}

/**************************************************************************************************/
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null)
            return;
        TreeLinkNode p = root.next;     // 假设某一个节点root，找它右边第一个节点的最左边的子树，以便root的最右边的子树连接。
        while (p != null) {             // while语句是为了左右子树都为空，则p = p.next找最右边的节点;
            if (p.left != null) {
                p = p.left;
                break;
            }
            if (p.right != null) {
                p = p.right;
                break;
            }
            p = p.next;                 // 如果root右边的结点都没有孩子，找更右边。因为要用root的孩子连root右边结点的孩子。如果都没有孩子，root的孩子指向空。
        }
        
        if (root.right != null)
            root.right.next = p;        // root最右边的孩子指向root右边结点最左边的孩子。
        if (root.left != null) {
            if (root.right != null)
                root.left.next = root.right;
            else
                root.left.next = p;
        }
        connect(root.right);
        connect(root.left);
    }
}
