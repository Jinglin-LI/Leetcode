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
}
