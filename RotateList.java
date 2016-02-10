/*
Given a list, rotate the list to the right by k places, where k is non-negative.
For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
*/
// In my understanding, put the last node to the first, repeat k times. 我的理解是，每次把最后的元素rotate到第一个，重复k次。
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null)
            return head;
        ListNode p = head;
        
        int size = 0;
        while (p != null) {
            size++;
            p = p.next;
        }                                                   // calculate the size of the linkedlist
        
        p = head;
        for (int i = 0; i < size - 1; i++) {
            p = p.next;                                    // Linked the last element to the head, to form circled linkedlist
        }
        p.next = head;
        for (int i = 0; i < size - k % size; i++) {
            p = p.next;
        }
        ListNode dummyHead = p.next;
        p.next = null;
        return dummyHead;
    }
}
