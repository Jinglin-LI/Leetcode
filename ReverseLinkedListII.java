/*
Reverse a linked list from position m to n. Do it in-place and in one-pass.
For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,
return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode p1 = dummyHead, pre = dummyHead, cur = dummyHead;
        for (int i = 1; i <= n; i++) {                                            // Note the tricky loop
            if (i < m) {
                p1 = p1.next;
            }
            else if (i == m) {
                pre = p1.next;
                cur = pre.next;
            }
            else {                                                               // Equals to (n - m) times 
                pre.next = cur.next;
                cur.next = p1.next;
                p1.next = cur;
                cur = pre.next;
            }
        }
        return dummyHead.next;
    }
}
