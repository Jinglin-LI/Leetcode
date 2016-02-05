/*
Sort a linked list using insertion sort.
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
    public ListNode insertionSortList(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        
        if (head == null || head.next == null)
            return head; 
            
        ListNode pre = head;
        ListNode cur = pre.next;
        while (cur != null) {
            ListNode next = cur.next;
            if (cur.val >= pre.val) {                                   // from the second ListNode, insert it
                pre = cur;
                cur = next;
            }
            else {
                pre.next = next;
                ListNode p = dummyHead;
                while (p.next != null && p.next.val < cur.val) {
                    p = p.next;
                }
                cur.next = p.next;
                p.next = cur;
                cur = next;
            }
        }
        return dummyHead.next;
    }
}
