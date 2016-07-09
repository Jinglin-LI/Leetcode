/*
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
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
// 利用slow和fast指针找二分法中间的数作为root. 

public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null)
            return null;
        return helper(head, null);
    }
    private TreeNode helper(ListNode head, ListNode tail) {
        if (head == tail)
            return null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        TreeNode root = new TreeNode(slow.val);
        root.left = helper(head, slow);
        root.right = helper(slow.next, tail);
        return root;
    }
    
    public TreeNode sortedListToBST2(ListNode head) {
        if (head == null)
            return null;0
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            pre = pre.next;
        }
        if (pre.next == head)                               // 如果head已经进入tree, 后面root.left就不能再加入head.
            head = null;
        pre.next = null;
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }
}
