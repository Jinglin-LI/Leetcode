/*
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
You must do this in-place without altering the nodes' values.
For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode helper = slow.next;
        slow.next = null;                               // separate two linkedlist 
        
        helper = reverseLinkedList(helper);
        
        ListNode p1 = head;
        ListNode p2 = helper;
        
        while (p2 != null) {
            ListNode temp = p1.next;
            p1.next = p2;
            p1 = p1.next;
            p2 = p2.next;
            p1.next = temp;
            p1 = p1.next;
        }
    }
    private ListNode reverseLinkedList(ListNode head) {
        ListNode pre = head;
        ListNode cur = pre.next;
        pre.next = null;
        
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
