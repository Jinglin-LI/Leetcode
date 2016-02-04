/*
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
*/

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode cur = pre.next;
        
        while (cur!= null) {
            while (cur.next != null && pre.next.val != cur.next.val) {
                pre = pre.next;
                cur = cur.next;
            }
            if (cur.next != null && pre.next.val == cur.next.val) {
                while (cur.next != null && pre.next.val == cur.next.val)
                    cur = cur.next;
                pre.next = cur.next;
            }
            cur = cur.next;
        }
        return dummyHead.next;
    }
}
