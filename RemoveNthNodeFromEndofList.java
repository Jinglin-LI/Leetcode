/*
Given a linked list, remove the nth node from the end of list and return its head.
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        ListNode p1 = dummyHead;
        ListNode p2 = dummyHead;
        int i = 0;
        dummyHead.next = head;
        
        while (i < n) {
            p2 = p2.next;
            i++;
        }
        
        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        
        p1.next = p1.next.next;
        return dummyHead.next;
    }
}
