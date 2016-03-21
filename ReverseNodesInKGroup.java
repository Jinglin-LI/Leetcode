/*
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
You may not alter the values in the nodes, only nodes itself may be changed.
Only constant memory is allowed.
For example,
Given this linked list: 1->2->3->4->5
For k = 2, you should return: 2->1->4->3->5
For k = 3, you should return: 3->2->1->4->5
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
 /* 
1. 不是边走边reverse，因为最后剩下不足K个node反转完了不能回头。
2. 例如k=3. 1->2->3->4->5 变为 dummyHead->2->1,3->4->5, 然后变为dummyHead->3->2->1, 4->5
3. pre = reverse(pre, next)中，reverse了之前的链表，store进pre中（cur的前一个）。四个指针。
 */ 
 
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null)
            return null;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            count++;
            ListNode next = cur.next;
            if (count == k) {
                pre = reverse(pre, next);       // reverse link, store pre
                count = 0;
            }
            cur = next;
        }
        return dummyHead.next;
    }
    
    private ListNode reverse(ListNode pre, ListNode end) {
        if (pre == null || pre.next == null)
            return null;
        ListNode head = pre.next;               // head of need-reverse link
        ListNode cur = head.next;
        while (cur != end) {
            ListNode next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = next;
        }
        head.next = end;
        return head;
    }
}
