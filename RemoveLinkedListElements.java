/*
Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5
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
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode p1 = dummyHead;
        ListNode p2 = head;

        while (p2 != null) {
            if (p2.val == val) {
                p1.next = p2.next;
                p2 = p2.next;
            }
            else {
                p2 = p2.next;
                p1 = p1.next;
            }
        }
        return dummyHead.next;
    }
}
