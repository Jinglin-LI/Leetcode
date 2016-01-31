/*
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
(The digits are stored in order)
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        int carry = 0;
        
        while (p1 != null || p2 != null) {
            int v1 = (p1 != null)? p1.val : 0;
            int v2 = (p2 != null)? p2.val : 0;
            int digit = v1 + v2 + carry;
            carry = digit / 10;
            cur.next = new ListNode(digit % 10);
            cur = cur.next;
            if (p1 != null)
                p1 = p1.next;
            if (p2 != null)
                p2 = p2.next;
        }
        if (carry == 1)
            cur.next = new ListNode(1);
        return dummyHead.next;
    }
}
