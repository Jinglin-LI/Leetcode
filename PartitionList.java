/*
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
You should preserve the original relative order of the nodes in each of the two partitions.
For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
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
    public ListNode partition(ListNode head, int x) {
        if (head == null)
            return null;
        ListNode dummyHead = new ListNode(0);
        ListNode helper = new ListNode(0);
        ListNode p = dummyHead;
        ListNode q = helper;
        ListNode cur = head;
 
        while (cur != null) {
            if (cur.val < x) {
                p.next = new ListNode(cur.val);                             // create a new node
                p = p.next;
            }
            else {
                q.next = new ListNode(cur.val);
                q = q.next;
            }
            cur = cur.next;
        }
        p.next = helper.next;
        return dummyHead.next;
    }
}
