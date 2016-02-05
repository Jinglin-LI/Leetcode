/*
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
Note: Do not modify the linked list.
Follow up:
Can you solve it without using extra space?
*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                break;
        }
        if (fast == null || fast.next == null)                          // Note the single linkedlist condition
            return null;
            
        fast = head;                                                    // from the head to the equal node, both ++ to the same node
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;                                                    // consider the circle linkedlist with single node
    }
}
